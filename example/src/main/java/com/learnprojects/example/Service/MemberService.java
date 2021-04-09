package com.learnprojects.example.Service;

import com.learnprojects.example.Domain.Member;
import com.learnprojects.example.Repositories.MemberRepo;
import com.learnprojects.example.Repositories.MemoryMemberRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {

    private final MemberRepo repo;


    public MemberService(MemberRepo memberRepo) {
        this.repo = memberRepo;

    }

    /*register*/
    public Long join(Member member) {

        long start = System.currentTimeMillis();
        try{

            VaildateMember(member);
            repo.save(member);
            return member.getId();
        }finally {
            long finish = System.currentTimeMillis();
            long time = finish - start;
            System.out.println(time);
        }
    }

    private void VaildateMember(Member member) {
        repo.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("EXITS MEMBER");
                });
    }

    public List<Member> findMembers() {
        return repo.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return repo.findById(memberId);
    }
}