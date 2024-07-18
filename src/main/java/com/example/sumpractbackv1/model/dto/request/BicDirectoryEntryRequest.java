package com.example.sumpractbackv1.model.dto.request;

import com.example.sumpractbackv1.model.entity.BicDirectoryEntry;
import com.example.sumpractbackv1.model.enums.ChangeType;

import lombok.Getter;
import lombok.Setter;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

import java.util.List;

@Getter
@Setter
@Schema(description = "класс для создания/изменение BICDirectoryEntry. Запись в Справочнике БИК.")
public class BicDirectoryEntryRequest extends BaseEntityRequest {

    @Schema(description = "БИК.")
    @NotNull
    @Max(999999999L)
    @PositiveOrZero
    private Long bic;

    @Schema(description = "Тип изменения в Справочнике по сравнению с предыдущей версией cправочника (добавление записи/изменение/удаление).")
    @Size(min = 4, max = 4)
    private ChangeType changeType;

    @Schema(description = "")
    @Positive
    private Long importData;

    @Schema
    @Positive
    private Long participantInfo;

    @Schema
    private List<Long> swbicsList = List.of();

    @Schema
    private List<Long> accountsList = List.of();

    public BicDirectoryEntry toBicDirectoryEntry() {
        var bicDirectoryEntry = BicDirectoryEntry.builder()
                .bic(bic)
                .changeType(changeType)
                .build();
        bicDirectoryEntry.setId(getId());
        return bicDirectoryEntry;
    }
}
