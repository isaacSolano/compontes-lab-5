package com.example.laboratorioIV.Controller;

import com.example.laboratorioIV.Domain.Person;
import com.example.laboratorioIV.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ApiController {
    @Autowired
    PersonService personService;

    @GetMapping(value = "/api/persons", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Person> getAll() {
        return personService.getAll();
    }

    @PostMapping(value = "/api/persons", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Person post(@RequestBody Person person) {
        personService.save(person);
        return person;
    }

    @PutMapping(value = "api/persons/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String put(@PathVariable Long id, @RequestBody Person person) {
        Optional<Person> foundResult = personService.getOne(id);
        if (foundResult.isPresent()) {
            Person personToEdit = foundResult.get();
            personToEdit.setName(person.getName());
            personService.save(personToEdit);
            return "Person was updated.";
        } else {
            return "Person with id " + id + " not found.";
        }
    }

    @DeleteMapping(value = "api/persons/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String delete(@PathVariable Long id) {
        personService.delete(id);
        return "Delete request has been accepted.";
    }
}
