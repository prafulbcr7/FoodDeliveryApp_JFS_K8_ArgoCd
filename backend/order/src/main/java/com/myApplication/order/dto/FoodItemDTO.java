package com.myApplication.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodItemDTO {

    private Integer id;

    private String itemName;
    private String itemDescription;
    private Boolean veg;

    private Number price;
    private Integer restaurantId;

    private Integer quantity;
}
