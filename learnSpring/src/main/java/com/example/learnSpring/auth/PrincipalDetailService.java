package com.example.learnSpring.auth;


import com.example.learnSpring.model.User;
import com.example.learnSpring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PrincipalDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    //스프링이 로그인 요청으 라가로챌때 유저네임과 패스워드 변수2개를 가로챈다.

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userPrincipal = userRepository.findByUsername(username).orElseThrow(()->{
            return new UsernameNotFoundException("해당사용자를 찾을 수 없습니다.");
        });
        return new PrincipalDetail(userPrincipal);
    }
}
