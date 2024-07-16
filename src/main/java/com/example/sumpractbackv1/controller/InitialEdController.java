package com.example.sumpractbackv1.controller;

import com.example.sumpractbackv1.model.dto.ResponseDto;
import com.example.sumpractbackv1.model.dto.search.InitialEdSearchCriteria;
import com.example.sumpractbackv1.model.entity.InitialEd;
import com.example.sumpractbackv1.service.controllersServices.InitialEdService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/initialEd")
@RequiredArgsConstructor
public class InitialEdController {

    private final InitialEdService initialEdService;

    @GetMapping("/get")
    public ResponseEntity<ResponseDto<InitialEd>> searchInitialED(@Valid InitialEdSearchCriteria criteria) {
        ResponseDto<InitialEd> result = initialEdService.searchInitialEd(criteria);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    //TODO логику для прокидывания родителя и дочерних

    @PutMapping("/save")
    public ResponseEntity<InitialEd> saveInitialED(@Valid @RequestBody InitialEd initialEd) {
        initialEdService.saveInitialED(initialEd);
        return new ResponseEntity<>(initialEd, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<InitialEd> deleteInitialED(@PathVariable Long id) {
        if (!initialEdService.existsInitialEDById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        initialEdService.deleteInitialEDById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
