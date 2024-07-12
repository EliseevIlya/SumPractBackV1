package com.example.sumpractbackv1.model.dto.search;

import com.example.sumpractbackv1.model.enums.ChangeType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BICDirectoryEntrySearchCriteria extends BaseEntitySearchCriteria {
    private Long bic;
    private ChangeType changeType;
    private Long importDataBicId;
}
