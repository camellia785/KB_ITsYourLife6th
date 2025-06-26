package org.scoula.security.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtProcessor {

    // JWT 유효시간 (2분)
    static private final long TOKEN_VALID_MILISECOND = 1000L * 60 * 2;

    // 시크릿 키 (운영 환경에서는 .env 또는 외부 설정 사용 권장)
    private final String secretKey = "충분히긴임의의(랜덤한) 비밀키문자열배정";

    // HMAC SHA 키 생성
    private final Key key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));

    // JWT 생성: subject = 사용자 ID
    public String generateToken(String subject) {
        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(new Date()) // 발급 시간
                .setExpiration(new Date(new Date().getTime() + TOKEN_VALID_MILISECOND)) // 만료 시간
                .signWith(key) // 서명
                .compact();
    }

    // JWT에서 사용자 ID(subject) 추출
    public String getUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // JWT 유효성 검증 (예외 발생 여부로 판단)
    public boolean validateToken(String token) {
        Jws<Claims> claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);
        return true;
    }
}
