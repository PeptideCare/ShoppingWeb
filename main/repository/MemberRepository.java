package com.jpaproject.jpaproject.repository;

import com.jpaproject.jpaproject.domain.Member;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Getter
public class MemberRepository {

    private final EntityManager em;

    //저장
    public void save(Member member) {
        em.persist(member);
    }

    //하나의 멤버 조회
    //NPE 방지를 위해 null 값을 "false" 변환
    public Member findOne(String id) {
        if (em.find(Member.class, id) == null) {
            Member member = new Member();
            member.setId("false");
            member.setPassword("false");
            return member;
        }
        else {
            return em.find(Member.class, id);
        }
    }

    //전체 멤버 조회
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    //이름으로 멤버 조회
    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name")
                .getResultList();
    }

    //삭제
    public void deleteMember(Member member) {
        em.remove(member);
    }
}
