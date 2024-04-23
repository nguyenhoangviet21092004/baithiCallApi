package com.example.baithii.service;

import com.example.baithii.model.City;
import com.example.baithii.repository.IRepoCity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService implements  ICityService{

    @Autowired
    private IRepoCity iRepoCity;

    @Override
    public List<City> getAll() {
        return iRepoCity.findAll();
    }

    @Override
    public Optional<City> findById(int id) {
        return iRepoCity.findById(id);
    }

    @Override
    public void save(City city) {
        iRepoCity.save(city);
    }

    @Override
    public void delete(City city) {
        iRepoCity.delete(city);
    }

    @Override
    public Page<City> searchCity(int id) {
        return null;
    }
}
