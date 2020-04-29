package com.dchung.reviewservice.controllers;

import com.dchung.reviewservice.data.Cuisine;
import com.dchung.reviewservice.data.Restaurant;
import com.dchung.reviewservice.data.repos.CuisineRepository;
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
@RequestMapping("cuisines")
public class CuisineController {

  @Autowired
  private CuisineRepository cuisineRepository;

  @GetMapping(value= "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Restaurant> getRestaurant(@PathVariable("id") Long id) {
    Optional<Cuisine> cusineWrapper = cuisineRepository.findById(id);
    if(!cusineWrapper.isPresent()) {
      return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity(cusineWrapper.get(),HttpStatus.OK);
  }

  @GetMapping(produces= MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity getAllCuisines() {
    Iterable<Cuisine> cuisines = cuisineRepository.findAll();
    if( Iterables.size(cuisines) == 0 ) {
      return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity(cuisines,HttpStatus.OK);
  }

  @PostMapping(consumes = "application/json")
  public ResponseEntity<Void> insertCuisine(
      @RequestBody Cuisine cuisine,
      UriComponentsBuilder builder) {
    Cuisine c = cuisineRepository.save(cuisine);
    HttpHeaders headers = new HttpHeaders();
    headers.setLocation(builder.path("/cuisines/{id}").
        buildAndExpand(c.getCuisine_id()).toUri());
    return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
  }

}