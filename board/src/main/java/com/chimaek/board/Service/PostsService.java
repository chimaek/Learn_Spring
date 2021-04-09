package com.chimaek.board.Service;

import com.chimaek.board.Domain.PostsRepo;
import com.chimaek.board.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepo postsRepo;

    @Transactional
    public Long save(PostsSaveRequestDto postsSaveRequestDto){
        return postsRepo.save(postsSaveRequestDto.toEntity()).getId();
    }
}
