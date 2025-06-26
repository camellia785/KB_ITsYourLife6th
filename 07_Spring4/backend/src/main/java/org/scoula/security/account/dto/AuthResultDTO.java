package org.scoula.security.account.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 로그인 성공 시 응답으로 보내는 객체
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthResultDTO {
    // 발급된 JWT 토큰
    String token;

    // 로그인한 사용자 정보
    UserInfoDTO user;
}
