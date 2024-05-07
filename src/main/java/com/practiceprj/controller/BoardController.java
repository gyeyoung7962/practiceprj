package com.practiceprj.controller;


import com.practiceprj.domain.Board;
import com.practiceprj.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService service;

    @GetMapping("/write")
    public void getWrite(){

    }

    @PostMapping("/write")
    public String postWrite(Board board, RedirectAttributes rttr){

        service.writeBoard(board);

        rttr.addFlashAttribute("msg", "가입완료");

        return "redirect:/board/write";
    }

    @GetMapping("/list")
    public void getList(Model model){

        List<Board> list = service.listBoard();

        model.addAttribute("list", list);
    }
}
