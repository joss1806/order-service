package com.company.order.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderFile {

    @Id
    @GeneratedValue
    private UUID id;

    private String fileName;
    private String fileType;
    private String filePath;

    private UUID orderId;
}