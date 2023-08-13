package com.example.Mobiliz.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
public enum Role {

    ADMIN(Set.of(
            Permission.ADMIN_READ,
            Permission.ADMIN_UPDATE,
            Permission.ADMIN_CREATE,
            Permission.ADMIN_DELETE
    )),
    STANDARD(Set.of(
            Permission.STANDARD_READ,
            Permission.STANDARD_UPDATE,
            Permission.STANDARD_CREATE,
            Permission.STANDARD_DELETE
    )),
    COMPANY_ADMIN(Set.of(
            Permission.STANDARD_READ,
            Permission.STANDARD_UPDATE,
            Permission.STANDARD_CREATE,
            Permission.STANDARD_DELETE,
            Permission.COMPANY_ADMIN_READ,
            Permission.COMPANY_ADMIN_UPDATE,
            Permission.COMPANY_ADMIN_CREATE,
            Permission.COMPANY_ADMIN_DELETE
    ));

    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities() {
        var authorities = permissions.stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }

}
