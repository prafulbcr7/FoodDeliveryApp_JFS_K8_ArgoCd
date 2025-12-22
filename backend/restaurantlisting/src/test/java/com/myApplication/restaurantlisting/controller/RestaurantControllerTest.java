package com.myApplication.restaurantlisting.controller;

import com.myApplication.restaurantlisting.dto.RestaurantDTO;
import com.myApplication.restaurantlisting.service.RestaurantService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RestaurantControllerTest {

    @InjectMocks
    RestaurantController restaurantController;

    @Mock
    RestaurantService restaurantService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllRestaurants(){

        List<RestaurantDTO> mockRestaurentLists = Arrays.asList(
                new RestaurantDTO(1, "Restaurant_1", "Address 1", "number 1", "city_1", "Description-1"),
                new RestaurantDTO(2, "Restaurant_2", "Address 2", "number 2", "city_2", "Description-2" )
        );

        when(restaurantService.getAllRestaurants()).thenReturn(mockRestaurentLists);

        ResponseEntity<List<RestaurantDTO>> response= restaurantController.getAllRestaurants();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockRestaurentLists, response.getBody());

        //Verify that the service method is only called once
        verify(restaurantService, times(1)).getAllRestaurants();
    }

    @Test
    public void testAddRestaurant(){

        RestaurantDTO mockRestaurant = new RestaurantDTO(1, "Restaurant_1", "Address 1", "number 1", "city_1", "Description-1");

        when(restaurantService.addRestaurantInDb(mockRestaurant)).thenReturn(mockRestaurant);

        ResponseEntity<RestaurantDTO> response = restaurantController.addRestaurant(mockRestaurant);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(mockRestaurant, response.getBody());

        verify(restaurantService, times(1)).addRestaurantInDb(mockRestaurant);
    }

    @Test
    public void testGetRestaurantById(){

        Integer mockRestaurantId = 1;
        RestaurantDTO mockRestaurant = new RestaurantDTO(1, "Restaurant_1", "Address 1", "number 1", "city_1", "Description-1");

        when(restaurantService.getRestaurantById(mockRestaurantId)).thenReturn(new ResponseEntity<>(mockRestaurant, HttpStatus.OK));

        ResponseEntity<RestaurantDTO> response = restaurantController.getRestaurantById(mockRestaurantId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockRestaurant, response.getBody());

        verify(restaurantService, times(1)).getRestaurantById(mockRestaurantId);
    }
}
