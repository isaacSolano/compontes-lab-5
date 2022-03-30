package com.example.laboratorioIV.Service;

import com.example.laboratorioIV.Domain.Person;
import com.example.laboratorioIV.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    public void save(Person person) { personRepository.saveAndFlush(person); }
    public List<Person> getAll() { return personRepository.findAll(); }
    public Optional<Person> getOne(Long id) { return personRepository.findById(id); }
    public void delete(Long id) { personRepository.deleteById(id); }
}
