package com.example.practice.services;

import com.example.practice.model.Numbers;
import com.example.practice.repository.NumbersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NumbersServicesImpl implements NumbersServices {

  @Autowired
  NumbersRepository numbersRepository;

  @Override
  public void saveNumbers(Numbers numbers) {
    if (isItNumber(numbers))
      numbersRepository.save(numbers);
  }

  @Override
  public boolean isItNumber(Numbers numbers) {
    if (numbers.getFirst().matches("^[-+]?\\d+(\\.\\d+)?$")
            && numbers.getSecond().matches("^[-+]?\\d+(\\.\\d+)?$")
            && numbers.getThird().matches("^[-+]?\\d+(\\.\\d+)?$")
            && numbers.getFourth().matches("^[-+]?\\d+(\\.\\d+)?$")) {
      return true;
    }
    return false;
  }

  @Override
  public String messageHandler(Numbers numbers) {
    if (!isItNumber(numbers)) {
      return "Please use numbers";
    }
    return "Your numbers are saved";
  }

  @Override
  public List <Numbers> findAll() {
    return numbersRepository.findAll();
  }

  @Override
  public Integer sumAllNumbers(long id) {
    Numbers numbers = numbersRepository.findById(id);
    return Integer.parseInt(numbers.getFirst()) + Integer.parseInt(numbers.getSecond())
            + Integer.parseInt(numbers.getThird()) + Integer.parseInt(numbers.getFourth());
  }

  @Override
  public Numbers findById(long id) {
    return numbersRepository.findById(id);
  }

  @Override
  public ArrayList <Integer> squareAllNumbersById(long id) {
    ArrayList <Integer> squaredList = new ArrayList <>();
    Numbers numbers = numbersRepository.findById(id);
    squaredList.add(Integer.parseInt(numbers.getFirst()) * Integer.parseInt(numbers.getFirst()));
    squaredList.add(Integer.parseInt(numbers.getSecond()) * Integer.parseInt(numbers.getSecond()));
    squaredList.add(Integer.parseInt(numbers.getThird()) * Integer.parseInt(numbers.getThird()));
    squaredList.add(Integer.parseInt(numbers.getFourth()) * Integer.parseInt(numbers.getFourth()));
    return squaredList;
  }
}