package com.example.practice.services;

import com.example.practice.model.Numbers;
import java.util.ArrayList;
import java.util.List;

public interface NumbersServices {

  void saveNumbers(Numbers numbers);
  boolean isItNumber(Numbers numbers);
  String messageHandler(Numbers numbers);
  List<Numbers> findAll();
  Integer sumAllNumbers(long id);
  Numbers findById(long id);
  ArrayList<Integer> squareAllNumbersById(long id);
}
