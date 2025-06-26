package org.scoula.security.account.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.scoula.security.account.domain.MemberVO;

import java.util.List;

// 클라이언트에게 전달되는 사용자 정보 DTO
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDTO {
    // 사용자명
    String username;

    // 이메일 주소
    String email;

    // 권한 목록 (예: ["ROLE_MEMBER", "ROLE_ADMIN"])
    List<String> roles;

    /**
     * MemberVO 객체를 UserInfoDTO로 변환하는 유틸 메서드
     * @param member MemberVO 객체 (DB에서 가져온 회원 정보)
     * @return 변환된 UserInfoDTO
     */
    public static UserInfoDTO of(MemberVO member) {
        return new UserInfoDTO(
                member.getUsername(),
                member.getEmail(),
                // 권한 객체 리스트에서 문자열 권한만 추출
                member.getAuthList().stream()
                        .map(a -> a.getAuth()) // "ROLE_ADMIN" 등
                        .toList()
        );
    }
}
