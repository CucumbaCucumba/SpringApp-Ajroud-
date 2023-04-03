package com.ala.tp.repo;

import com.ala.tp.entities.film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface filmRepo extends JpaRepository<film, Integer> {
    public List<film>findByAnneeparution(int n);
    public List<film>findByCategorieId(int id);
}
