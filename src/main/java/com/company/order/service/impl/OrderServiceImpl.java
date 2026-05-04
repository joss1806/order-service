
package com.company.order.service.impl;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.*;
import com.company.order.service.OrderService;
import com.company.order.entity.Order;
import com.company.order.repository.OrderRepository;

@Service @RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
  private final OrderRepository repo;
  public Order create(Order o){ o.setStatus("CREATED"); return repo.save(o); }
  public List<Order> findAll(){ return repo.findAll(); }
}
