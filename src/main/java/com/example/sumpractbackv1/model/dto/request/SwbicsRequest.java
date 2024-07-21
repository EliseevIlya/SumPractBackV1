package com.example.sumpractbackv1.model.dto.request;

import com.example.sumpractbackv1.model.entity.Swbics;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SwbicsRequest extends BaseEntityRequest {

    private String swbic;

    private Integer defaultSwbic;

    private Long bicDirectoryEntry;

    public Swbics toSwbics() {
        Swbics swbics = Swbics.builder()
                .swbic(swbic)
                .defaultSwbic(defaultSwbic)
                .build();
        swbics.setId(getId());
        return swbics;
    }

}
