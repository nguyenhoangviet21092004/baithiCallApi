package com.example.baithii.repository;

import com.example.baithii.model.Nation;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepoNation extends JpaRepository<Nation, Integer> {
    @Query("select n from Nation n where n.nameNation = ?1 ")
    Nation findNation(String name);
}
