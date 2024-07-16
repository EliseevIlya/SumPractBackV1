package com.example.sumpractbackv1.model.dto.request;

import com.example.sumpractbackv1.model.enums.ChangeType;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BicDirectoryEntryRequest extends BaseEntityRequest{

    private Long bic;

    private ChangeType changeType;

    private Long importData;

    private Long participantInfo;

    private List<Long> swbicsList;

    private List<Long> accountsList;
}
