package com.practiceprj.mapper;


import com.practiceprj.domain.Board;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
            """)
    List<Board> listBoard();

}
