package org.scoula.security.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.security.account.domain.CustomUser;
import org.scoula.security.account.domain.MemberVO;
import org.scoula.security.account.mapper.UserDetailsMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@Log4j2
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    // DB에서 사용자 정보를 가져오는 Mapper 주입
    private final UserDetailsMapper userDetailsMapper;

    // 사용자 ID로 DB에서 회원 정보 조회 → CustomUser로 변환
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MemberVO memberVO = userDetailsMapper.get(username);
        return new CustomUser(memberVO);
    }
}
