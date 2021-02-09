package com.jpaproject.jpaproject.service;

import com.jpaproject.jpaproject.domain.Member;
import com.jpaproject.jpaproject.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired MemberRepository memberRepository;
    @Autowired MemberService memberService;

    @Test
    public void 회원가입() throws Exception {
        //Given
        Member member = new Member();
        member.setId("kim");

        //When
        String memberId = memberService.join(member);
        Member findMember = memberRepository.findOne(member.getId());

        //then
        assertEquals(member, findMember);
    }

    //중복 회원 테스트
    @Test
    public void 중복회원테스트() throws Exception {
        //given
        Member member = new Member();
        member.setId("im");
        Member member1 = new Member();
        member1.setId("im");

        //when
        memberService.join(member);
        try {
            memberService.join(member1);
        } catch (IllegalStateException e) {
            return;
        }

        //then
        fail("예외가 발생");
    }

}