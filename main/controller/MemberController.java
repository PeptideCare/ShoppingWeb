package com.jpaproject.jpaproject.controller;

import com.jpaproject.jpaproject.domain.Address;
import com.jpaproject.jpaproject.domain.Member;
import com.jpaproject.jpaproject.service.MemberService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController{

    private final MemberService memberService;

    @Getter
    private String memberId;

    @GetMapping("/member/new")
    public String createForm(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "member/join";
    }

    @PostMapping("/member/new")
    public String create(@Valid MemberForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "member/join";
        }

        Address address = new Address(form.getCity(), form.getStreet(), form.getZipcode());

        Member member = new Member();
        member.setId(form.getId());
        member.setPassword(form.getPw());
        member.setName(form.getName());
        member.setAddress(address);

        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("/member/login")
    public String loginForm(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "member/login";
    }

    @PostMapping("/member/login")
    public String login(@Valid MemberForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "/member/login";
        }
        String id = form.getId();
        String pw = form.getPw();

        if (id.equals("123") && pw.equals("123")) {
            return "redirect:/admin";
        }

        Member member = memberService.findOne(id);

        // 아이디가 없을 시
        if (member.getId() == "false") {
            return "/member/join";
        }
        // 로그인 성공
        else if (pw.equals(member.getPassword())) {
            memberId = id;
            return "redirect:/user";
        }
        // 비밀번호가 일치하지 않을 시
        else {
            return "/member/login";
        }
    }

    @GetMapping("/member/memberList")
    public String memberList(Model model) {
        List<Member> members = memberService.findAll();
        model.addAttribute("members", members);
        return "/member/memberList";
    }

    @GetMapping("/member/{memberId}/delete")
    public String memberDelite(@PathVariable("memberId") String memberId) {
        Member member = memberService.findOne(memberId);
        memberService.deleteMember(member);
        return "/member/memberList";
    }
}