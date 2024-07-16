package com.example.sumpractbackv1.controller;

import com.example.sumpractbackv1.model.dto.search.ImportDataSearchCriteria;
import com.example.sumpractbackv1.model.entity.ImportData;
import com.example.sumpractbackv1.service.controllersServices.ImportDataService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/importData")
@RequiredArgsConstructor
public class ImportDataController {
    private final ImportDataService importDataService;
    // @ApiResponse(content = @Content(
    //     array = @ArraySchema(schema = @Schema(implementation = ImportDataResponse.class))
    // ))
    @GetMapping
    public ResponseEntity<List<ImportData>> searchImportData(@Valid ImportDataSearchCriteria criteria) {
        List<ImportData> result = importDataService.searchImportData(criteria);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    //TODO логику для прокидывания родителя и дочерних

    @PutMapping
    public ResponseEntity<ImportData> saveImportData(@Valid @RequestBody ImportData criteria) {
        importDataService.saveImportData(criteria);
        return new ResponseEntity<>(criteria, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ImportData> deleteImportData(@PathVariable Long id) {
        if (!importDataService.existsImportDataById(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        importDataService.deleteImportDataById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
