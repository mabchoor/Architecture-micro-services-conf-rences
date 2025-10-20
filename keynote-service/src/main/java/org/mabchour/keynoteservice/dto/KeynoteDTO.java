package org.mabchour.keynoteservice.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KeynoteDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String fonction;
}
