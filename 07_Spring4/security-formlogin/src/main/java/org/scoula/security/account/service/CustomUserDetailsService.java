package org.scoula.security.account.service;

import lombok.RequiredArgsConstructor;
import org.scoula.security.account.domain.CustomUser;
import org.scoula.security.account.domain.MemberVO;
import org.scoula.security.account.mapper.UserDetailsMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserDetailsMapper mapper;

    // Security로 로그인할때 form에 입력한 ID값을 이용해 사용자 정보를 가져오는 것
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        MemberVO vo = mapper.get(username);
        if(vo == null){
            throw new UsernameNotFoundException(username + "는 없는 ID입니다.");
        }
        return new CustomUser(vo);
    }
}
