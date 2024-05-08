package com.practiceprj.mapper;


import com.practiceprj.domain.Board;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {


    @Insert("""
            insert into board(title, content, member_id)
            values(#{title}, #{content}, #{memberId})
            """)
    void writeBoard(Board board);

    @Select("""
            select *
            from board
            order by id desc
            """)
    List<Board> listBoard();

    @Select("""
            select b.id, b.title, b.content, m.nick_name writer, b.regDate, b.member_id, m.id
            from board b
                     join Member m
                          on b.member_id = m.id
            where b.id = #{id};
            """)
    Board readBoard(Integer id);

    @Update("""
            update board
            set title = #{title}, content = #{content}
            where id = #{id}
            """)
    void updateBoard(Board board);

    @Delete("""
            delete from
            board
            where id = #{id}
            """)
    void deleteBoard(Integer id);

    @Select("""
                        
            select b.id, b.title, m.nick_name writer, b.regDate
            from board b join Member m
            on b.member_id = m.id
            order by b.id desc
            limit #{offSet}, 10
            """)
    List<Board> listBoardPaging(int offSet);

    @Select("""
            select count(*)
            from board
            """)
    int totalCount();
}
