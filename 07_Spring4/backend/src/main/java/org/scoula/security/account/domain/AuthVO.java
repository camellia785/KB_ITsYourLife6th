package org.scoula.security.account.domain;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

// 권한 정보 객체로 Spring Security에서 사용
@Data
public class AuthVO implements GrantedAuthority {

    // 사용자 ID (username과 동일)
    private String username;

    // 권한 이름 (예: ROLE_ADMIN, ROLE_MEMBER 등)
    private String auth;

    // GrantedAuthority 인터페이스 구현 메서드
    // Security가 권한 확인 시 사용하는 값
    @Override
    public String getAuthority() {
        return auth;
    }
}
