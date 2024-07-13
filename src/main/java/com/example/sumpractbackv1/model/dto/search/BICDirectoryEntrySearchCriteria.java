package com.example.sumpractbackv1.model.dto.search;

import org.springdoc.core.annotations.ParameterObject;

import com.example.sumpractbackv1.model.enums.ChangeType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ParameterObject
public class BICDirectoryEntrySearchCriteria extends BaseEntitySearchCriteria {
    private Long bic;
    private ChangeType changeType;
    private Long importDataBicId;
}
