package com.myApplication.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private Integer orderId;
    private UserDTO userDTO;
    private Restaurant restaurant;
    private List<FoodItemDTO> foodItemList;
}
