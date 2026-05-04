package com.company.order.controller;

import com.company.order.dto.*;
import com.company.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

  private final OrderService service;

  @PostMapping
  public OrderResponse create(@RequestBody CreateOrderRequest request) {
    return service.createOrder(request);
  }

  @PostMapping("/{orderId}/assign/{driverId}")
  public OrderResponse assignDriver(
          @PathVariable UUID orderId,
          @PathVariable UUID driverId) {

    return service.assignDriver(orderId, driverId);
  }
}