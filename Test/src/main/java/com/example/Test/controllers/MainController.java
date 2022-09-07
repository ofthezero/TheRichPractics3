package com.example.Test.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/")
    public String greeting( Model model) {
        model.addAttribute("name", "Главная страница");
        return "hello";
    }

    @GetMapping("/calc")
    public String Calc(Model model)
    {
        model.addAttribute("name", 167);
        return "hello";
    }

    @GetMapping("/getres")
    public String GetResult(
            @RequestParam(
                    value = "variable3",
                    required = false,
                    defaultValue = "1") int a,
            @RequestParam(
                    value = "variable4",
                    required = false,
                    defaultValue = "2") int b,
            @RequestParam(
                    value = "select1",
                    required = false) int d,
            Model model)
    {
        int c = 0;
        if (d == 1)
        {
            c=a+b;
        }
        else if (d == 2)
        {
            c = a-b;
        }
        else if (d == 3)
        {
            c = a*b;
        }
        else if (d == 4)
        {
            c = a/b;
        }
        model.addAttribute("answer", c);
        return "result";
    }

    @PostMapping("/res")
    public String PostResult(
            @RequestParam(
                    value = "variable",
                    required = false,
                    defaultValue = "1") int a,
            @RequestParam(
                    value = "variable2",
                    required = false,
                    defaultValue = "2") int b,
            @RequestParam(
                    value = "select",
                    required = false) int d,
            Model model)
    {
        int c = 0;
        if (d == 1)
        {
            c=a+b;
        }
        else if (d == 2)
        {
            c = a-b;
        }
        else if (d == 3)
        {
            c = a*b;
        }
        else if (d == 4)
        {
            c = a/b;
        }
        model.addAttribute("answer", c);
        return "result";
    }
}
