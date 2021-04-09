package com.learnprojects.example.Repositories;

import com.learnprojects.example.Domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepo implements MemberRepo {
    private final EntityManager entityManager;


    public JpaMemberRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public Member save(Member member) {
        entityManager.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = entityManager.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> members = entityManager.createQuery("select m from Member m where m.name = :name ", Member.class)
                .setParameter("name", name)
                .getResultList();
        return members.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        return entityManager.createQuery("select m from m", Member.class)
                .getResultList();
    }
}
