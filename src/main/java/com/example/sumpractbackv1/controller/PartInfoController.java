package com.example.sumpractbackv1.controller;

import com.example.sumpractbackv1.model.dto.ResponseDto;
import com.example.sumpractbackv1.model.dto.request.PartInfoRequest;
import com.example.sumpractbackv1.model.dto.search.PartInfoSearchCriteria;
import com.example.sumpractbackv1.model.entity.PartInfo;
import com.example.sumpractbackv1.service.controllersServices.PartInfoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/partInfo")
@RequiredArgsConstructor
public class PartInfoController {
    private final PartInfoService partInfoService;

    @GetMapping
    public ResponseEntity<ResponseDto<PartInfo>> searchPartInfo(@Valid PartInfoSearchCriteria criteria) {
        ResponseDto<PartInfo> result = partInfoService.searchPartInfo(criteria);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<PartInfo> savePartInfo(@Valid @RequestBody PartInfoRequest partInfo) {
        var res = partInfoService.savePartInfo(partInfo);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PartInfo> deletePartInfo(@PathVariable Long id) {
        if (!partInfoService.existsPartInfoById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        partInfoService.deletePartInfoById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
