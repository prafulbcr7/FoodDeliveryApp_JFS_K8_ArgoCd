package com.myApplication.restaurantlisting.controller;

import com.myApplication.restaurantlisting.dto.RestaurantDTO;
import com.myApplication.restaurantlisting.service.RestaurantService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
@CrossOrigin
@Tag(name = "Restaurant", description = "Restaurant Service APIs")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/allRestaurants")
    @Operation(summary = "Get all restaurants", description = "Retrieves a list of all restaurants")
    public ResponseEntity<List<RestaurantDTO>> getAllRestaurants(){
        List<RestaurantDTO> allRestaurants = restaurantService.getAllRestaurants();
        return new ResponseEntity<>(allRestaurants, HttpStatus.OK);
    }

    @GetMapping("getById/{restaurantId}")
    @Operation(summary = "Get restaurant by ID", description = "Retrieves a restaurant by its ID")
    public ResponseEntity<RestaurantDTO> getRestaurantById(@PathVariable Integer restaurantId){
        return restaurantService.getRestaurantById(restaurantId);
    }

    @PostMapping("/addRestaurant")
    @Operation(summary = "Add a new restaurant", description = "Creates a new restaurant in the database")
    public ResponseEntity<RestaurantDTO> addRestaurant(@RequestBody RestaurantDTO restaurantDto){
        RestaurantDTO restaurantAdded = restaurantService.addRestaurantInDb(restaurantDto);
        return new ResponseEntity<>(restaurantAdded, HttpStatus.CREATED);
    }
}
