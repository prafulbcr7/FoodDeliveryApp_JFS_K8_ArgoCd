package com.myApplication.restaurantlisting.service;

import com.myApplication.restaurantlisting.dto.RestaurantDTO;
import com.myApplication.restaurantlisting.entity.Restaurant;
import com.myApplication.restaurantlisting.mapper.RestaurantMapper;
import com.myApplication.restaurantlisting.repo.RestaurantRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class RestaurantServiceTest {

    @InjectMocks
    RestaurantService restaurantService;

    @Mock
    RestaurantRepo restaurantRepo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

//    @Test
//    public void testGetAllRestaurants(){
//
//        List<Restaurant> mockRestaurants = Arrays.asList(
//                new Restaurant(1, "Restaurant 1", "Address 1", "Number 1", "City 1", "Description 1"),
//                new Restaurant(2, "Restaurant 2", "Address 2", "Number 2", "City 2", "Description 2")
//        );
//
//        when(restaurantRepo.findAll()).thenReturn(mockRestaurants);
//
//        List<RestaurantDTO> responseRestaurantDTOList = restaurantService.getAllRestaurants();
//
//        assertEquals(mockRestaurants.size(), responseRestaurantDTOList.size());
//        for(int i=0; i<mockRestaurants.size(); i++){
//            RestaurantDTO tempDTO = RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(mockRestaurants.get(i));
//            assertEquals(tempDTO, responseRestaurantDTOList.get(i));
//        }
//
//        verify(restaurantRepo, times(1)).findAll();
//    }

}
