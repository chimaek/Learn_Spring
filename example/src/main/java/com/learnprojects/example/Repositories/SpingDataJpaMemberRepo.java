package com.learnprojects.example.Repositories;

import com.learnprojects.example.Domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpingDataJpaMemberRepo extends JpaRepository<Member, Long>, MemberRepo {

    @Override
    Optional<Member> findByName(String name);
}
