package com.company.order.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "orders")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

  @Id
  @GeneratedValue
  private UUID id;

  private String origin;
  private String destination;

  private String status;

  private UUID driverId;

  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}