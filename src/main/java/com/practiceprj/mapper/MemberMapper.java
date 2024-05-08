package com.practiceprj.mapper;


import com.practiceprj.domain.Member;
import org.apache.ibatis.annotations.*;

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

    @Update("""
            update Member
            set password = #{password}, nick_name = #{nickName}
            where id = #{id}
            """)
    void modifyMember(Member member);

    @Delete("""
            delete from Member
            where id = #{id}
            """)
    void deleteMember(Integer id);

    @Select("""
            select *
            from Member
            where email = #{email}
            """)
    Member selectInfoByEmail(String email);
}
