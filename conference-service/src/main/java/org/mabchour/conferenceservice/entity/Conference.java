package org.mabchour.conferenceservice.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "conferences")
public class Conference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;
    private String typeConference; // "academique" or "commerciale"
    private LocalDate dateConference;
    private Integer duree; // en minutes
    private Integer nombreInscrits;
    private Double score;

    @OneToMany(mappedBy = "conference", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

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
    public List<Review> getReviews() { return reviews; }
    public void setReviews(List<Review> reviews) { this.reviews = reviews; }
}

