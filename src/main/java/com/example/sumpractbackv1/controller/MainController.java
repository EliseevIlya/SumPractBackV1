package com.example.sumpractbackv1.controller;

import com.example.sumpractbackv1.model.dto.response.ImportDataResponse;
import com.example.sumpractbackv1.model.dto.search.*;
import com.example.sumpractbackv1.model.entity.*;
import com.example.sumpractbackv1.service.MainService;
import com.example.sumpractbackv1.service.XmlToDatabase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/main")
public class MainController {

    private final MainService mainService;
    private final XmlToDatabase xmlToDatabase;
    //TODO переписать через ResponseEntity и параметры запроса
    /*
    @GetMapping("/importData")
    public void dataInsert(){
        xmlToDatabase.insert();
    }

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

    @GetMapping("/AccoutsGetT")
    public List<Accounts> accountsGet() {
        return mainService.returnAccountsList();
    }
 */


    @GetMapping("/AccoutsGet")
    public ResponseEntity<List<Accounts>> searchAccounts(@Valid AccountsSearchCriteria criteria) {
        List<Accounts> result = mainService.searchAccounts(criteria);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/AccRstrListGet")
    public ResponseEntity<List<AccRstrList>> searchAccRstrList(@Valid AccRstrListSearchCriteria criteria) {
        List<AccRstrList> result = mainService.searchAccRstrList(criteria);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/BicDirectoryEntryGet")
    public ResponseEntity<List<BICDirectoryEntry>> searchBICDirectoryEntry(@Valid BICDirectoryEntrySearchCriteria criteria) {
        List<BICDirectoryEntry> result = mainService.searchBICDirectoryEntries(criteria);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/ImportDataGet")
    public ResponseEntity<List<ImportDataResponse>> searchImportData(@Valid ImportDataSearchCriteria criteria) {
        List<ImportDataResponse> result = mainService.searchImportData(criteria)
                .stream().map(ImportDataResponse::new).collect(Collectors.toList());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/InitialEDGet")
    public ResponseEntity<List<InitialED>> searchInitialED(@Valid InitialEDSearchCriteria criteria) {
        List<InitialED> result = mainService.searchInitialED(criteria);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/ParticipantInfoGet")
    public ResponseEntity<List<ParticipantInfo>> searchParticipantInfo(@Valid ParticipantInfoSearchCriteria criteria) {
        List<ParticipantInfo> result = mainService.searchParticipantInfo(criteria);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/PartInfoGet")
    public ResponseEntity<List<PartInfo>> searchPartInfo(@Valid PartInfoSearchCriteria criteria) {
        List<PartInfo> result = mainService.searchPartInfo(criteria);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/RstrListGet")
    public ResponseEntity<List<RstrList>> searchRstrList(RstrListSearchCriteria criteria) {
        List<RstrList> result = mainService.searchRstrList(criteria);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/SwbicsGet")
    public ResponseEntity<List<Swbics>> searchSwbics(@Valid SwbicsSearchCriteria criteria) {
        List<Swbics> result = mainService.searchSwbics(criteria);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/UsersGet")
    public ResponseEntity<List<User>> searchUsers(@Valid UserSearchCriteria criteria) {
        List<User> result = mainService.searchUsers(criteria);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
