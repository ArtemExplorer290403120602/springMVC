package com.home.service;

import com.home.model.Animal;
import com.home.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {
    private final AnimalRepository animalRepository;
    private final Animal animal;

    @Autowired
    public AnimalService(AnimalRepository animalRepository, Animal animal) {
        this.animalRepository = animalRepository;
        this.animal = animal;
    }

    //находим всех животных
    public List<Animal> getAllAnimal() {
        return animalRepository.findAllAnimal();
    }

    //находим животных по id
    public Optional<Animal> getAnimalById(Long id) {
        return Optional.ofNullable(animalRepository.findAnimalById(id));
    }

    //удаляем животное
    public Boolean deleteAnimal(Long id) {
        return animalRepository.deleteAnimal(id);
    }

    //добавляем животное
    public Boolean createAnimal(String name, Integer age, String place) {
        Animal animal1 = new Animal();
        animal1.setName(name);
        animal1.setAge(age);
        animal1.setPlace(place);
        animal1.setBirth(Timestamp.valueOf(LocalDateTime.now()));
        return animalRepository.createAnimal(animal1);
    }

    //обновляем животное
    public Boolean updateAnimaml(Long id, String name, Integer age, String place) {
        Optional<Animal> animalOptional = Optional.ofNullable(animalRepository.findAnimalById(id));
        if (animalOptional.isPresent()) {
            Animal animalVallidate = animalOptional.get();
            if (name != null) {
                animalVallidate.setName(name);
            }
            if (age != null) {
                animalVallidate.setAge(age);
            }
            if (place != null) {
                animalVallidate.setPlace(place);
            }
            animalVallidate.setBirth(Timestamp.valueOf(LocalDateTime.now()));
            return animalRepository.updateAnimal(animalVallidate);
        }
        return false;
    }
}
