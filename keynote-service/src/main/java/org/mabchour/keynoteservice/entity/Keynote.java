package org.mabchour.keynoteservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "keynotes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Keynote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String fonction;
}
