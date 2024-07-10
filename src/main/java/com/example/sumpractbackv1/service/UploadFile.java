package com.example.sumpractbackv1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class UploadFile {
    @Value("${file.upload-dir}")
    private String uploadDir;

    private XmlToDatabase xmlToDatabase;

    public ResponseEntity<String> uploadFile(MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Файл не найден");
        }

        try {
            // Сохраняем файл в папку uploadDir
            byte[] bytes = file.getBytes();
            String fileName = file.getName()+ "-"+ LocalDate.now()+"-"+ LocalDateTime.now().getNano()+"-"+file.getOriginalFilename();
            Path path = Paths.get(uploadDir + File.separator + fileName);
            Files.write(path, bytes);

            xmlToDatabase.insert(path);
            return ResponseEntity.status(HttpStatus.OK).body("Файл загружен: " + file.getOriginalFilename());

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ошибка загрузки файла");
        }
    }



}
