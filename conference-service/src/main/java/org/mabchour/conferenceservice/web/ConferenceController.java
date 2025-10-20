package org.mabchour.conferenceservice.web;

import org.mabchour.conferenceservice.client.KeynoteClient;
import org.mabchour.conferenceservice.dto.ConferenceDTO;
import org.mabchour.conferenceservice.dto.KeynoteDtoForFeign;
import org.mabchour.conferenceservice.service.ConferenceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conferences")
public class ConferenceController {
    private final ConferenceService service;
    private final KeynoteClient keynoteClient;

    public ConferenceController(ConferenceService service, KeynoteClient keynoteClient) {
        this.service = service;
        this.keynoteClient = keynoteClient;
    }

    @GetMapping
    public ResponseEntity<List<ConferenceDTO>> all() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConferenceDTO> getById(@PathVariable Long id) {
        return service.findAll().stream().filter(c -> c.getId().equals(id)).findFirst()
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ConferenceDTO> create(@RequestBody ConferenceDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/keynotes")
    public ResponseEntity<List<KeynoteDtoForFeign>> keynotes() {
        return ResponseEntity.ok(keynoteClient.getAllKeynotes());
    }
}

