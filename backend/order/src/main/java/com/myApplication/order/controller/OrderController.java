package com.myApplication.order.controller;

import com.myApplication.order.dto.OrderDTO;
import com.myApplication.order.dto.OrderDTOFromFE;
import com.myApplication.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/addOrder")
    public ResponseEntity<OrderDTO> addOrder(@RequestBody OrderDTOFromFE orderDetails){
        OrderDTO orderSavedInDb = orderService.addOrderInToDb(orderDetails);
        return new ResponseEntity<>(orderSavedInDb, HttpStatus.OK);
    }

    @GetMapping("/getOrderDetails/{orderId}")
    public ResponseEntity<OrderDTO> getOrderDetails(@PathVariable Integer orderId){
        OrderDTO orderDTO = orderService.getOrderDetails(orderId);
        if(orderDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(orderDTO, HttpStatus.OK);
    }
}
