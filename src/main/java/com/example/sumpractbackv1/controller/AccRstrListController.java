package com.example.sumpractbackv1.controller;

import com.example.sumpractbackv1.model.dto.ResponseDto;
import com.example.sumpractbackv1.model.dto.request.AccRstrListRequest;
import com.example.sumpractbackv1.model.dto.search.AccRstrListSearchCriteria;
import com.example.sumpractbackv1.model.entity.AccRstrList;
import com.example.sumpractbackv1.service.controllersServices.AccRstrListService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accRstrList")
@RequiredArgsConstructor
public class AccRstrListController {
    private final AccRstrListService accRstrListService;

    @GetMapping
    public ResponseEntity<ResponseDto<AccRstrList>> searchAccRstrList(@Valid AccRstrListSearchCriteria criteria) {
        ResponseDto<AccRstrList> result = accRstrListService.searchAccRstrList(criteria);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<AccRstrList> saveAccRstrList(@Valid @RequestBody AccRstrListRequest accRstrList) {
        var res = accRstrListService.saveAccRstrList(accRstrList);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AccRstrList> deleteAccRstrList(@PathVariable Long id) {
        if (!accRstrListService.existsAccRstrListById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        accRstrListService.deleteAccRstrListById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
