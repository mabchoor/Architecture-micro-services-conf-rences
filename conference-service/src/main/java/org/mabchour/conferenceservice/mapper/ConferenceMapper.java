package org.mabchour.conferenceservice.mapper;

import org.mabchour.conferenceservice.dto.ConferenceDTO;
import org.mabchour.conferenceservice.dto.ReviewDTO;
import org.mabchour.conferenceservice.entity.Conference;
import org.mabchour.conferenceservice.entity.Review;

import java.util.stream.Collectors;

public class ConferenceMapper {
    public static ConferenceDTO toDto(Conference e) {
        if (e == null) return null;
        ConferenceDTO d = new ConferenceDTO();
        d.setId(e.getId());
        d.setTitre(e.getTitre());
        d.setTypeConference(e.getTypeConference());
        d.setDateConference(e.getDateConference());
        d.setDuree(e.getDuree());
        d.setNombreInscrits(e.getNombreInscrits());
        d.setScore(e.getScore());
        if (e.getReviews() != null) {
            d.setReviews(e.getReviews().stream().map(r -> {
                ReviewDTO rd = new ReviewDTO();
                rd.setId(r.getId());
                rd.setDateReview(r.getDateReview());
                rd.setTexte(r.getTexte());
                rd.setNote(r.getNote());
                return rd;
            }).collect(Collectors.toList()));
        }
        return d;
    }

    public static Conference toEntity(ConferenceDTO d) {
        if (d == null) return null;
        Conference e = new Conference();
        e.setId(d.getId());
        e.setTitre(d.getTitre());
        e.setTypeConference(d.getTypeConference());
        e.setDateConference(d.getDateConference());
        e.setDuree(d.getDuree());
        e.setNombreInscrits(d.getNombreInscrits());
        e.setScore(d.getScore());
        if (d.getReviews() != null) {
            e.setReviews(d.getReviews().stream().map(rd -> {
                Review r = new Review();
                r.setId(rd.getId());
                r.setDateReview(rd.getDateReview());
                r.setTexte(rd.getTexte());
                r.setNote(rd.getNote());
                r.setConference(e);
                return r;
            }).collect(Collectors.toList()));
        }
        return e;
    }
}

