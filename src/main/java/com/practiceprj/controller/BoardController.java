package com.practiceprj.controller;


import com.practiceprj.domain.Board;
import com.practiceprj.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService service;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/write")
    public void getWrite() {

    }

    @PostMapping("/write")
    public String postWrite(Board board, Authentication authentication) {

        if (authentication == null) {

            return "redirect:/member/login";
        }

        service.writeBoard(board, authentication);


        return "redirect:/board/list";
    }

    @GetMapping("/list")
    public void getList(@RequestParam(name = "page", defaultValue = "1") Integer page, Model model) {

//        if (page == null || page < 1) {
//            page = 1;
//        }
//        List<Board> list = service.listBoard();
//
//        model.addAttribute("list", list);


        model.addAllAttributes(service.listBoardPaging(page));
    }

    @GetMapping("/read")
    public String read(Integer id, Model model) {

        Board board = service.readBoard(id);

        model.addAttribute("board", board);

        return "board/read";
    }

    @GetMapping("/modify")
    public void getModify(Integer id, Model model) {
        Board board = service.readBoard(id);

        model.addAttribute("board", board);
    }

    @PostMapping("/modify")
    public String postModify(Board board, Authentication authentication) {

        if (service.access(board.getId(), authentication)) {
            service.updateBoard(board);
        }


        return "redirect:/board/read?id=" + board.getId();
    }

    @PostMapping("/delete")
    public String postDelete(Integer id, Authentication authentication) {

        if (service.access(id, authentication)) {
            service.deleteBoard(id);
        }

        return "redirect:/board/list";
    }
}

