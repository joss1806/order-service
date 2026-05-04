package com.company.order.service.impl;

import com.company.order.client.DriverClient;
import com.company.order.dto.*;
import com.company.order.entity.Order;
import com.company.order.exception.*;
import com.company.order.repository.OrderRepository;
import com.company.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

  private final OrderRepository repository;
  private final DriverClient driverClient;

  @Override
  public OrderResponse createOrder(CreateOrderRequest request) {

    Order order = Order.builder()
            .origin(request.getOrigin())
            .destination(request.getDestination())
            .status("CREATED")
            .createdAt(LocalDateTime.now())
            .build();

    return mapToResponse(repository.save(order));
  }

  @Override
  public OrderResponse assignDriver(UUID orderId, UUID driverId) {

    Order order = repository.findById(orderId)
            .orElseThrow(() -> new NotFoundException("Order not found"));

    if (!order.getStatus().equals("CREATED")) {
      throw new BadRequestException("Order must be in CREATED status");
    }

    DriverResponse driver = driverClient.getDriverById(driverId);

    if (!driver.isActive()) {
      throw new BadRequestException("Driver is not active");
    }

    order.setDriverId(driverId);
    order.setStatus("IN_TRANSIT");
    order.setUpdatedAt(LocalDateTime.now());

    return mapToResponse(repository.save(order));
  }

  private OrderResponse mapToResponse(Order order) {
    OrderResponse response = new OrderResponse();
    response.setId(order.getId());
    response.setOrigin(order.getOrigin());
    response.setDestination(order.getDestination());
    response.setStatus(order.getStatus());
    response.setDriverId(order.getDriverId());
    return response;
  }
}