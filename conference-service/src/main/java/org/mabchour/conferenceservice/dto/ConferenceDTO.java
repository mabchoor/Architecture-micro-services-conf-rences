package org.mabchour.conferenceservice.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ConferenceDTO {
    private Long id;
    private String titre;
    private String typeConference;
    private LocalDate dateConference;
    private Integer duree;
    private Integer nombreInscrits;
    private Double score;
    private List<ReviewDTO> reviews = new ArrayList<>();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }
    public String getTypeConference() { return typeConference; }
    public void setTypeConference(String typeConference) { this.typeConference = typeConference; }
    public LocalDate getDateConference() { return dateConference; }
    public void setDateConference(LocalDate dateConference) { this.dateConference = dateConference; }
    public Integer getDuree() { return duree; }
    public void setDuree(Integer duree) { this.duree = duree; }
    public Integer getNombreInscrits() { return nombreInscrits; }
    public void setNombreInscrits(Integer nombreInscrits) { this.nombreInscrits = nombreInscrits; }
    public Double getScore() { return score; }
    public void setScore(Double score) { this.score = score; }
    public List<ReviewDTO> getReviews() { return reviews; }
    public void setReviews(List<ReviewDTO> reviews) { this.reviews = reviews; }
}

