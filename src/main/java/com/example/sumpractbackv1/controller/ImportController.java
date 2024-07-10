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


    private UploadFile uploadFile;

    @PostMapping("/upload")
    public void uploadFile(@RequestParam("file") MultipartFile file) {
        uploadFile.uploadFile(file);

    }

}
