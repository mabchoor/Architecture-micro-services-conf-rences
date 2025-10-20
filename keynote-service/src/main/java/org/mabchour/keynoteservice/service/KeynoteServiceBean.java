package org.mabchour.keynoteservice.service;

import org.mabchour.keynoteservice.dto.KeynoteDTO;
import org.mabchour.keynoteservice.entity.Keynote;
import org.mabchour.keynoteservice.mapper.KeynoteMapper;
import org.mabchour.keynoteservice.repository.KeynoteRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class KeynoteServiceBean {
    private final KeynoteRepository repo;

    public KeynoteServiceBean(KeynoteRepository repo) {
        this.repo = repo;
    }

    @CircuitBreaker(name = "keynoteService", fallbackMethod = "findAllFallback")
    public List<KeynoteDTO> findAll() {
        return repo.findAll().stream().map(KeynoteMapper::toDto).collect(Collectors.toList());
    }

    public List<KeynoteDTO> findAllFallback(Throwable t) {
        // fallback: return empty list or cached value
        return Collections.emptyList();
    }

    @CircuitBreaker(name = "keynoteService", fallbackMethod = "findByIdFallback")
    public Optional<KeynoteDTO> findById(Long id) {
        return repo.findById(id).map(KeynoteMapper::toDto);
    }

    public Optional<KeynoteDTO> findByIdFallback(Long id, Throwable t) {
        return Optional.empty();
    }

    @CircuitBreaker(name = "keynoteService", fallbackMethod = "createFallback")
    public KeynoteDTO create(KeynoteDTO dto) {
        Keynote entity = KeynoteMapper.toEntity(dto);
        Keynote saved = repo.save(entity);
        return KeynoteMapper.toDto(saved);
    }

    public KeynoteDTO createFallback(KeynoteDTO dto, Throwable t) {
        // fallback: return the dto as-is (or null) — keeping DTO to avoid 500 in controller
        return dto;
    }

    @CircuitBreaker(name = "keynoteService", fallbackMethod = "updateFallback")
    public Optional<KeynoteDTO> update(Long id, KeynoteDTO dto) {
        return repo.findById(id).map(existing -> {
            existing.setNom(dto.getNom());
            existing.setPrenom(dto.getPrenom());
            existing.setEmail(dto.getEmail());
            existing.setFonction(dto.getFonction());
            Keynote saved = repo.save(existing);
            return KeynoteMapper.toDto(saved);
        });
    }

    public Optional<KeynoteDTO> updateFallback(Long id, KeynoteDTO dto, Throwable t) {
        return Optional.empty();
    }

    @CircuitBreaker(name = "keynoteService", fallbackMethod = "deleteFallback")
    public void delete(Long id) {
        repo.deleteById(id);
    }

    public void deleteFallback(Long id, Throwable t) {
        // fallback: no-op or log; for now no-op
    }
}
