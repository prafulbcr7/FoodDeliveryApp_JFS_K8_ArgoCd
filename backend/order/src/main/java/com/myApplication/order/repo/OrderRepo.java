package com.myApplication.order.repo;

import com.myApplication.order.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  OrderRepo extends MongoRepository<Order, Integer> {

}
