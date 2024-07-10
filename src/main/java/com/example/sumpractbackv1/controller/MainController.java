package com.example.sumpractbackv1.controller;

import com.example.sumpractbackv1.model.entity.*;
import com.example.sumpractbackv1.service.MainService;
import com.example.sumpractbackv1.service.XmlToDatabase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/main")
public class MainController {

    private final MainService mainService;
    private final XmlToDatabase xmlToDatabase;
    //TODO переписать через ResponseEntity
    /*@GetMapping("/importData")
    public void dataInsert(){
        xmlToDatabase.insert();
    }*/

    @GetMapping("/importDataGet")
    public List<ImportData> getImportData() {
        return mainService.returnImportDataList();
    }

    @GetMapping("/BICGet")
    public List<BICDirectoryEntry> getBIC() {
        return mainService.returnBICDirectoryEntryList();
    }

    @GetMapping("/ParticipantGet")
    public List<ParticipantInfo> getParticipant() {
        return mainService.returnParticipantInfoList();
    }

    @GetMapping("/AccountsGet")
    public List<Accounts> accountsGet() {
        return mainService.returnAccountsList();
    }

    @GetMapping("/RstrGet")
    public List<RstrList> getRstrList() {
        return mainService.returnRstrListList();
    }
}
