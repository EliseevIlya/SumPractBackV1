package com.example.sumpractbackv1.model.dto.search;

import com.example.sumpractbackv1.model.enums.Role;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserSearchCriteria {
    private Long id;
    private String username;
    private Role role;
    private Date createdAt;
}