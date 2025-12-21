package com.myApplication.foodCatalogue.controller;

import com.myApplication.foodCatalogue.dto.FoodCataloguePage;
import com.myApplication.foodCatalogue.dto.FoodItemDTO;
import com.myApplication.foodCatalogue.service.FoodCatalogueService;
import org.apache.coyote.Response;
import org.bouncycastle.asn1.ocsp.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/foodCatalogue")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class FoodCatalogueController {

    @Autowired
    private FoodCatalogueService foodCatalogueService;

    @PostMapping("/addFoodItem")
    public ResponseEntity<FoodItemDTO> addFoodItem(@RequestBody FoodItemDTO foodItemDTO){
        FoodItemDTO foodItemAdded = foodCatalogueService.addFoodItem(foodItemDTO);
        return new ResponseEntity<>(foodItemAdded, HttpStatus.CREATED);
    }

    @GetMapping("/getFoodItems/{id}")
    public ResponseEntity<FoodItemDTO> getFoodItems(@PathVariable Integer id){
        FoodItemDTO foodItems = foodCatalogueService.getFoodItemsById(id);
        return new ResponseEntity<>(foodItems, HttpStatus.OK);
    }

    @GetMapping("/getRestaurantsFoodItemsById/{restaurantId}")
    public ResponseEntity<FoodCataloguePage> getRestaurantsFoodItemsById(@PathVariable Integer restaurantId) {
        FoodCataloguePage foodCataloguePageDetails = foodCatalogueService.getFoodCataloguePageDetails(restaurantId);
        return new ResponseEntity<>(foodCataloguePageDetails, HttpStatus.OK);
    }
}
