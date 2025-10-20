package org.mabchour.conferenceservice.service;

import org.mabchour.conferenceservice.dto.ConferenceDTO;
import org.mabchour.conferenceservice.entity.Conference;
import org.mabchour.conferenceservice.mapper.ConferenceMapper;
import org.mabchour.conferenceservice.repository.ConferenceRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class ConferenceService {
    private final ConferenceRepository repo;

    public ConferenceService(ConferenceRepository repo) {
        this.repo = repo;
    }

    @CircuitBreaker(name = "conferenceService", fallbackMethod = "findAllFallback")
    public List<ConferenceDTO> findAll() {
        return repo.findAll().stream().map(ConferenceMapper::toDto).collect(Collectors.toList());
    }

    public List<ConferenceDTO> findAllFallback(Throwable t) {
        return Collections.emptyList();
    }

    @CircuitBreaker(name = "conferenceService", fallbackMethod = "saveFallback")
    public ConferenceDTO save(ConferenceDTO dto) {
        Conference e = ConferenceMapper.toEntity(dto);
        Conference saved = repo.save(e);
        return ConferenceMapper.toDto(saved);
    }

    public ConferenceDTO saveFallback(ConferenceDTO dto, Throwable t) {
        // fallback: return original dto or null depending on desired behavior
        return dto;
    }

    @CircuitBreaker(name = "conferenceService", fallbackMethod = "deleteFallback")
    public void delete(Long id) { repo.deleteById(id); }

    public void deleteFallback(Long id, Throwable t) {
        // fallback: no-op or log
    }
}
