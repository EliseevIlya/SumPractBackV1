package com.example.sumpractbackv1.controller;

import com.example.sumpractbackv1.model.dto.ResponseDto;
import com.example.sumpractbackv1.model.dto.search.AccountsSearchCriteria;
import com.example.sumpractbackv1.model.entity.Accounts;
import com.example.sumpractbackv1.service.controllersServices.AccountsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountsController {

    private final AccountsService accountsService;

    @GetMapping("/get")
    public ResponseEntity<ResponseDto<Accounts>> searchAccounts(@Valid AccountsSearchCriteria criteria) {
        ResponseDto<Accounts> result = accountsService.searchAccounts(criteria);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    //TODO логику для прокидывания родителя и дочерних
    @PutMapping("/save")
    public ResponseEntity<Accounts> saveAccounts(@Valid @RequestBody Accounts accounts) {
        accountsService.saveAccount(accounts);
        return new ResponseEntity<>(accounts, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Accounts> deleteAccounts(@PathVariable Long id) {
        if (!accountsService.existsAccountById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        accountsService.deleteAccountById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
