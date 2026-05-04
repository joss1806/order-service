package com.company.order.file;

import com.company.order.entity.OrderFile;
import com.company.order.repository.OrderFileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final OrderFileRepository repository;

    private final String UPLOAD_DIR = "uploads/";

    @Override
    public String uploadFile(UUID orderId, MultipartFile file) {

        // VALIDACIONES
        String contentType = file.getContentType();

        if (!(contentType.equals("application/pdf") ||
                contentType.equals("image/png") ||
                contentType.equals("image/jpeg"))) {

            throw new RuntimeException("Invalid file type");
        }

        try {
            File dir = new File(UPLOAD_DIR);
            if (!dir.exists()) dir.mkdirs();

            String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
            String filePath = UPLOAD_DIR + fileName;

            file.transferTo(new File(filePath));

            OrderFile orderFile = OrderFile.builder()
                    .fileName(fileName)
                    .fileType(contentType)
                    .filePath(filePath)
                    .orderId(orderId)
                    .build();

            repository.save(orderFile);

            return filePath;

        } catch (IOException e) {
            throw new RuntimeException("Error saving file");
        }
    }
}