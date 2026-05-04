package com.company.order.file;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequestMapping("/files")
@RequiredArgsConstructor
public class FileController {

    private final FileService service;

    @PostMapping("/upload/{orderId}")
    public String upload(
            @PathVariable UUID orderId,
            @RequestParam("file") MultipartFile file) {

        return service.uploadFile(orderId, file);
    }
}