package com.dchung.reviewservice.data.repos;

import com.dchung.reviewservice.data.Cuisine;
import org.springframework.data.repository.CrudRepository;

public interface CuisineRepository
    extends CrudRepository<Cuisine, Long> {
}
