package com.example.sumpractbackv1.service;

import com.example.sumpractbackv1.entity.*;
import com.example.sumpractbackv1.enums.*;
import com.example.sumpractbackv1.parser.Parcer;
import com.example.sumpractbackv1.parser.ParsEntity.*;
import com.example.sumpractbackv1.repository.*;
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


    public void insert() {
        try {
            ED807 ed807;
            Parcer parcer = new Parcer();
            ed807 = parcer.returnParc();

            //TODO переделать все под Build или дополнить парсер

            // Сохранение данных в базу данных
            ImportData importData = new ImportData();
            importData.setXmlns("urn:cbr-ru:ed:v2.0");
            importData.setEdno(ed807.getEDNo());
            importData.setEdDate(LocalDate.parse(ed807.getEDDate()));
            importData.setEdAuthor(Long.valueOf(ed807.getEDAuthor()));
            importData.setCreationReason(CreationReason.valueOf(ed807.getCreationReason()));
            importData.setCreationDateTime(ZonedDateTime.parse(ed807.getCreationDateTime()));
            importData.setInfoTypeCode(InfoTypeCode.valueOf(ed807.getInfoTypeCode()));
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
                bicEntry.setBic((long) entry.getBIC());
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
                        participantInfo.setRgn(String.valueOf(pInfo.getRgn()));
                        participantInfo.setInd(String.valueOf(pInfo.getInd()));
                        participantInfo.setNnp(pInfo.getNnp());
                        participantInfo.setAdr(pInfo.getAdr());
                        participantInfo.setDateInParticipant(pInfo.getDateIn());
                        participantInfo.setPtType(String.valueOf(pInfo.getPtType()));
                        participantInfo.setSrvcs(String.valueOf(pInfo.getSrvcs()));
                        participantInfo.setXchType(String.valueOf(pInfo.getXchType()));
                        participantInfo.setUid(pInfo.getUid());
                        participantInfo.setParticipantStatus(ParticipantStatus.valueOf(pInfo.getParticipantStatus()));

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
                                rstrList.setRstr(Rstr.valueOf(rstr.getRstr()));
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
                        accounts.setRegulationAccountType(RegulationAccountType.valueOf(acc.getRegulationAccountType()));
                        accounts.setCk(String.valueOf(acc.getCk()));
                        accounts.setAccountCbrbic((long) acc.getAccountCBRBIC());
                        accounts.setDateInAccounts(acc.getDateIn());
                        accounts.setAccountStatus(AccountStatus.valueOf(acc.getAccountStatus()));

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

