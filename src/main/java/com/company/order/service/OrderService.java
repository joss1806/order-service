
package com.company.order.service;
import java.util.*;
import com.company.order.entity.Order;

public interface OrderService {
  Order create(Order o);
  List<Order> findAll();
}
