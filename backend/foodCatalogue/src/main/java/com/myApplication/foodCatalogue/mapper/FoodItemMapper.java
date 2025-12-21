package com.myApplication.foodCatalogue.mapper;

import com.myApplication.foodCatalogue.dto.FoodItemDTO;
import com.myApplication.foodCatalogue.entity.FoodItem;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface FoodItemMapper {

    FoodItemDTO foodItemToFoodItemDTO(FoodItem foodItem);

    FoodItem foodItemDTOToFoodItem(FoodItemDTO foodItemDTO);
}
