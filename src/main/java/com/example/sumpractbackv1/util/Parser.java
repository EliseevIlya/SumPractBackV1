package com.example.sumpractbackv1.util;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.nio.file.Path;

import com.example.sumpractbackv1.model.parser.ParsImportFile;

public class Parser {

    public ParsImportFile returnPars(Path path) {
        ParsImportFile parsImportFile;
        try {
            // Создание JAXB контекста и анмаршаллера
            JAXBContext jaxbContext = JAXBContext.newInstance(ParsImportFile.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            // Парсинг XML файла
            File xmlFile = new File(path.toString());
            parsImportFile = (ParsImportFile) unmarshaller.unmarshal(xmlFile);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        return parsImportFile;
    }
    
}
