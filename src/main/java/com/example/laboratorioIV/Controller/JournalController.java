package com.example.laboratorioIV.Controller;

import com.example.laboratorioIV.Domain.Journal;
import com.example.laboratorioIV.Service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.Instant;
import java.util.Date;

@Controller
public class JournalController {
    @Autowired
    JournalService journalService;
    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("journal", journalService.getAll());
        return "index";
    }

    @RequestMapping(value = "/agregarEntrada", method = RequestMethod.GET)
    public String navegarPaginaRegistrar(Model model) {
        model.addAttribute(new Journal());
        return "agregarEntrada";
    }

    @RequestMapping(value="/agregarEntrada", method = RequestMethod.POST)
    public String insertarNuevo(Journal journal, BindingResult result, Model model) {
        journal.setCreated(Date.from(Instant.now()));
        journalService.saveJournal(journal);
        return "index";
    }

    @GetMapping(value = "/api-test")
    public String ApiTest() {
        return "Api working";
    }
}
