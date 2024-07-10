package com.example.sumpractbackv1.service;

import com.example.sumpractbackv1.model.entity.*;
import com.example.sumpractbackv1.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@RequiredArgsConstructor
@Service
public class MainService {

    @Autowired
    private ImportDataRepository importDataRepository;
    @Autowired
    private BICDirectoryEntryRepository bicDirectoryEntryRepository;
    @Autowired
    private ParticipantInfoRepository participantInfoRepository;
    @Autowired
    private AccountsRepository accountsRepository;
    @Autowired
    private RstrListRepository rstrListRepository;

    public List<ImportData> returnImportDataList() {
        return importDataRepository.findAll();
    }

    public List<BICDirectoryEntry> returnBICDirectoryEntryList() {
        return bicDirectoryEntryRepository.findAll();
    }

    public List<ParticipantInfo> returnParticipantInfoList() {
        return participantInfoRepository.findAll();
    }

    public List<Accounts> returnAccountsList() {
        return accountsRepository.findAll();
    }

    public List<RstrList> returnRstrListList() {
        return rstrListRepository.findAll();
    }

}
