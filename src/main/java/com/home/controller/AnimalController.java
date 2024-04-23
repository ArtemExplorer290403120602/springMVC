package com.home.controller;

import com.home.model.Animal;
import com.home.model.dto.AnimalCreateDto;
import com.home.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/animal")
public class AnimalController {
    private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping
    public String getAllAnimal(ModelMap modelMap) {
        List<Animal> animals = animalService.getAllAnimal();
        modelMap.addAttribute("animals", animals);
        return "get_animals";
    }

    @GetMapping("/id")
    public String getAnimalById(@RequestParam("id") Long id, ModelMap modelMap) { //TODO: Спросить почему не работает с @PathVariable во всех
        Optional<Animal> animal = animalService.getAnimalById(id);
        if (animal.isPresent()) {
            modelMap.addAttribute("animal", animal.get());
            return "get_animal_by_id";
        }
        return "failed";
    }

    @PostMapping("/id")
    public String deleteAnimal(@RequestParam("id") Long id) {
        return animalService.deleteAnimal(id) ? "cool" : "failed";
    }

    @PostMapping()
    public String createAnimal(@ModelAttribute AnimalCreateDto animalCreateDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                System.out.println(error);
            }
            return "failed";
        }
        boolean br = animalService.createAnimal(animalCreateDto); //TODO: УЗНАТЬ ПОЧЕМУ НЕ МОГУ ДОБАВИТЬ
        return br ? "cool" : "failed";
    }

    @PostMapping("/update")
    public String updateAnimal(@RequestParam("name") String name, @RequestParam("id") Long id, @RequestParam("age") Integer age, @RequestParam("place") String place) {
        return animalService.updateAnimaml(id, name, age, place) ? "cool" : "failed";
    }
    // zcnfeikcwner
}