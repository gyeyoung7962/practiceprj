package com.practiceprj.service;

import com.practiceprj.domain.Board;
import com.practiceprj.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class BoardService {

    private final BoardMapper mapper;


    public void writeBoard(Board board) {

        mapper.writeBoard(board);
    }

    public List<Board> listBoard() {

        return mapper.listBoard();
    }

    public Board readBoard(Integer id) {

        return mapper.readBoard(id);
    }

    public void updateBoard(Board board) {

        mapper.updateBoard(board);
    }

    public void deleteBoard(Integer id) {

        mapper.deleteBoard(id);
    }
}
