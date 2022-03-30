package com.example.laboratorioIV.Repository;

import com.example.laboratorioIV.Domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
