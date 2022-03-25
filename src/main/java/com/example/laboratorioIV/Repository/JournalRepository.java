package com.example.laboratorioIV.Repository;

import com.example.laboratorioIV.Domain.Journal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalRepository extends JpaRepository<Journal, Long> {
}
