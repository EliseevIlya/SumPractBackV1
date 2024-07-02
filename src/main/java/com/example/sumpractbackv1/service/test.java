package com.example.sumpractbackv1.service;

import com.example.sumpractbackv1.entity.ImportData;
import com.example.sumpractbackv1.entity.TestEn;
import com.example.sumpractbackv1.repository.ImportDataRepository;
import com.example.sumpractbackv1.repository.TestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZonedDateTime;

@Service
public class test {
    @Autowired
    private ImportDataRepository importDataRepository;
    @Autowired
    private TestRepo testRepo;

    ImportData importData = new ImportData();
    TestEn testEn = new TestEn();
    public void ins(){
        importData.setXmlns("ddd");
        importData.setEDNo(708037415L);
        importData.setEDDate(LocalDate.parse("2023-05-17"));
        importData.setEDAuthor("4583001999");
        importData.setCreationReason("FCBD");
        importData.setCreationDateTime(ZonedDateTime.parse("2023-05-17T18:31:47Z"));
        importData.setInfoTypeCode("FIRR");
        importData.setBusinessDay(LocalDate.parse("2023-05-18"));
        importData.setDirectoryVersion(1);

        testEn.setTes("ssss");
        testEn.setAccountId(1l);
        testRepo.save(testEn);
    }
}
