package com.example.boardback.provider;

import org.springframework.stereotype.Component;
import java.util.Date;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Claims;

@Component
public class JwtProvider {

    @Value("${secret-key}")
    private String secretKey; // resources에 application.properties에 적어놨음
    public String create(String email) {
        //email 받아서 jwt 만듬
        Date expiredDate = Date.from(Instant.now().plus(1, ChronoUnit.HOURS)); // 1시간짜리

        String jwt = Jwts.builder()
                    .signWith(SignatureAlgorithm.ES256, secretKey)
                    .setSubject(email).setIssuedAt(new Date()).setExpiration(expiredDate)
                    .compact();
        return jwt;
    }    
    public String validate(String jwt) { // 검증
        Claims claims = null;
        try {
            claims = Jwts.parser()
                        .setSigningKey(secretKey) // 비밀키 설정
                        .parseClaimsJws(jwt) // 토큰 검증 및 파싱
                        .getBody(); // payload(claims) 추출
        }catch(Exception exception) {
            exception.printStackTrace();
            return null;
        }
        
        return claims.getSubject(); // jwt payload에 포함된 sub 반환
    }
    
    
}
/* 페이로드 예시
 { 
  "sub": "user123",
  "exp": 1717300000,
  "role": "admin"
}
 */