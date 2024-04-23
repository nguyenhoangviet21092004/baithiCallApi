package com.example.baithii.controller.api;

import com.example.baithii.controller.CityController;
import com.example.baithii.model.City;
import com.example.baithii.repository.IRepoNation;
import com.example.baithii.service.CityService;
import com.example.baithii.service.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/city")
public class CityResController {

    @Autowired
    private CityService cityService;
    @Autowired
    private NationService nationService;
    @Autowired
    private IRepoNation iRepoNation;

    @GetMapping("")
    public ResponseEntity<List<City>> getAll(){
       List<City> list =  cityService.getAll();
       if (list.isEmpty()){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<City> findCity(@PathVariable String id){
       Optional<City> city =  cityService.findById(Integer.parseInt(id));
       if (city.isEmpty()){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
        return new ResponseEntity<>(city.get(),HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<City> create(@RequestBody City city){
        cityService.save(city);
        return new ResponseEntity<>(city,HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<City> edit(@PathVariable String id , @RequestBody City city){
        Optional<City> city1 =  cityService.findById(Integer.parseInt(id));
        if (city1.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        cityService.delete(city1.get());
        cityService.save(city);
        return new ResponseEntity<>(city,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<City> delete(@PathVariable String id){
        Optional<City> city =  cityService.findById(Integer.parseInt(id));

        if (city.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        cityService.delete(city.get());
        return new ResponseEntity<>(city.get(),HttpStatus.OK);
    }
}
