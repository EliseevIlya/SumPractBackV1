package com.example.sumpractbackv1.model.dto.request;

import com.example.sumpractbackv1.model.enums.ChangeType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Schema(description = "класс для создания/изменение BICDirectoryEntry. Запись в Справочнике БИК.")
public class BicDirectoryEntryRequest extends BaseEntityRequest {

    @Schema
    @Size(min = 9, max = 9)
    @NotNull
    private Long bic;

    @Schema
    @Size(min = 4, max = 4)
    private ChangeType changeType;

    @Schema
    private Long importData;

    @Schema
    private Long participantInfo;

    @Schema
    private List<Long> swbicsList;

    @Schema
    private List<Long> accountsList;
}
