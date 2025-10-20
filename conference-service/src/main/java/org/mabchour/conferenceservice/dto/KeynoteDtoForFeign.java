package org.mabchour.conferenceservice.dto;

public class KeynoteDtoForFeign {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String fonction;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getFonction() { return fonction; }
    public void setFonction(String fonction) { this.fonction = fonction; }
}
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

