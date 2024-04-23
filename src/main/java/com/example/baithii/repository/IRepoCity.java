package com.example.baithii.repository;

import com.example.baithii.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepoCity extends JpaRepository<City,Integer> {
}
