package com.example.sumpractbackv1.controller;

import com.example.sumpractbackv1.model.dto.ResponseDto;
import com.example.sumpractbackv1.model.dto.search.BicDirectoryEntrySearchCriteria;
import com.example.sumpractbackv1.model.entity.BicDirectoryEntry;
import com.example.sumpractbackv1.service.controllersServices.BicDirectoryEntryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bicDirectoryEntry")
@RequiredArgsConstructor
public class BicDirectoryEntryController {

    private final BicDirectoryEntryService bicDirectoryEntryService;

    @GetMapping("/get")
    public ResponseEntity<ResponseDto<BicDirectoryEntry>> searchBICDirectoryEntry(@Valid BicDirectoryEntrySearchCriteria criteria) {
        ResponseDto<BicDirectoryEntry> result = bicDirectoryEntryService.searchBicDirectoryEntries(criteria);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    //TODO логику для прокидывания родителя и дочерних

    @PutMapping("/save")
    public ResponseEntity<BicDirectoryEntry> saveBICDirectoryEntry(@Valid @RequestBody BicDirectoryEntry bicDirectoryEntry) {
        bicDirectoryEntryService.saveBicDirectoryEntry(bicDirectoryEntry);
        return new ResponseEntity<>(bicDirectoryEntry, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<BicDirectoryEntry> deleteBICDirectoryEntry(@PathVariable Long id) {
        if (!bicDirectoryEntryService.existsBicDirectoryEntryById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        bicDirectoryEntryService.deleteBicDirectoryEntryById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
