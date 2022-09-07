package com.example.Test.controllers;

import com.example.Test.models.News;
import com.example.Test.models.Passport;
import com.example.Test.repositories.PassportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/passport")
public class PassportController {

    @Autowired
    private PassportRepository passportRepository;

    @GetMapping("/")
    public String index(Model model)
    {
        Iterable<Passport> passport = passportRepository.findAll();
        model.addAttribute("passport",passport);
        return "passport/indes";
    }

    @GetMapping("/adds")
    public String addView(Model model)
    {
        return "passport/adds-passport";
    }

    @PostMapping("/adds")
    public String adds(
            @RequestParam("name") String name,
            @RequestParam("surname") String surname,
            @RequestParam("petronymic") String petronymic,
            @RequestParam("snils_number") Integer snils_number,
            @RequestParam("oms_number") Integer oms_number,
            Model model)
    {
        Passport passportOne = new Passport(name,surname,petronymic,snils_number,oms_number);
        passportRepository.save(passportOne);
        return "redirect:/passport/";
    }
    @GetMapping("/searpassport")
    public String adds(
            @RequestParam("name") String name,
            Model model)
    {
        List<Passport> passportList = passportRepository.findByName(name);
        model.addAttribute("passport",passportList);

        return "passport/indes";
    }

    @GetMapping("/{id}")
    public String read(
            @PathVariable("id") Long id,
            Model model)
    {
        Optional<Passport> passport = passportRepository.findById(id);
        ArrayList<Passport> passportArrayList = new ArrayList<>();
        passport.ifPresent(passportArrayList::add);
        model.addAttribute("passport",passportArrayList);
        return "passport/info-passport";
    }
    @GetMapping("/del/{id}")
    public String del(
            @PathVariable("id") Long id
    )
    {
        Passport passport = passportRepository.findById(id).orElseThrow();
        passportRepository.delete(passport);

        //passportRepository.deleteById(id);
        return "redirect:/passport/";
    }
    @GetMapping("/edit/{id}")
    public String edit(
            @PathVariable("id") Long id,
            Model model
    )
    {
        if (!passportRepository.existsById(id)) {
            return "redirect:/passport/";
        }

        Optional<Passport> passport = passportRepository.findById(id);
        ArrayList<Passport> passportArrayList = new ArrayList<>();
        passport.ifPresent(passportArrayList::add);
        model.addAttribute("passport", passportArrayList);
        return "passport/edit-passport";
    }
    @PostMapping("/edit/{id}")
    public String editPassport(
            @PathVariable("id") Long id,
            @RequestParam("name") String name,
            @RequestParam("surname") String surname,
            @RequestParam("petronymic") String petronymic,
            @RequestParam("snils_number") Integer snils_number,
            @RequestParam("oms_number") Integer oms_number,
            Model model
    )
    {

        Passport passport = passportRepository.findById(id).orElseThrow();

        passport.setName(name);
        passport.setSurname(surname);
        passport.setPetronymic(petronymic);
        passport.setSnils_number(snils_number);
        passport.setOms_number(oms_number);

        passportRepository.save(passport);

        return "redirect:/passport/";
    }

}
