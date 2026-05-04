package com.company.order.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class OrderResponse {

    private UUID id;
    private String origin;
    private String destination;
    private String status;
    private UUID driverId;
}