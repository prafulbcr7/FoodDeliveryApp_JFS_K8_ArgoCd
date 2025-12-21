package com.myApplication.foodCatalogue.repo;

import com.myApplication.foodCatalogue.entity.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodItemRepo extends JpaRepository<FoodItem, Integer> {

    List<FoodItem> findByRestaurantId(Integer restaurantId);
}
