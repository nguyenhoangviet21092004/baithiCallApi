package com.example.baithii.service;

import com.example.baithii.model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICityService {
    List<City> getAll();
    Optional<City> findById(int id);
    void  save(City city);
    void delete(City city);
    Page<City> searchCity(int id);


}
