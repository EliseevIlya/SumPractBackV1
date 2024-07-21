package com.example.sumpractbackv1.controller;

import com.example.sumpractbackv1.model.dto.ResponseDto;
import com.example.sumpractbackv1.model.dto.request.ImportDataRequest;
import com.example.sumpractbackv1.model.dto.search.ImportDataSearchCriteria;
import com.example.sumpractbackv1.model.entity.ImportData;
import com.example.sumpractbackv1.service.controllersServices.ImportDataService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/importData")
@RequiredArgsConstructor
public class ImportDataController {
    private final ImportDataService importDataService;


    @GetMapping
    public ResponseEntity<ResponseDto<ImportData>> searchImportData(@Valid ImportDataSearchCriteria criteria) {
        ResponseDto<ImportData> result = importDataService.searchImportData(criteria);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ImportData> saveImportData(@Valid @RequestBody ImportDataRequest criteria) {
        var result = importDataService.saveImportData(criteria);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ImportData> deleteImportData(@PathVariable Long id) {
        if (!importDataService.existsImportDataById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        importDataService.deleteImportDataById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
