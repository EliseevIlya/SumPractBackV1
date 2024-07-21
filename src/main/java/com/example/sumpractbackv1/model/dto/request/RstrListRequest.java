package com.example.sumpractbackv1.model.dto.request;

import com.example.sumpractbackv1.model.entity.RstrList;
import com.example.sumpractbackv1.model.enums.Rstr;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class RstrListRequest extends BaseEntityRequest {

    private Rstr rstr;

    private LocalDate rstrDate;

    private Long participantInfo;

    public RstrList toRstrList() {
        var rstrList = RstrList.builder()
                .rstr(rstr)
                .rstrDate(rstrDate)
                .build();
        rstrList.setId(getId());
        return rstrList;
    }

}
