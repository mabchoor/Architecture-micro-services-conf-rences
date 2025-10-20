package org.mabchour.keynoteservice.web;

import org.mabchour.keynoteservice.dto.KeynoteDTO;
import org.mabchour.keynoteservice.service.KeynoteServiceBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/keynotes")
public class KeynoteController {
    private final KeynoteServiceBean service;

    public KeynoteController(KeynoteServiceBean service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<KeynoteDTO>> all() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<KeynoteDTO> getById(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<KeynoteDTO> create(@RequestBody KeynoteDTO dto) {
        KeynoteDTO created = service.create(dto);
        return ResponseEntity.created(URI.create("/api/keynotes/" + created.getId())).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<KeynoteDTO> update(@PathVariable Long id, @RequestBody KeynoteDTO dto) {
        return service.update(id, dto).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

