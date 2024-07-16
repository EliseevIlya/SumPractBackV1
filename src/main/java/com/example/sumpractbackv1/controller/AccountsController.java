package com.example.sumpractbackv1.controller;

import com.example.sumpractbackv1.model.dto.request.AccountsRequest;
import com.example.sumpractbackv1.model.dto.search.AccountsSearchCriteria;
import com.example.sumpractbackv1.model.entity.Accounts;
import com.example.sumpractbackv1.service.controllersServices.AccountsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountsController {
    private final AccountsService accountsService;

    @GetMapping
    public ResponseEntity<List<Accounts>> searchAccounts(@Valid AccountsSearchCriteria criteria) {
        List<Accounts> result = accountsService.searchAccounts(criteria);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
    @PutMapping
    public ResponseEntity<Accounts> saveAccounts(@Valid @RequestBody AccountsRequest accounts) {
        var res = accountsService.saveAccount(accounts);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Accounts> deleteAccounts(@PathVariable Long id) {
        if (!accountsService.existsAccountById(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        accountsService.deleteAccountById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
