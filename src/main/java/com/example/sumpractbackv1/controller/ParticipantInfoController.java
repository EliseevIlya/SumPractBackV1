package com.example.sumpractbackv1.controller;

import com.example.sumpractbackv1.model.dto.ResponseDto;
import com.example.sumpractbackv1.model.dto.search.ParticipantInfoSearchCriteria;
import com.example.sumpractbackv1.model.entity.ParticipantInfo;
import com.example.sumpractbackv1.service.controllersServices.ParticipantInfoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/participantInfo")
@RequiredArgsConstructor
public class ParticipantInfoController {
    private final ParticipantInfoService participantInfoService;

    @GetMapping
    public ResponseEntity<ResponseDto<ParticipantInfo>> searchParticipantInfo(@Valid ParticipantInfoSearchCriteria criteria) {
        ResponseDto<ParticipantInfo> result = participantInfoService.searchParticipantInfo(criteria);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    //TODO логику для прокидывания родителя и дочерних

    @PutMapping
    public ResponseEntity<ParticipantInfo> saveParticipantInfo(@Valid @RequestBody ParticipantInfo participantInfo) {
        participantInfoService.saveParticipantInfo(participantInfo);
        return new ResponseEntity<>(participantInfo, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ParticipantInfo> deleteParticipantInfo(@PathVariable Long id) {
        if (!participantInfoService.existsParticipantInfoById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        participantInfoService.deleteParticipantInfoById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
