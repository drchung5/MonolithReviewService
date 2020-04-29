package com.dchung.reviewservice.controllers;

import com.dchung.reviewservice.data.Restaurant;
import com.dchung.reviewservice.data.repos.RestaurantRepository;
import com.google.common.collect.Iterables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("restaurants")
public class RestaurantController {

  @Autowired
  private RestaurantRepository restaurantRepository;

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