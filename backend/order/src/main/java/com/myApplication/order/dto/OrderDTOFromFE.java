package com.myApplication.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTOFromFE {

    private Integer userId;
    private Restaurant restaurant;
    private List<FoodItemDTO> foodItemList;
}
