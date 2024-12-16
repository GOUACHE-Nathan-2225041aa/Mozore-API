package com.mozore.api.Interface;

import com.mozore.api.Model.Revue;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RevueRepository extends MongoRepository<Revue, String> {

    // Obtenir les revues triées par titre
    List<Revue> findAllBy(Sort sort);

    // Obtenir une revue par son ID
    Revue findBy_id(String id);
}
