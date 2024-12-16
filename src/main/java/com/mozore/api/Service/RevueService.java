package com.mozore.api.Service;

import com.mozore.api.Interface.RevueRepository;
import com.mozore.api.Model.Revue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RevueService {

    @Autowired
    private RevueRepository revueRepository;

    // Obtenir toutes les revues triées par titre
    public List<Revue> getRevuesParTitre() {
        return revueRepository.findAllBy(Sort.by(Sort.Direction.ASC, "titre_film"));
    }

    // Obtenir toutes les revues triées par note
    public List<Revue> getRevuesParNote() {
        return revueRepository.findAllBy(Sort.by(Sort.Direction.DESC, "note"));
    }

    // Obtenir une revue par son ID
    public Revue getUneRevueAvecSonId(String id) {
        return revueRepository.findBy_id(id);
    }

    // Ajouter une nouvelle revue
    public Revue ajouterRevue(Revue revue) {
        return revueRepository.save(revue);
    }

    // Mettre à jour une revue existante
    public Revue modifierRevue(String id, Revue revue) {
        Revue existingRevue = revueRepository.findBy_id(id);
        if (existingRevue != null) {
            existingRevue.setTitre_Film(revue.getTitre_Film());
            existingRevue.setImage_Film(revue.getImage_Film());
            existingRevue.setContenu_Revue(revue.getContenu_Revue());
            existingRevue.setNote(revue.getNote());
            return revueRepository.save(existingRevue);
        }
        return null;
    }

    // Supprimer une revue par ID
    public void supprimerRevue(String id) {
        revueRepository.deleteById(id);
    }
}
