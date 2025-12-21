package com.myApplication.order.entity;

import com.myApplication.order.dto.FoodItemDTO;
import com.myApplication.order.dto.Restaurant;
import com.myApplication.order.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("order")
public class Order {

    private Integer orderId;
    private UserDTO userDTO;
    private Restaurant restaurant;
    private List<FoodItemDTO> foodItemList;
}
