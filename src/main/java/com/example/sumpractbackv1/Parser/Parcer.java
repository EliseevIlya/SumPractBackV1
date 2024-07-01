package com.example.sumpractbackv1.Parser;

import com.example.sumpractbackv1.Parser.ParsEntity.ED807;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;

public class Parcer {

    public ED807 returnParc() {
        ED807 ed807;
        try {
            // Создание JAXB контекста и анмаршаллера
            JAXBContext jaxbContext = JAXBContext.newInstance(ED807.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            // Парсинг XML файла
            File xmlFile = new File("D:\\file.xml");
            ed807 = (ED807) unmarshaller.unmarshal(xmlFile);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        return ed807;
    }
}
