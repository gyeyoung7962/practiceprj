package com.practiceprj.util;

import com.practiceprj.domain.CustomUser;
import com.practiceprj.domain.Member;
import com.practiceprj.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class CustomUserService implements UserDetailsService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final MemberService service;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Member member = service.selectInfoByEmail(username);

        List<String> authorities = service.getAuthoritiesById(member.getId());
//        System.out.println(authorities);

        member.setAuthorities(authorities);

        return new CustomUser(member);

    }
}
