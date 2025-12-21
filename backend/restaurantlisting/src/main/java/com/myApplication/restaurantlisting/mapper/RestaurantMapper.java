package com.myApplication.restaurantlisting.mapper;

import com.myApplication.restaurantlisting.dto.RestaurantDTO;
import com.myApplication.restaurantlisting.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RestaurantMapper {

    RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);

    RestaurantDTO mapRestaurantToRestaurantDTO(Restaurant restaurant);

    Restaurant mapRestaurantDTOToRestaurant(RestaurantDTO restaurantDTO);
}
