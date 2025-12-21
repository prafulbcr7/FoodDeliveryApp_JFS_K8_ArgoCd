package com.myApplication.foodCatalogue.service;

import com.myApplication.foodCatalogue.dto.FoodCataloguePage;
import com.myApplication.foodCatalogue.dto.FoodItemDTO;
import com.myApplication.foodCatalogue.dto.Restaurant;
import com.myApplication.foodCatalogue.entity.FoodItem;
import com.myApplication.foodCatalogue.mapper.FoodItemMapper;
import com.myApplication.foodCatalogue.repo.FoodItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class FoodCatalogueService {

    @Autowired
    FoodItemRepo foodItemRepo;

    @Autowired
    FoodItemMapper foodItemMapper;

    @Autowired
    RestTemplate restTemplate;

    public FoodItemDTO addFoodItem(FoodItemDTO foodItemDTO) {
        FoodItem addedFoodItem = foodItemRepo.save(foodItemMapper.foodItemDTOToFoodItem(foodItemDTO));
        return foodItemMapper.foodItemToFoodItemDTO(addedFoodItem);
    }

    public FoodItemDTO getFoodItemsById(Integer foodItemId){
        Optional<FoodItem> foodItem = foodItemRepo.findById(foodItemId);
        return foodItem.map(i -> foodItemMapper.foodItemToFoodItemDTO(i)).orElse(null);
    }

    public FoodCataloguePage getFoodCataloguePageDetails(Integer restaurantId){
        List<FoodItem> foodItemList= getFoodItemsList(restaurantId);
        Restaurant restaurant = getRestaurantsDetails(restaurantId);
        return createFoodCataloguePage(restaurant, foodItemList);
    }

    private List<FoodItem> getFoodItemsList(Integer restaurantId){
        return foodItemRepo.findByRestaurantId(restaurantId);
    }

    private Restaurant getRestaurantsDetails(Integer restaurantId){
        return restTemplate.getForObject("http://RESTAURANT-SERVICE/restaurant/getById/"+restaurantId, Restaurant.class);
    }

    private FoodCataloguePage createFoodCataloguePage(Restaurant restaurant, List<FoodItem> foodItemList){
        FoodCataloguePage foodCataloguePage = new FoodCataloguePage();
        foodCataloguePage.setRestaurant(restaurant);
        foodCataloguePage.setFoodItemsList(foodItemList);
        return foodCataloguePage;
    }
}
