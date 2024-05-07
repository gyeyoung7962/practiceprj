package com.practiceprj.mapper;


import com.practiceprj.domain.Member;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MemberMapper {

    @Insert("""
            insert into Member(email, password, nick_name)
            values(#{email}, #{password}, #{nickName})
            """)
    public void join(Member member);

    @Select("""
            select *
            from Member
            """)
    List<Member> listMember();

    @Select("""
            select *
            from Member
            where id = #{id}
            """)
    Member selectMember(Integer id);
}
