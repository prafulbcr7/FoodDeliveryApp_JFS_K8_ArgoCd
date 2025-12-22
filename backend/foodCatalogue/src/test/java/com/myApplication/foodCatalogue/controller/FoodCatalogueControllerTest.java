package com.myApplication.foodCatalogue.controller;

import com.myApplication.foodCatalogue.dto.FoodCataloguePage;
import com.myApplication.foodCatalogue.dto.FoodItemDTO;
import com.myApplication.foodCatalogue.service.FoodCatalogueService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class FoodCatalogueControllerTest {

    @InjectMocks
    FoodCatalogueController foodCatalogueController;

    @Mock
    FoodCatalogueService foodCatalogueService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddFoodItem_ShouldReturnCreatedStatus(){

        FoodItemDTO foodItemDTO = new FoodItemDTO();
        when(foodCatalogueService.addFoodItem(any(FoodItemDTO.class))).thenReturn(foodItemDTO);

        ResponseEntity<FoodItemDTO> response = foodCatalogueController.addFoodItem(foodItemDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(foodItemDTO, response.getBody());
        verify(foodCatalogueService, times(1)).addFoodItem(foodItemDTO);
    }

    @Test
    public void testGetRestaurantsFoodItemsById_ShouldReturnOkStatus(){
        Integer restaurantId = 1;
        FoodCataloguePage foodCataloguePage = new FoodCataloguePage();
        when(foodCatalogueService.getFoodCataloguePageDetails(restaurantId)).thenReturn(foodCataloguePage);

        ResponseEntity<FoodCataloguePage> response = foodCatalogueController.getRestaurantsFoodItemsById(restaurantId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(foodCataloguePage, response.getBody());
        verify(foodCatalogueService, times(1)).getFoodCataloguePageDetails(restaurantId);
    }

}
