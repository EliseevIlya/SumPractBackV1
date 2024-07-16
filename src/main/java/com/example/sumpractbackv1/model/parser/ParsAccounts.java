package com.example.sumpractbackv1.model.parser;

import com.example.sumpractbackv1.model.entity.Accounts;
import com.example.sumpractbackv1.model.enums.AccountStatus;
import com.example.sumpractbackv1.model.enums.RegulationAccountType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class ParsAccounts {

    @XmlAttribute(name = "Account")
    private String account;

    @XmlAttribute(name = "RegulationAccountType")
    private RegulationAccountType regulationAccountType;

    @XmlAttribute(name = "CK")
    private String ck;

    @XmlAttribute(name = "AccountCBRBIC")
    private Long accountCBRBIC;

    @XmlAttribute(name = "DateIn")
    private String dateIn;

    @XmlAttribute(name = "DateOut")
    private String dateOut;

    @XmlAttribute(name = "AccountStatus")
    private AccountStatus accountStatus;

    @XmlElement(name = "AccRstrList", namespace = "urn:cbr-ru:ed:v2.0")
    private List<ParsAccRstrList> parsAccRstrList;

    public Accounts toAccounts() {
        var accounts = Accounts.builder()
                .account(account)
                .regulationAccountType(regulationAccountType)
                .ck(ck)
                .accountCbrbic(accountCBRBIC)
                .dateIn(dateIn != null ? LocalDate.parse(dateIn) : null)
                .dateOut(dateOut != null ? LocalDate.parse(dateOut) : null)
                .accountStatus(accountStatus)
                .accRstrLists(parsAccRstrList != null
                        ? parsAccRstrList.stream()
                        .map(ParsAccRstrList::toAccRstrList)
                        .collect(Collectors.toList())
                        : null)
                .build();
        if (accounts.getAccRstrLists() != null) {
            accounts.getAccRstrLists().forEach(accRstrList ->
                    accRstrList.setAccounts(accounts));
        }
        return accounts;
    }

}