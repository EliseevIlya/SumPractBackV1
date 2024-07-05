package com.example.sumpractbackv1.parser;

import com.example.sumpractbackv1.parser.ParsEntity.ParsImportFile;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;

public class Parcer {

    public ParsImportFile returnParc() {
        ParsImportFile parsImportFile;
        try {
            // Создание JAXB контекста и анмаршаллера
            JAXBContext jaxbContext = JAXBContext.newInstance(ParsImportFile.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            // Парсинг XML файла
            File xmlFile = new File("D:\\file2.xml");
            parsImportFile = (ParsImportFile) unmarshaller.unmarshal(xmlFile);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        return parsImportFile;
    }
}
