package com.example.sumpractbackv1.Services;

import com.example.sumpractbackv1.DBEntity.ImportData;
import com.example.sumpractbackv1.DBEntity.TestEn;
import com.example.sumpractbackv1.Repository.AccountsRepository;
import com.example.sumpractbackv1.Repository.ImportDataRepository;
import com.example.sumpractbackv1.Repository.TestRepo;
import lombok.Setter;
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
