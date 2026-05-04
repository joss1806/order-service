package com.company.order.file;

import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface FileService {

    String uploadFile(UUID orderId, MultipartFile file);
}