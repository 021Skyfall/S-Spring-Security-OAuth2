package com.jerry.oauth2_jwt.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomAuthorityUtils {
    // application.yml 에 정의된 관리자 이메일 지정
    @Value(("${mail.address.admin}"))
    private String adminMailAddress;

    // 관리자 권한 생성
    private final List<GrantedAuthority> ADMIN_ROLES =
            AuthorityUtils.createAuthorityList("ROLE_ADMIN", "ROLE_USER");

    // 일반 사용자 권한 생성
    private final List<GrantedAuthority> USER_ROLES =
            AuthorityUtils.createAuthorityList("ROLE_USER");

    // 메모리 상의 Role 기반으로 권한 정보 생성
    public List<GrantedAuthority> createAuthorities(String email) {
        if (email.equals(adminMailAddress)) {
            return ADMIN_ROLES;
        }
        return USER_ROLES;
    }

    // DB 저장하기 위해서 String 으로 생성
    private final List<String> ADMIN_ROLES_STRING =
            List.of("ADMIN", "USER");
    private final List<String> USER_ROLES_STRING =
            List.of("USER");

    public List<String> createRoles(String email) {
        if (email.equals(adminMailAddress)) {
            return ADMIN_ROLES_STRING;
        }
        return USER_ROLES_STRING;
    }

    // DB에 저장된 ROLE 을 기반으로 권한 정보 생성
    public List<GrantedAuthority> createAuthorities(List<String> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                .collect(Collectors.toList());
    }

}
