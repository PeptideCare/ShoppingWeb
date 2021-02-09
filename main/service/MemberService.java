package com.jpaproject.jpaproject.service;

import com.jpaproject.jpaproject.domain.Member;
import com.jpaproject.jpaproject.repository.MemberRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Getter
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    //회원가입
    @Transactional
    public String join(Member member) {
        validateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    //중복 회원 방지 메서드
    public void validateMember(Member member) {
        Member findMember = findOne(member.getId());
        if (findMember != null) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    //하나의 회원 조회
    public Member findOne(String id) {
        return memberRepository.findOne(id);
    }

    //전체 회원 조회
    public List<Member> findAll() {
        return memberRepository.findAll();
    }
}
