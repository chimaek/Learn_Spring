package com.example.learnSpring.controller;

import com.example.learnSpring.model.OAuthToken;
import com.example.learnSpring.model.User;
import com.example.learnSpring.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/auth/joinForm")
    public String joinForm() {

        return "user/joinForm";
    }

    @GetMapping("/auth/loginForm")
    public String loginForm() {
        return "user/loginForm";
    }

    @GetMapping("/user/updateForm")
    public String updateForm() {
        return "user/updateForm";
    }

    @GetMapping("/auth/kakao/callback")
    public @ResponseBody
    String kakaoCallback(String code) {
        /*
        * 템플릿으로 코드 받기
        *
        *
        * */
        RestTemplate rt = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("client_id", "27dac1d6b341bcd3f467fd54c7a906b6");
        params.add("redirect_url", "http://localhost:8080/auth/kakao/callback");
        params.add("code", code);

        HttpEntity<MultiValueMap<String, String>> requestKakao = new HttpEntity<>(params, httpHeaders);

        ResponseEntity<String> responseEntity = rt.exchange("https://kauth.kakao.com/oauth/token",
                HttpMethod.POST, requestKakao, String.class);

//        WebClient.create().post()
//                .uri("https://kauth.kakao.com/oauth/token")
//                .body(BodyInserters.fromFormData(params))
//                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED.toString())
//                .retrieve()
//                .bodyToFlux(String.class).subscribe(log::info);

        // 토큰 맵퍼퍼
        OAuthToken oAuthToken = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            oAuthToken = objectMapper.readValue(responseEntity.getBody(), OAuthToken.class);

        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        log.info(oAuthToken.getAccess_token());

        RestTemplate rt2 = new RestTemplate();
        HttpHeaders httpHeaders2 = new HttpHeaders();
        httpHeaders2.add("Authorization","Bearer "+oAuthToken.getAccess_token());
        httpHeaders2.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
//        MultiValueMap<String, String> paramsProfile = new LinkedMultiValueMap<>();
//        params.add("grant_type", "authorization_code");
//        params.add("client_id", "27dac1d6b341bcd3f467fd54c7a906b6");
//        params.add("redirect_url", "http://localhost:8080/auth/kakao/callback");
//        params.add("code", code);

        HttpEntity<MultiValueMap<String, String>> requestKakaoProfile = new HttpEntity<>(httpHeaders2);

        ResponseEntity<String> responseEntity2 = rt2.exchange("https://kapi.kakao.com/v2/user/me",
                HttpMethod.POST, requestKakaoProfile, String.class);


        return responseEntity2.getBody();
    }

}
