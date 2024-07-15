package com.example.sumpractbackv1.controller;

import com.example.sumpractbackv1.model.dto.search.RstrListSearchCriteria;
import com.example.sumpractbackv1.model.entity.RstrList;
import com.example.sumpractbackv1.service.controllersServices.RstrListService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rstrList")
@RequiredArgsConstructor
public class RstrListController {

    private final RstrListService rstrListService;

    @GetMapping("/get")
    public ResponseEntity<List<RstrList>> searchRstrList(RstrListSearchCriteria criteria) {
        List<RstrList> result = rstrListService.searchRstrList(criteria);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    //TODO логику для прокидывания родителя и дочерних

    @PutMapping("/save")
    public ResponseEntity<RstrList> saveRstrList(@Valid @RequestBody RstrList rstrList) {
        rstrListService.saveRstrList(rstrList);
        return new ResponseEntity<>(rstrList, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<RstrList> deleteRstrList(@PathVariable Long id) {
        if (!rstrListService.existsRstrListById(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        rstrListService.deleteRstrListById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}