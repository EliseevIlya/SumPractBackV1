package com.example.sumpractbackv1.service;

import com.example.sumpractbackv1.model.parser.*;
import com.example.sumpractbackv1.repository.*;
import com.example.sumpractbackv1.util.Parser;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class XmlToDatabase {
    private final ImportDataRepository importDataRepository;

    public void insert() {
        ParsImportFile parsImportFile;
        Parser parser = new Parser();
        parsImportFile = parser.returnPars();

        importDataRepository.save(parsImportFile.toImportData());
    }
}

