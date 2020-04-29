package com.dchung.reviewservice.data;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Review {

  protected Review(){}

  public Review(
      @NotNull String review_text,
      @NotNull int rating,
      @NotNull Restaurant restaurant) {
    this.review_text = review_text;
    this.rating = rating;
    this.restaurant = restaurant;
  }

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Long review_id;

  @NotNull
  private String review_text;

  @NotNull
  private int rating;

  @ManyToOne
  @JoinColumn(name="restaurant_id")
  public Restaurant restaurant;


}
