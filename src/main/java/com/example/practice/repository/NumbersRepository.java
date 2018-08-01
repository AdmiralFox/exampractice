package com.example.practice.repository;


import com.example.practice.model.Numbers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NumbersRepository extends CrudRepository<Numbers, Long> {
  List<Numbers> findAll();
  Numbers findById(long id);
}

