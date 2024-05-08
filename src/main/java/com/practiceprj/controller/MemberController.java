package com.practiceprj.controller;

import com.practiceprj.domain.Member;
import com.practiceprj.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/join")
    public void getJoin() {

    }

    @PostMapping("/join")
    public String postJoin(Member member, RedirectAttributes rttr) {

        System.out.println("member = " + member);


        memberService.join(member);

        rttr.addFlashAttribute("msg", "가입성공");

        return "redirect:/member/join";
    }


    @GetMapping("/list")
    @PreAuthorize("hasAnyAuthority('admin')")
    public void getList(Model model) {

        List<Member> list = memberService.listMember();

        model.addAttribute("list", list);
    }

    @GetMapping("/select")
    public void getSelect(Integer id, Model model) {
        Member member = memberService.selectMember(id);

        model.addAttribute("member", member);
    }

    @GetMapping("/modify")
    public void getModify(Integer id, Model model) {
        Member member = memberService.selectMember(id);

        model.addAttribute("member", member);
    }

    @PostMapping("/modify")
    public String postModify(Member member, Model model) {
        memberService.modifyMember(member);

        return "redirect:/member/list";
    }

    @PostMapping("/delete")
    public String postDelete(Integer id) {
        memberService.deleteMember(id);

        return "redirect:/member/list";
    }

    @GetMapping("/login")
    public void getLogin() {

    }


}
