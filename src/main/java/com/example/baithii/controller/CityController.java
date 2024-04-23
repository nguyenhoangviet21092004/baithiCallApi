package com.example.baithii.controller;

import com.example.baithii.model.City;
import com.example.baithii.model.Nation;
import com.example.baithii.repository.IRepoNation;
import com.example.baithii.service.CityService;
import com.example.baithii.service.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;
    @Autowired
    private NationService nationService;
   @Autowired
    private IRepoNation iRepoNation;

    @GetMapping("")
    public String getAll(Model model) {
        List<City> list = cityService.getAll();
        model.addAttribute("listCity", list);
        return "/list";
    }

    @GetMapping("/view/{id}")
    public String viewCity(@PathVariable String id, Model model) {
        Optional<City> city = cityService.findById(Integer.parseInt(id));
        model.addAttribute("city", city.get());
        return "/view";
    }

    @GetMapping("/create")
    public String createCity(Model model) {
        List<Nation> nation = nationService.getNation();

        model.addAttribute("city", new City());
        model.addAttribute("nation", nation);
        return "/create";
    }

    @PostMapping("/save")
    public String saveCity(@ModelAttribute City city, @RequestParam String nation, Model model) {
        city.setNation(nation);
        city.setNameNation(iRepoNation.findNation(nation));
        cityService.save(city);
        return "redirect:/city";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable String id, Model model) {
        Optional<City> city = cityService.findById(Integer.parseInt(id));
        List<Nation> nation = nationService.getNation();
        model.addAttribute("nation", nation);
        model.addAttribute("city", city.get());
        return "/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute City city , @RequestParam String nation){
        Optional<City> city1 = cityService.findById(city.getId());
        cityService.delete(city1.get());
        System.out.println("lllll");
        city.setNation(nation);
        cityService.save(city);
        return "redirect:/city";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id,Model model){
        model.addAttribute("id", id);
        return "/delete";
    }

    @PostMapping("/Delete")
    public String deleteCity(@RequestParam String id ,  Model model){
        cityService.delete(cityService.findById(Integer.parseInt(id)).get());
        return "redirect:/city";
    }

}
