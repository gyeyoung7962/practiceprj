package com.practiceprj.service;


import com.practiceprj.domain.Member;
import com.practiceprj.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class MemberService {

    private final MemberMapper mapper;


    public void join(Member member) {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();


        member.setPassword(bCryptPasswordEncoder.encode(member.getPassword()));

        mapper.join(member);

    }

    public List<Member> listMember() {

        return mapper.listMember();
    }

    public Member selectMember(Integer id) {

        return mapper.selectMember(id);
    }

    public void modifyMember(Member member) {

        mapper.modifyMember(member);
    }

    public void deleteMember(Integer id) {

        mapper.deleteMember(id);
    }

    public Member selectInfoByEmail(String email) {

        return mapper.selectInfoByEmail(email);
    }

    public List<String> getAuthoritiesById(Integer id) {

        return mapper.getAuthoritiesById(id);
    }
}
