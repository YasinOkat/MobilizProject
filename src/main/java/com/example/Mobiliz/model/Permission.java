package com.example.Mobiliz.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Permission {

    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_CREATE("admin:create"),
    ADMIN_DELETE("admin:delete"),
    STANDARD_READ("standard:read"),
    STANDARD_UPDATE("standard:update"),
    STANDARD_CREATE("standard:create"),
    STANDARD_DELETE("standard:delete"),
    COMPANY_ADMIN_READ("company_admin:read"),
    COMPANY_ADMIN_UPDATE("company_admin:update"),
    COMPANY_ADMIN_CREATE("company_admin:create"),
    COMPANY_ADMIN_DELETE("company_admin:delete");

    private final String permission;
}
