package com.example.laboratorioIV.Service;

import com.example.laboratorioIV.Domain.Journal;
import com.example.laboratorioIV.Repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JournalService {
    @Autowired
    JournalRepository journalRepository;

    public void saveJournal(Journal journal){
        journalRepository.save(journal);
    }
    public List<Journal> getAll(){
        return journalRepository.findAll();
    }
}
