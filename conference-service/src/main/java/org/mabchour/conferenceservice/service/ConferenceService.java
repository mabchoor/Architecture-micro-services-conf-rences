package org.mabchour.conferenceservice.service;

import org.mabchour.conferenceservice.dto.ConferenceDTO;
import org.mabchour.conferenceservice.entity.Conference;
import org.mabchour.conferenceservice.mapper.ConferenceMapper;
import org.mabchour.conferenceservice.repository.ConferenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConferenceService {
    private final ConferenceRepository repo;

    public ConferenceService(ConferenceRepository repo) {
        this.repo = repo;
    }

    public List<ConferenceDTO> findAll() {
        return repo.findAll().stream().map(ConferenceMapper::toDto).collect(Collectors.toList());
    }

    public ConferenceDTO save(ConferenceDTO dto) {
        Conference e = ConferenceMapper.toEntity(dto);
        Conference saved = repo.save(e);
        return ConferenceMapper.toDto(saved);
    }

    public void delete(Long id) { repo.deleteById(id); }
}

