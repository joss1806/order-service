package com.company.order.client;

import com.company.order.dto.DriverResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@FeignClient(name = "driver-service", url = "http://driver-service:8082")
public interface DriverClient {

    @GetMapping("/drivers/{id}")
    DriverResponse getDriverById(@PathVariable UUID id);
}