package org.mabchour.conferenceservice.dto;

import java.time.LocalDate;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {
    private Long id;
    private LocalDate dateReview;
    private String texte;
    private Integer note;
}

