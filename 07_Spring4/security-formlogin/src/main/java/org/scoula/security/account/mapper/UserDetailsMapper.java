package org.scoula.security.account.mapper;

import org.scoula.security.account.domain.MemberVO;

public interface UserDetailsMapper {

    // username : pk
    // 덜적음
    MemberVO get(String username);
}
