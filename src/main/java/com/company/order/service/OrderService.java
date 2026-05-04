package com.company.order.service;

import com.company.order.dto.*;

import java.util.UUID;

public interface OrderService {

  OrderResponse createOrder(CreateOrderRequest request);

  OrderResponse assignDriver(UUID orderId, UUID driverId);
}