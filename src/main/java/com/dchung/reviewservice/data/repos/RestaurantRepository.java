package com.dchung.reviewservice.data.repos;

import com.dchung.reviewservice.data.Restaurant;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository
    extends CrudRepository<Restaurant, Long> {
}

