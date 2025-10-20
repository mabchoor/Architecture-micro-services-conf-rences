package org.mabchour.conferenceservice.client;

import org.mabchour.conferenceservice.dto.KeynoteDtoForFeign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "keynote-service")
public interface KeynoteClient {
    @GetMapping("/api/keynotes")
    List<KeynoteDtoForFeign> getAllKeynotes();
}

