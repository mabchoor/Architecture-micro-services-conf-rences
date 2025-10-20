package org.mabchour.conferenceservice.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.*;

@Entity
@Table(name = "conferences")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "reviews")
@EqualsAndHashCode(exclude = "reviews")
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

    // Helper methods pour maintenir la relation bidirectionnelle
    public void addReview(Review review) {
        reviews.add(review);
        review.setConference(this);
    }

    public void removeReview(Review review) {
        reviews.remove(review);
        review.setConference(null);
    }
}
