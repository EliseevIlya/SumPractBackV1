package com.example.sumpractbackv1.Services;

import com.example.sumpractbackv1.DBEntity.*;
import com.example.sumpractbackv1.Parser.Parcer;
import com.example.sumpractbackv1.Parser.ParsEntity.*;
import com.example.sumpractbackv1.Repository.*;
import jakarta.transaction.Transactional;
import jakarta.xml.bind.*;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;


import java.io.File;
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


    public void insert() {
        try {
            ED807 ed807;
            Parcer parcer = new Parcer();
            ed807 = parcer.returnParc();

            // Сохранение данных в базу данных
            ImportData importData = new ImportData();
            importData.setXmlns("urn:cbr-ru:ed:v2.0");
            importData.setEDNo(ed807.getEDNo());
            importData.setEDDate(LocalDate.parse(ed807.getEDDate()));
            importData.setEDAuthor(ed807.getEDAuthor());
            importData.setCreationReason(ed807.getCreationReason());
            importData.setCreationDateTime(ZonedDateTime.parse(ed807.getCreationDateTime()));
            importData.setInfoTypeCode(ed807.getInfoTypeCode());
            importData.setBusinessDay(LocalDate.parse(ed807.getBusinessDay()));
            importData.setDirectoryVersion(ed807.getDirectoryVersion());

            try {
                importDataRepository.save(importData);
            } catch (Exception e) {
                // Log and continue
                System.err.println("Duplicate ImportData: " + e.getMessage());
            }

            for (ParsBICDirectoryEntry entry : ed807.getBicDirectoryEntries()) {
                BICDirectoryEntry bicEntry = new BICDirectoryEntry();
                bicEntry.setBIC(entry.getBIC());
                bicEntry.setImportDataBic(importData);

                try {
                    bicDirectoryEntryRepository.save(bicEntry);
                } catch (Exception e) {
                    // Log and continue
                    System.err.println("Duplicate BICDirectoryEntry: " + e.getMessage());
                    continue; // Skip to next entry if this one fails
                }

                if (entry.getParticipantInfos() != null) {
                    for (ParsParticipantInfo pInfo : entry.getParticipantInfos()) {
                        ParticipantInfo participantInfo = new ParticipantInfo();
                        participantInfo.setBicParticipant(bicEntry);
                        participantInfo.setNameP(pInfo.getNameP());
                        participantInfo.setRegN(pInfo.getRegN());
                        participantInfo.setCntrCd(pInfo.getCntrCd());
                        participantInfo.setRgn(pInfo.getRgn());
                        participantInfo.setInd(pInfo.getInd());
                        participantInfo.setNnp(pInfo.getNnp());
                        participantInfo.setAdr(pInfo.getAdr());
                        participantInfo.setDateInParticipant(pInfo.getDateIn());
                        participantInfo.setPtType(pInfo.getPtType());
                        participantInfo.setSrvcs(pInfo.getSrvcs());
                        participantInfo.setXchType(pInfo.getXchType());
                        participantInfo.setUid(pInfo.getUid());
                        participantInfo.setParticipantStatus(pInfo.getParticipantStatus());

                        try {
                            participantInfoRepository.save(participantInfo);
                        } catch (Exception e) {
                            // Log and continue
                            System.err.println("Duplicate ParticipantInfo: " + e.getMessage());
                            continue; // Skip to next participant info if this one fails
                        }

                        if (pInfo.getRstrLists() != null) {
                            for (ParsRstrList rstr : pInfo.getRstrLists()) {
                                RstrList rstrList = new RstrList();
                                rstrList.setParticipantRstrId(participantInfo);
                                rstrList.setRstr(rstr.getRstr());
                                rstrList.setRstrDate(rstr.getRstrDate());

                                try {
                                    rstrListRepository.save(rstrList);
                                } catch (Exception e) {
                                    // Log and continue
                                    System.err.println("Duplicate RstrList: " + e.getMessage());
                                    continue; // Skip to next restriction list if this one fails
                                }
                            }
                        }
                    }
                }

                if (entry.getAccounts() != null) {
                    for (ParsAccounts acc : entry.getAccounts()) {
                        Accounts accounts = new Accounts();
                        accounts.setBicAccounts(bicEntry);
                        accounts.setAccount(acc.getAccount());
                        accounts.setRegulationAccountType(acc.getRegulationAccountType());
                        accounts.setCk(acc.getCk());
                        accounts.setAccountCBRBIC(acc.getAccountCBRBIC());
                        accounts.setDateInAccounts(acc.getDateIn());
                        accounts.setAccountStatus(acc.getAccountStatus());

                        try {
                            accountsRepository.save(accounts);
                        } catch (Exception e) {
                            // Log and continue
                            System.err.println("Duplicate Accounts: " + e.getMessage());
                            continue; // Skip to next account if this one fails
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

