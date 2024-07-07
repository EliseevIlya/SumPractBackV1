package com.example.sumpractbackv1.service;

import com.example.sumpractbackv1.model.entity.*;
import com.example.sumpractbackv1.model.parser.*;
import com.example.sumpractbackv1.repository.*;
import com.example.sumpractbackv1.util.Parser;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.*;


@Service
@RequiredArgsConstructor
public class XmlToDatabase {

    //@Autowired
    private final AccountsRepository accountsRepository;
    //@Autowired
    private final BICDirectoryEntryRepository bicDirectoryEntryRepository;
    //@Autowired
    private final ImportDataRepository importDataRepository;
    //@Autowired
    private final ParticipantInfoRepository participantInfoRepository;
    //@Autowired
    private final RstrListRepository rstrListRepository;
    private final AccRstrListRepository accRstrListRepository;
    private final InitialEdRepository initialEdRepository;
    private final PartInfoRepository partInfoRepository;
    private final SwbicsRepository swbicsRepository;


    public void insert() {
        try {
            ParsImportFile parsImportFile;
            Parser parser = new Parser();
            parsImportFile = parser.returnParc();

            //TODO переделать все под Build или дополнить парсер

            // Сохранение данных в базу данных
            /*ImportData importData = new ImportData();
            importData.setXmlns("urn:cbr-ru:ed:v2.0");
            importData.setEdno(parsImportFile.getEdno());
            importData.setEdDate(parsImportFile.getEdDate());
            importData.setEdAuthor(Long.valueOf(parsImportFile.getEdAuthor()));
            importData.setCreationReason(parsImportFile.getCreationReason());
            importData.setCreationDateTime(parsImportFile.getCreationDateTime());
            importData.setInfoTypeCode(parsImportFile.getInfoTypeCode());
            importData.setBusinessDay(parsImportFile.getBusinessDay());
            importData.setDirectoryVersion(parsImportFile.getDirectoryVersion());*/

            if (parsImportFile != null) {
                ImportData importData = ImportData.builder()
                        .xmlns("urn:cbr-ru:ed:v2.0")
                        .edno(parsImportFile.getEdno())
                        .edDate(parsImportFile.getEdDate() != null ? LocalDate.parse(parsImportFile.getEdDate()) : null)
                        .edAuthor(parsImportFile.getEdAuthor())
                        .edReceiver(parsImportFile.getEdReceiver())
                        .creationReason(parsImportFile.getCreationReason())
                        .creationDateTime(parsImportFile.getCreationDateTime() != null ? ZonedDateTime.parse(parsImportFile.getCreationDateTime()) : null)
                        .infoTypeCode(parsImportFile.getInfoTypeCode())
                        .businessDay(parsImportFile.getBusinessDay() != null ? LocalDate.parse(parsImportFile.getBusinessDay()) : null)
                        .directoryVersion(parsImportFile.getDirectoryVersion())
                        .creationTimeImport(LocalDate.now())
                        .build();


                try {
                    importDataRepository.save(importData);
                } catch (Exception e) {
                    // Log and continue
                    System.err.println("Error in ImportData: " + e.getMessage());
                }
            }

            if (parsImportFile.getParsPartInfo() != null){
                for (ParsPartInfo partInfoFile : parsImportFile.getParsPartInfo()){

                    PartInfo partInfo =  PartInfo.builder()
                            .partNo(partInfoFile.getPartNo())
                            .partQuantity(partInfoFile.getPartQuantity())
                            .partAggregateID(partInfoFile.getPartAggregateID())
                            .creationTimePartInfo(LocalDate.now())
                            .build();

                    try {
                        partInfoRepository.save(partInfo);
                    } catch (Exception e) {
                        // Log and continue
                        System.err.println("Error in PartInfo: " + e.getMessage());
                        continue; // Skip to next entry if this one fails
                    }

                }
            }

            if (parsImportFile.getParsInitialED() != null){
                for (ParsInitialED parsInitialED : parsImportFile.getParsInitialED()){
                    InitialED initialED = InitialED.builder()
                            .ednoInitial(parsInitialED.getEdno())
                            .edDateInitial(parsInitialED.getEdDate() != null ? LocalDate.parse(parsInitialED.getEdDate()) : null)
                            .edAuthorInitial(parsInitialED.getEdAuthor())
                            .build();

                    try {
                        initialEdRepository.save(initialED);
                    } catch (Exception e) {
                        // Log and continue
                        System.err.println("Error in InitialEd: " + e.getMessage());
                        continue; // Skip to next entry if this one fails
                    }
                }
            }

            if (parsImportFile.getParsBICDirectoryEntries() != null){
                for (ParsBICDirectoryEntry entry : parsImportFile.getParsBICDirectoryEntries()) {
                    BICDirectoryEntry bicEntry =  BICDirectoryEntry.builder()
                            .bic(entry.getBic())
                            .changeType(entry.getChangeType())
                            .creationTimeBicd(LocalDate.now())
                            .build();
                    try {
                        bicDirectoryEntryRepository.save(bicEntry);
                    } catch (Exception e) {
                        // Log and continue
                        System.err.println("Error in BicDirectoryEntry: " + e.getMessage());
                        continue; // Skip to next entry if this one fails
                    }

                    if (entry.getParsParticipantInfos() != null) {
                        for (ParsParticipantInfo pInfo : entry.getParsParticipantInfos()) {
                            ParticipantInfo participantInfo =  ParticipantInfo.builder()
                                    .nameP(pInfo.getNameP())
                                    .englName(pInfo.getEngName())
                                    .regN(pInfo.getRegN())
                                    .cntrCd(pInfo.getCntrCd())
                                    .rgn(pInfo.getRgn())
                                    .ind(pInfo.getInd())
                                    .tnp(pInfo.getTnp())
                                    .nnp(pInfo.getNnp())
                                    .adr(pInfo.getAdr())
                                    .prntBIC(pInfo.getPrntBIC())
                                    .dateInParticipant(pInfo.getDateIn() != null ? LocalDate.parse(pInfo.getDateIn()) : null)
                                    .dateOutParticipant(pInfo.getDateOut() != null ? LocalDate.parse(pInfo.getDateOut()) : null)
                                    .ptType(pInfo.getPtType())
                                    .srvcs(pInfo.getSrvcs())
                                    .xchType(pInfo.getXchType())
                                    .uid(pInfo.getUid())
                                    .participantStatus(pInfo.getParticipantStatus())
                                    .creationTimeParticipantInfo(LocalDate.now())
                                    .build();

                            try {
                                participantInfoRepository.save(participantInfo);
                            } catch (Exception e) {
                                // Log and continue
                                System.err.println("Error in ParticipantInfo: " + e.getMessage());
                                continue; // Skip to next participant info if this one fails
                            }

                            if (pInfo.getParsRstrList() != null) {
                                for (ParsRstrList parsRstrList : pInfo.getParsRstrList()) {
                                    RstrList rstrList =  RstrList.builder()
                                            .rstr(parsRstrList.getRstr())
                                            .rstrDate(parsRstrList.getRstrDate() != null ? LocalDate.parse(parsRstrList.getRstrDate()) : null)
                                            .creationTimeRstrList(LocalDate.now())
                                            .build();

                                    try {
                                        rstrListRepository.save(rstrList);
                                    } catch (Exception e) {
                                        // Log and continue
                                        System.err.println("Error in RstrList: " + e.getMessage());
                                        continue; // Skip to next restriction list if this one fails
                                    }
                                }
                            }
                        }
                    }

                    if (entry.getParsSwbics() != null) {
                        for (ParsSwbics parsSwbics : entry.getParsSwbics()) {
                            Swbics swbics = Swbics.builder()
                                    .swbic(parsSwbics.getSwbic())
                                    .defaultSwbic(parsSwbics.getDefaultSWBIC())
                                    .creationTimeSwibcs(LocalDate.now())
                                    .build();

                            try {
                                swbicsRepository.save(swbics);
                            } catch (Exception e) {
                                // Log and continue
                                System.err.println("Error in RstrList: " + e.getMessage());
                                continue; // Skip to next restriction list if this one fails
                            }

                        }
                    }

                    if (entry.getParsAccounts() != null) {
                        for (ParsAccounts parsAccounts : entry.getParsAccounts()) {
                            Accounts accounts =  Accounts.builder()
                                    .account(parsAccounts.getAccount())
                                    .regulationAccountType(parsAccounts.getRegulationAccountType())
                                    .ck(parsAccounts.getCk())
                                    .accountCbrbic(parsAccounts.getAccountCBRBIC())
                                    .dateInAccounts(parsAccounts.getDateIn() != null ?   LocalDate.parse(parsAccounts.getDateIn()) : null)
                                    .dateOutAccounts(parsAccounts.getDateOut() != null ? LocalDate.parse(parsAccounts.getDateOut()) : null)
                                    .accountStatus(parsAccounts.getAccountStatus())
                                    .creationTimeAccounts(LocalDate.now())
                                    .build();

                            try {
                                accountsRepository.save(accounts);
                            } catch (Exception e) {
                                // Log and continue
                                System.err.println("Duplicate Accounts: " + e.getMessage());
                                continue; // Skip to next account if this one fails
                            }

                            if (parsAccounts.getParsAccRstrList() != null){
                                for (ParsAccRstrList parsAccRstrList : parsAccounts.getParsAccRstrList()) {
                                    AccRstrList accRstrList = AccRstrList.builder()
                                            .accRstr(parsAccRstrList.getAccRstr())
                                            .accRstrDate(parsAccRstrList.getAccRstrDate() != null ? LocalDate.parse(parsAccRstrList.getAccRstrDate()) : null)
                                            .successorBIC(parsAccRstrList.getSuccessorBIC())
                                            .creationTimeAccRstrList(LocalDate.now())
                                            .build();

                                    try {
                                        accRstrListRepository.save(accRstrList);
                                    } catch (Exception e) {
                                        // Log and continue
                                        System.err.println("Duplicate Accounts: " + e.getMessage());
                                        continue; // Skip to next account if this one fails
                                    }
                                }
                            }
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

