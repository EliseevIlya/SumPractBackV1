package com.example.sumpractbackv1.service;

import com.example.sumpractbackv1.model.dto.search.*;
import com.example.sumpractbackv1.model.entity.*;
import com.example.sumpractbackv1.repository.*;
import com.example.sumpractbackv1.util.specifications.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
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
    @Autowired
    private AccRstrListRepository accRstrListRepository;
    @Autowired
    private InitialEdRepository initialEDRepository;
    @Autowired
    private PartInfoRepository partInfoRepository;
    @Autowired
    private SwbicsRepository swbicsRepository;
    @Autowired
    private UserRepository userRepository;

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

    public List<Accounts> searchAccounts(AccountsSearchCriteria criteria) {
        Specification<Accounts> spec = AccountsSpecifications.byCriteria(criteria);
        return accountsRepository.findAll(spec);
    }

    public List<AccRstrList> searchAccRstrList(AccRstrListSearchCriteria criteria) {
        Specification<AccRstrList> spec = AccRstrListSpecifications.byCriteria(criteria);
        return accRstrListRepository.findAll(spec);
    }

    public List<BICDirectoryEntry> searchBICDirectoryEntries(BicDirectoryEntrySearchCriteria criteria) {
        Specification<BICDirectoryEntry> spec = BicDirectoryEntrySpecifications.byCriteria(criteria);
        return bicDirectoryEntryRepository.findAll(spec);
    }

    public List<ImportData> searchImportData(ImportDataSearchCriteria criteria) {
        Specification<ImportData> spec = ImportDataSpecifications.byCriteria(criteria);
        return importDataRepository.findAll(spec);
    }

    public List<InitialED> searchInitialED(InitialEdSearchCriteria criteria) {
        Specification<InitialED> spec = InitialEdSpecifications.byCriteria(criteria);
        return initialEDRepository.findAll(spec);
    }

    public List<ParticipantInfo> searchParticipantInfo(ParticipantInfoSearchCriteria criteria) {
        Specification<ParticipantInfo> spec = ParticipantInfoSpecifications.byCriteria(criteria);
        return participantInfoRepository.findAll(spec);
    }

    public List<PartInfo> searchPartInfo(PartInfoSearchCriteria criteria) {
        Specification<PartInfo> spec = PartInfoSpecifications.byCriteria(criteria);
        return partInfoRepository.findAll(spec);
    }

    public List<RstrList> searchRstrList(RstrListSearchCriteria criteria) {
        Specification<RstrList> spec = RstrListSpecifications.byCriteria(criteria);
        return rstrListRepository.findAll(spec);
    }

    public List<Swbics> searchSwbics(SwbicsSearchCriteria criteria) {
        Specification<Swbics> spec = SwbicsSpecifications.byCriteria(criteria);
        return swbicsRepository.findAll(spec);
    }

    public List<User> searchUsers(UserSearchCriteria criteria) {
        Specification<User> spec = UserSpecifications.byCriteria(criteria);
        return userRepository.findAll(spec);
    }

}
