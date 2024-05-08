package com.practiceprj.service;

import com.practiceprj.domain.Board;
import com.practiceprj.domain.CustomUser;
import com.practiceprj.domain.Member;
import com.practiceprj.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Log4j2
@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class BoardService {

    private final BoardMapper mapper;


    public void writeBoard(Board board, Authentication authentication) {

        Object principal = authentication.getPrincipal();

        if (principal instanceof CustomUser user) {
            Member member = user.getMember();
            board.setMemberId(member.getId());
            log.info("==========board1=========={}", board);
            log.info("==========board2=========={}", board.toString());
        }
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

    public Map<String, Object> listBoardPaging(Integer page) {

        int offSet = (page - 1) * 10; //페이지마다 게시글 번호 1p -> 1 ~10

        int totalCount = mapper.totalCount(); //게시글 총개수

        int totalEndPage = totalCount % 10 == 0 ? totalCount / 10 : totalCount / 10 + 1; //총 게시글의 개수

        //5페이지 보고있으면 끝페이지는 10페이지나와야함
        //5-1
        int currentEndPage = (((page - 1) / 10) + 1) * 10;
        int currentStartPage = currentEndPage - 9;

        //총페이지가 47 페이지 현재 끝페이지 50
        if (totalEndPage < currentEndPage) {
            currentEndPage = totalEndPage;
        }

        boolean prevPage = page > 1 ? true : false;
        boolean nextPage = currentEndPage < totalEndPage ? true : false;

        int prevPageNumber = currentStartPage - 10;
        int nextPageNumber = currentStartPage + 10;


        return Map.of("list", mapper.listBoardPaging(offSet),
                "pageInfo", Map.of(
                        "currentPage", page,
                        "totalEndPage", totalEndPage,
                        "currentStartPage", currentStartPage,
                        "currentEndPage", currentEndPage,
                        "prevPage", prevPage,
                        "nextPage", nextPage,
                        "prevPageNumber", prevPageNumber,
                        "nextPageNumber", nextPageNumber


                )


        );

    }

    public boolean access(Integer id, Authentication authentication) {


        if (authentication == null) {

            return false;
        }

        Board board = mapper.readBoard(id); //글 값 조회

        Object principal = authentication.getPrincipal();

        if (principal instanceof CustomUser user) {

            Member member = user.getMember();

            return board.getMemberId().equals(member.getId());
        }
        return false;
    }
}
