package org.mabchour.keynoteservice.service;

import org.mabchour.keynoteservice.dto.KeynoteDTO;
import org.mabchour.keynoteservice.entity.Keynote;
import org.mabchour.keynoteservice.mapper.KeynoteMapper;
import org.mabchour.keynoteservice.repository.KeynoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class KeynoteServiceBean {
    private final KeynoteRepository repo;

    public KeynoteServiceBean(KeynoteRepository repo) {
        this.repo = repo;
    }

    public List<KeynoteDTO> findAll() {
        return repo.findAll().stream().map(KeynoteMapper::toDto).collect(Collectors.toList());
    }

    public Optional<KeynoteDTO> findById(Long id) {
        return repo.findById(id).map(KeynoteMapper::toDto);
    }

    public KeynoteDTO create(KeynoteDTO dto) {
        Keynote entity = KeynoteMapper.toEntity(dto);
        Keynote saved = repo.save(entity);
        return KeynoteMapper.toDto(saved);
    }

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

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
