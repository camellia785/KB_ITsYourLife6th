package org.scoula.security.account.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;

import javax.servlet.http.HttpServletRequest;

// 로그인 요청 시 전달되는 JSON 데이터를 담기 위한 DTO
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {
    // 사용자명 (ID)
    private String username;

    // 비밀번호
    private String password;

    /**
     * 요청(request)의 JSON 본문을 LoginDTO 객체로 변환하는 정적 메서드
     * @param request HTTP 요청 객체
     * @return LoginDTO 변환 결과
     */
    public static LoginDTO of(HttpServletRequest request) {
        ObjectMapper om = new ObjectMapper();
        try {
            // JSON 본문을 읽어와 LoginDTO 객체로 역직렬화
            return om.readValue(request.getInputStream(), LoginDTO.class);
        } catch (Exception e) {
            e.printStackTrace();
            // JSON 파싱 실패 시 인증 예외 던짐
            throw new BadCredentialsException("username 또는 password가 없습니다.");
        }
    }
}
