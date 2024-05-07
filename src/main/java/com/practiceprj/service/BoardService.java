package com.practiceprj.service;

import com.practiceprj.domain.Board;
import com.practiceprj.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardMapper mapper;


    public void writeBoard(Board board) {

        mapper.writeBoard(board);
    }

    public List<Board> listBoard() {

        return mapper.listBoard();
    }
}
