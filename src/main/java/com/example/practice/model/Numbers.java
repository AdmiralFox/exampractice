package com.example.practice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Numbers {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String first;
  private String second;
  private String third;
  private String fourth;

  public Numbers() {
  }

  public Numbers(String first, String second, String third, String fourth) {
    this.first = first;
    this.second = second;
    this.third = third;
    this.fourth = fourth;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getFirst() {
    return first;
  }

  public void setFirst(String first) {
    this.first = first;
  }

  public String getSecond() {
    return second;
  }

  public void setSecond(String second) {
    this.second = second;
  }

  public String getThird() {
    return third;
  }

  public void setThird(String third) {
    this.third = third;
  }

  public String getFourth() {
    return fourth;
  }

  public void setFourth(String fourth) {
    this.fourth = fourth;
  }
}