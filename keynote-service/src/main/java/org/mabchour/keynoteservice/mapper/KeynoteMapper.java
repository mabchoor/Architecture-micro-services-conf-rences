package org.mabchour.keynoteservice.mapper;

import org.mabchour.keynoteservice.dto.KeynoteDTO;
import org.mabchour.keynoteservice.entity.Keynote;

public class KeynoteMapper {
    public static KeynoteDTO toDto(Keynote e) {
        if (e == null) return null;
        KeynoteDTO d = new KeynoteDTO();
        d.setId(e.getId());
        d.setNom(e.getNom());
        d.setPrenom(e.getPrenom());
        d.setEmail(e.getEmail());
        d.setFonction(e.getFonction());
        return d;
    }

    public static Keynote toEntity(KeynoteDTO d) {
        if (d == null) return null;
        Keynote e = new Keynote();
        e.setId(d.getId());
        e.setNom(d.getNom());
        e.setPrenom(d.getPrenom());
        e.setEmail(d.getEmail());
        e.setFonction(d.getFonction());
        return e;
    }
}

