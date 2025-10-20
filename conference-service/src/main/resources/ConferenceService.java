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
