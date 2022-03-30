package com.example.laboratorioIV.Controller;

import com.example.laboratorioIV.Domain.Journal;
import com.example.laboratorioIV.Domain.Person;
import com.example.laboratorioIV.Service.JournalService;
import com.example.laboratorioIV.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.Instant;
import java.util.Date;

@Controller
public class FrontEndController {
    @Autowired
    JournalService journalService;
    @Autowired
    PersonService personService;

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("journal", journalService.getAll());
        return "index";
    }

    @RequestMapping("/journal")
    public String journalIndex(Model model){
        model.addAttribute("journal", journalService.getAll());
        return "journalIndex";
    }

    @RequestMapping("/person")
    public String personIndex(Model model) {
        model.addAttribute("person", personService.getAll() );
        return "personIndex";
    }

    @RequestMapping(value = "/addJournal", method = RequestMethod.GET)
    public String navAddJournal(Model model) {
        model.addAttribute(new Journal());
        return "addJournal";
    }

    @RequestMapping(value = "/addPerson", method = RequestMethod.GET)
    public String navAddPerson(Model model) {
        model.addAttribute(new Person());
        return "addPerson";
    }

    @RequestMapping(value="/postJournal", method = RequestMethod.POST)
    public String createNewJournal(Journal journal, BindingResult result, Model model) {
        journal.setCreated(Date.from(Instant.now()));
        journalService.saveJournal(journal);
        return "journalIndex";
    }

    @RequestMapping(value="/postPerson", method = RequestMethod.POST)
    public String postPerson(Person person, BindingResult result, Model model) {
        personService.save(person);
        return "personIndex";
    }
}
