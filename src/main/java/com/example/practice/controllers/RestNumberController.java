package com.example.practice.controllers;

import com.example.practice.model.Numbers;
import com.example.practice.services.NumbersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestNumberController {

  @Autowired
  NumbersServices numbersServices;

  @GetMapping("/restcontroller")
  public List<Numbers> getAllNumbers() {
    return numbersServices.findAll();
  }
}