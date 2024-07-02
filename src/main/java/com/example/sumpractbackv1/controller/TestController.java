package com.example.sumpractbackv1.controller;

import com.example.sumpractbackv1.service.XmlToDatabase;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping()
public class TestController {

    @Autowired
    private XmlToDatabase xmlToDatabase;

    @GetMapping("/test")
    public void dataInsert(){
        xmlToDatabase.insert();
    }
}
