package org.scoula.security.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

// JWT 사용할때 필요한 메서드들을 만들어놓기위한 클래스
@Component
@Log4j2
public class JwtProcessor {

    // 토큰 만료시간 (5분)
    static private final long TOKEN_VALID_MILLISECOND = 1000L * 60 * 5;

    private String secretkey = "KB_IT'S_YOURS_6기_19회차_JWT수업";
    // 문자열 -> 바이트배열로 변환
    private Key key = Keys.hmacShaKeyFor(secretkey.getBytes((StandardCharsets.UTF_8)));

    // 토큰 만들기
    // subject: 사용자 식볅밧(username)
    public String generateToken(String subject, String role){
        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + TOKEN_VALID_MILLISECOND))
                .claim("role", role)
                .signWith(key) // 서명
                .compact(); // 문자열 생성
    }

    // 검증
    // Subject -> 사용자 식별자 (사용자 정보중 고유한 값)
    public String getUserName(String token) {

        // parserBuilder 이용해 Jwtparser 객체 생성
        JwtParser jwtParser = Jwts.parserBuilder()
                .setSigningKey(key)
                .build();

        // 토큰 파싱 JWS (Signed Token 구조)
        Jws<Claims> jwsClaims = jwtParser.parseClaimsJws(token);

        // Claims (Payload) 부분 추출
        Claims claims = jwsClaims.getBody();

        // Claims에서 Subject 필드 가져오기
        String username = claims.getSubject();

        return username;
    }

    // JWT 검증 - 유효 시간과 서명 확인
    public boolean validateToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parserBuilder()
                    .setSigningKey(key)              // 서명 검증 키 설정
                    .build()
                    .parseClaimsJws(token);          // 토큰 파싱 및 검증

            return true;  // 검증 성공 시 true 반환
        } catch (JwtException | IllegalArgumentException e) {
            log.error("JWT 검증 실패: {}", e.getMessage());
            return false;
        }
    }


}
