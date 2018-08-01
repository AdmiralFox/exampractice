package com.example.practice.controllers;

import com.example.practice.model.Numbers;
import com.example.practice.services.NumbersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

  @Autowired
  NumbersServices numbersServices;

  @GetMapping("/")
  public String renderPage(Model model) {
    model.addAttribute("numbers", new Numbers());
    model.addAttribute("allId", numbersServices.findAll());
    return "index";
  }

  @PostMapping("/addnew")
  public String addNew(@ModelAttribute Numbers numbers, Model model) {
    numbersServices.saveNumbers(numbers);
    model.addAttribute("msg", numbersServices.messageHandler(numbers));
    model.addAttribute("allId", numbersServices.findAll());
    return "index";
  }

  @PostMapping("/sum")
  public String sumAll(Model model, @ModelAttribute(value = "summary") long id) {
    model.addAttribute("sumnumbers", numbersServices.sumAllNumbers(id));
    model.addAttribute("thenumbers", numbersServices.findById(id));
    return "sum";
  }

  @PostMapping("/squared")
  public String squaredNumbers(@ModelAttribute("squaredById") long id, Model model) {
    model.addAttribute("thenumbers", numbersServices.findById(id));
    model.addAttribute("squaredNumbers", numbersServices.squareAllNumbersById(id));
    return "squared";
  }
}
