package com.example.sumpractbackv1.controller;


import com.example.sumpractbackv1.service.UploadFile;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequiredArgsConstructor
@RequestMapping("/files")
public class ImportController {


    private final UploadFile uploadFile;

    @PostMapping(path = "/upload", consumes = "multipart/form-data")
    public void uploadFile(@RequestParam(value = "file") MultipartFile file) {
        uploadFile.uploadFile(file);

    }

}
