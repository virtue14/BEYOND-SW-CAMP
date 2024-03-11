package com.ohgiraffers.userservice.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ohgiraffers.userservice.dto.UserDTO;
import com.ohgiraffers.userservice.service.UserService;
import com.ohgiraffers.userservice.vo.RequestLogin;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 *  <h1>JWT(Json Web Token)의 구조</h1>
 *  <h2>1. 헤더(Header)</h2>
 *  <h3>- typ: 토큰의 타입 지정(JWT)</h3>
 *  <h3>- alg: 해싱 알고리즘으로 Verify Signature에서 사용 됨</h3>
 *  <h2>2. 내용 또는 정보(Payload)</h2>
 *  <h3>- 토큰에 담을 정보가 들어 있음</h3>
 *  <h3>- 담는 정보의 한 조각을 클레임(claim - name과 value의 쌍으로 구성)이라 부름</h3>
 *  <h3>a. 등록된 클레임(registered claim): 토큰에 대한 정보가 담김</h3>
 *  iss: 토큰 발급자(issuer)<br>
 *  sub: 토큰 제목(subject)<br>
 *  aud: 토큰 대상자(audience)<br>
 *  exp: 토큰의 만료 시간(expiration)<br>
 *  nbf: 토큰 활성화(발급) 날짜(not before)<br>
 *  iat: 토큰 활성화(발급) 시간(issued at)<br><br>
 *  <h3>b. 공개 클레임(public claim): 사용자 정의 클레임으로 공개용 정보를 위해 사용(충돌 방지를 위해 URI로 구성)</h3>
 *  <h3>c. 비공개 클레임(private claim): 사용자 정의 클레임으로 서버(JWT 발급자)와 클라이언트 사이에 임의로 지정한 정보를 저장(충돌 발생 우려가 있어 조심해서 사용할 것)</h3>
 *  <h2>3. 서명(Verify Signature)</h2>
 *  <h3>- Header 인코딩 값과 Payload 인코딩 값을 합쳐서 비밀 키로 해쉬(헤더의 해싱 알고리즘으로)하여 생성</h3>
 */

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private UserService userService;
    private Environment env;


    public AuthenticationFilter(AuthenticationManager authenticationManager, UserService userService, Environment env) {
        super(authenticationManager);
        this.userService = userService;
        this.env = env;
    }

    /**
     *   로그인 시도 시 동작하는 기능(POST방식의 /login 요청) -> request body에 담겨온다.(stream 활용해야함)
     *  <br>
     *   Service 계층 손보러 가자(우리의 Service 클래스를 UserDetailsService로 만들기) -> Service interface로 이동
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            RequestLogin requestLogin = new ObjectMapper().readValue(request.getInputStream(), RequestLogin.class);
            return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(requestLogin.getEmail(), requestLogin.getPassword(), new ArrayList<>()));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     *  로그인 성공 시 JWT 토큰 생성
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
//        System.out.println("authResult = " + authResult);
        String email = ((User) authResult.getPrincipal()).getUsername();
        System.out.println("시크릿 키: " + env.getProperty("token.secret"));
        System.out.println("userName = " + email);

        /* 설명: DB를 다녀와 사용자의 고유 아이디(userId)를 가져올 에정(Principal 객체(Authentication)에는 없는 값이므로) */
        UserDTO userDetails = userService.getUserDetailsByEmail(email);
        String userId = userDetails.getUserId();

        String token = Jwts.builder()
                .setSubject(userId)
                .setExpiration(new Date(System.currentTimeMillis()
                        + Long.valueOf(env.getProperty("token.expiration_time"))))
                .signWith(SignatureAlgorithm.HS512, env.getProperty("token.secret"))
                .compact();

        response.addHeader("token", token);
        response.addHeader("userId", userId);
    }
}
