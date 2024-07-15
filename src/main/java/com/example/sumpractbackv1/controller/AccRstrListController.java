package com.example.sumpractbackv1.controller;

import com.example.sumpractbackv1.model.dto.search.AccRstrListSearchCriteria;
import com.example.sumpractbackv1.model.entity.AccRstrList;
import com.example.sumpractbackv1.service.controllersServices.AccRstrListService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accRstrList")
@RequiredArgsConstructor
public class AccRstrListController {

    private final AccRstrListService accRstrListService;

    @GetMapping("/get")
    public ResponseEntity<List<AccRstrList>> searchAccRstrList(@Valid AccRstrListSearchCriteria criteria) {
        List<AccRstrList> result = accRstrListService.searchAccRstrList(criteria);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    //TODO логику для прокидывания родителя и дочерних

    @PutMapping("/create")
    public ResponseEntity<AccRstrList> createAccRstrList(@Valid @RequestBody AccRstrList accRstrList) {
        accRstrListService.saveAccRstrList(accRstrList);
        return new ResponseEntity<>(accRstrList, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<AccRstrList> deleteAccRstrList(@PathVariable Long id) {
        if (!accRstrListService.existsAccRstrListById(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        accRstrListService.deleteAccRstrListById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
