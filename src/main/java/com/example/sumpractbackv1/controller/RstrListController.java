package com.example.sumpractbackv1.controller;

import com.example.sumpractbackv1.model.dto.ResponseDto;
import com.example.sumpractbackv1.model.dto.search.RstrListSearchCriteria;
import com.example.sumpractbackv1.model.entity.RstrList;
import com.example.sumpractbackv1.service.controllersServices.RstrListService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rstrList")
@RequiredArgsConstructor
public class RstrListController {
    private final RstrListService rstrListService;

    @GetMapping
    public ResponseEntity<ResponseDto<RstrList>> searchRstrList(RstrListSearchCriteria criteria) {
        ResponseDto<RstrList> result = rstrListService.searchRstrList(criteria);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    //TODO логику для прокидывания родителя и дочерних

    @PutMapping
    public ResponseEntity<RstrList> saveRstrList(@Valid @RequestBody RstrList rstrList) {
        rstrListService.saveRstrList(rstrList);
        return new ResponseEntity<>(rstrList, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RstrList> deleteRstrList(@PathVariable Long id) {
        if (!rstrListService.existsRstrListById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        rstrListService.deleteRstrListById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
