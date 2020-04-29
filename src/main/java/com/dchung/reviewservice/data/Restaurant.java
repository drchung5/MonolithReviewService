package com.dchung.reviewservice.data;

import com.dchung.reviewservice.data.Cuisine;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Restaurant {

  protected Restaurant(){}

  public Restaurant(@NotNull String name) {
    this.name = name;
  }

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Long restaurant_id;

  @NotNull
  private String name;

  @ManyToOne
  @JoinColumn(name="cuisine_id")
  public Cuisine cuisine;


}
