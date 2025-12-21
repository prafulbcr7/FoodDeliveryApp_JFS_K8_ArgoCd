package com.myApplication.restaurantlisting.service;

import com.myApplication.restaurantlisting.dto.RestaurantDTO;
import com.myApplication.restaurantlisting.entity.Restaurant;
import com.myApplication.restaurantlisting.mapper.RestaurantMapper;
import com.myApplication.restaurantlisting.repo.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepo restaurantRepo;

    public List<RestaurantDTO> getAllRestaurants() {
        List<Restaurant> listOfRestaurants =  restaurantRepo.findAll();
        //Map entity to DTO and return
        List<RestaurantDTO> listOfRestaurantDTOs = listOfRestaurants.stream()
                .map(i -> RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(i)).collect(Collectors.toList());
        return listOfRestaurantDTOs;
    }

    public ResponseEntity<RestaurantDTO> getRestaurantById(Integer restaurantId){
        Optional<Restaurant> restaurantById = restaurantRepo.findById(restaurantId);
        if(restaurantById.isPresent()){
            return new ResponseEntity<>(RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurantById.get()), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public RestaurantDTO addRestaurantInDb(RestaurantDTO restaurantDto){
        Restaurant restaurant = RestaurantMapper.INSTANCE.mapRestaurantDTOToRestaurant(restaurantDto);
        Restaurant savedRestaurant = restaurantRepo.save(restaurant);
        return RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(savedRestaurant);

    }

}
