package com.example.baithii.service;

import com.example.baithii.model.Nation;
import com.example.baithii.repository.IRepoNation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NationService implements INationService{
    @Autowired
    private IRepoNation iRepoNation;

    @Override
    public List<Nation> getNation() {
        return iRepoNation.findAll();
    }
}
