package com.example.sumpractbackv1.service;

import com.example.sumpractbackv1.model.parser.ParsImportFile;
import com.example.sumpractbackv1.repository.ImportDataRepository;
import com.example.sumpractbackv1.util.Parser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.file.Path;

@Service
@RequiredArgsConstructor
public class XmlToDatabase {
    private final ImportDataRepository importDataRepository;

    public void insert(Path importFilePath) {
        ParsImportFile parsImportFile;
        Parser parser = new Parser();
        parsImportFile = parser.returnPars(importFilePath);

        importDataRepository.save(parsImportFile.toImportData());
        System.out.println("File saved to database");
    }
}

