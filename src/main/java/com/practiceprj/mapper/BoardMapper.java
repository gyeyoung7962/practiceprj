package com.practiceprj.mapper;


import com.practiceprj.domain.Board;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {



    @Insert("""
            insert into board(title, content, writer)
            values(#{title}, #{content}, #{writer})
            """)
    void writeBoard(Board board);

    @Select("""
            select *
            from board
            order by id desc
            """)
    List<Board> listBoard();

    @Select("""
            select *
            from board
            where id = #{id}
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
}
