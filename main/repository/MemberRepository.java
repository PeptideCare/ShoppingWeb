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
    public Member findOne(String id) {
        return em.find(Member.class, id);
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
}
