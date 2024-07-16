package com.example.sumpractbackv1.controller;

import com.example.sumpractbackv1.model.dto.ResponseDto;
import com.example.sumpractbackv1.model.dto.search.SwbicsSearchCriteria;
import com.example.sumpractbackv1.model.entity.Swbics;
import com.example.sumpractbackv1.service.controllersServices.SwbicsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/swbics")
@RequiredArgsConstructor
public class SwbicsController {

    private final SwbicsService swbicsService;

    @GetMapping("/get")
    public ResponseEntity<ResponseDto<Swbics>> searchSwbics(@Valid SwbicsSearchCriteria criteria) {
        ResponseDto<Swbics> result = swbicsService.searchSwbics(criteria);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    //TODO логику для прокидывания родителя и дочерних

    @PutMapping("/save")
    public ResponseEntity<Swbics> saveSwbics(@Valid @RequestBody Swbics swbics) {
        swbicsService.saveSwbics(swbics);
        return new ResponseEntity<>(swbics, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Swbics> deleteSwbics(@PathVariable Long id) {
        if (!swbicsService.existsSwbicsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        swbicsService.deleteSwbicsById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
