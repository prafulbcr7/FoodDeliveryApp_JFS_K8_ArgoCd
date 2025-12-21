package com.myApplication.foodCatalogue.dto;

import com.myApplication.foodCatalogue.entity.FoodItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodCataloguePage {

    private Restaurant restaurant;
    private List<FoodItem> foodItemsList;
}
