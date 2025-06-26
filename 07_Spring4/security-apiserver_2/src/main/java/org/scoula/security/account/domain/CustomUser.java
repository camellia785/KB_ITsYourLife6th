package org.scoula.security.account.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

// Spring Security의 User를 확장한 클래스
// 우리의 MemberVO 객체를 담기 위해 생성
@Getter
@Setter
public class CustomUser extends User {

    // 실제 사용자 정보 (예: 이름, 이메일 등 포함된 MemberVO)
    private MemberVO member;

    // MemberVO를 기반으로 하는 생성자
    // MemberVO에서 username, password, 권한 목록을 가져와 설정
    public CustomUser(MemberVO memberVO) {
        super(memberVO.getUsername(), memberVO.getPassword(), memberVO.getAuthList());
        this.member = memberVO;
    }

    // 기본 생성자 (직접 username, password, 권한을 지정할 경우)
    public CustomUser(String username, String password,
                      Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }
}
