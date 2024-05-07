package com.practiceprj.service;


import com.practiceprj.domain.Member;
import com.practiceprj.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
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

    public void modifyMember(Member member) {

        mapper.modifyMember(member);
    }

    public void deleteMember(Integer id) {

        mapper.deleteMember(id);
    }
}
