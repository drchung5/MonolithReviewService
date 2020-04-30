package com.dchung.reviewservice.controllers;

import com.dchung.reviewservice.data.BestRestaurant;
import com.dchung.reviewservice.data.Restaurant;
import com.dchung.reviewservice.data.Review;
import com.dchung.reviewservice.data.repos.RestaurantRepository;
import com.dchung.reviewservice.data.repos.ReviewRepository;
import com.google.common.collect.Iterables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("restaurants")
public class RestaurantController {

  @Autowired
  private RestaurantRepository restaurantRepository;

  @Autowired
  private ReviewRepository reviewRepository;

  @GetMapping(value= "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Restaurant> getRestaurant(@PathVariable("id") Long id) {
    Optional<Restaurant> restaurantWrapper = restaurantRepository.findById(id);
    if(!restaurantWrapper.isPresent()) {
      return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity(restaurantWrapper.get(),HttpStatus.OK);
  }

  @GetMapping(produces= MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity getAllRestaurants() {
    Iterable<Restaurant> restaurants = restaurantRepository.findAll();
    if( Iterables.size(restaurants) == 0 ) {
      return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity(restaurants,HttpStatus.OK);
  }

  @GetMapping(value="/best", produces= MediaType.APPLICATION_JSON_VALUE)
  public BestRestaurant getBestRestaurantByCategory(@RequestParam("cuisine_id") Long id) {

    List<Restaurant> restaurants = restaurantRepository.findByRestaurantsByCuisine(id);

    BestRestaurant bestRestaurant = new BestRestaurant();

    String bestName = "";
    float bestRating = 0.0f;

    for( Restaurant restaurant : restaurants ) {

      List<Review> reviews = reviewRepository.findByRestaurant(restaurant.getRestaurant_id());

      int sumRating = 0;

      for( Review review : reviews ) {
        sumRating += review.getRating();
        System.out.println( restaurant.getName() + " : " + review.getRating() );
      }

      float avgRating = 0;
      if( sumRating > 0 ) {
        avgRating = sumRating / reviews.size();
      }

      if( avgRating > bestRestaurant.getAvgReview() ) {
        bestRestaurant.setAvgReview( avgRating );
        bestRestaurant.setRestaurant_id( restaurant.getRestaurant_id() );
      }

    }

    return bestRestaurant;
  }

  @PostMapping(consumes = "application/json")
  public ResponseEntity<Void> insertRestaurant(
      @RequestBody Restaurant restaurant,
      UriComponentsBuilder builder) {
    Restaurant r = restaurantRepository.save(restaurant);
    HttpHeaders headers = new HttpHeaders();
    headers.setLocation(builder.path("/restaurants/{id}").
        buildAndExpand(r.getRestaurant_id()).toUri());
    return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
  }

}