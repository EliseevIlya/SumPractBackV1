package com.example.sumpractbackv1.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.example.sumpractbackv1.model.enums.Permissions.*;

@RequiredArgsConstructor
public enum Role {
    ADMIN(Set.of(
            READ_DATA,
            EDIT_DATA,
            CREATE_USER
    )),
    USER(Set.of(
            READ_DATA
    ));

    @Getter
    private final Set<Permissions> permissions;

    public List<SimpleGrantedAuthority> getAuthorities() {
        var authorities = getPermissions()
                .stream()
                .map(p -> new SimpleGrantedAuthority(p.getPermission()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}
