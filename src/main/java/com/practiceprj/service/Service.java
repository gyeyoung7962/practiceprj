package com.practiceprj.service;


import com.practiceprj.domain.Member;
import com.practiceprj.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class Service {

    private final MemberMapper mapper;



    public void join(Member member) {

        mapper.join(member);

    }

    public List<Member> listMember() {

        return mapper.listMember();
    }

    public Member selectMember(Integer id) {

        return mapper.selectMember(id);
    }
}
