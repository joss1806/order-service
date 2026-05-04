
package com.company.order.controller;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.util.*;
import com.company.order.service.OrderService;
import com.company.order.entity.Order;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
  private final OrderService service;

  @PostMapping
  public Order create(@RequestBody Order o){ return service.create(o); }

  @GetMapping
  public List<Order> list(){ return service.findAll(); }
}
