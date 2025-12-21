package com.myApplication.order.service;

import com.myApplication.order.dto.OrderDTO;
import com.myApplication.order.dto.OrderDTOFromFE;
import com.myApplication.order.dto.UserDTO;
import com.myApplication.order.entity.Order;
import com.myApplication.order.mapper.OrderMapper;
import com.myApplication.order.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    SequenceGenerator sequenceGenerator;

    @Autowired
    RestTemplate restTemplate;

    public OrderDTO getOrderDetails(Integer orderId){
        Order orderDetails = orderRepo.findById(orderId).orElse(null);
        if(orderDetails != null) {
            return OrderMapper.INSTANCE.mapOrderToOrderDTO(orderDetails);
        }
        return null;
    }

    public OrderDTO addOrderInToDb(OrderDTOFromFE orderDetails){

        Integer newOrderId = sequenceGenerator.generateNextOrderId();
        UserDTO userDTO = fetchAllUserDTOFromUserId(orderDetails.getUserId());

        Order orderToBeSaved = new Order(newOrderId, userDTO, orderDetails.getRestaurant(), orderDetails.getFoodItemList());
        orderRepo.save(orderToBeSaved);
        return OrderMapper.INSTANCE.mapOrderToOrderDTO(orderToBeSaved);
    }

    private UserDTO fetchAllUserDTOFromUserId(Integer userId){
        return restTemplate.getForObject("http://USER-SERVICE/user/getUserById/"+ userId, UserDTO.class);
    }
}
