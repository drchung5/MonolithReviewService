package com.dchung.reviewservice.data.repos;

import com.dchung.reviewservice.data.Restaurant;
import com.dchung.reviewservice.data.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RestaurantRepository
    extends CrudRepository<Restaurant, Long> {

  @Query("select r from Restaurant r where r.cuisine.cuisine_id=:cuisine_id")
  public List<Restaurant> findByRestaurantsByCuisine(@Param("cuisine_id")Long cuisine_id);

}

