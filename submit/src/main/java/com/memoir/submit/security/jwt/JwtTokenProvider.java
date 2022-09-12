package com.memoir.submit.security.jwt;

import com.memoir.submit.exception.InvaildTokenException;
import com.memoir.submit.security.auth.AuthDetails;
import com.memoir.submit.security.auth.AuthDetailsService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {

    @Value("${auth.jwt.secret}")
    private String secretKey;

    private static final String HEADER = "Authorization";

    private static final String PREFIX = "Bearer";

    private final AuthDetailsService authDetailsService;

    public String getAccessToken(Long userId) {
        return generateAccessToken(userId);
    }

    // 토큰 생성
    private String generateAccessToken(Long id) {
        return Jwts.builder()
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))
                .setIssuedAt(new Date())
                .setSubject(id.toString())
                .setHeaderParam("typ", "access")
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    // 권한 가져오기
    // Authentication interface는 인증(사용자 신원 확인)을 제공 해준다.
    public Authentication getAuthentication(String token) {
        AuthDetails authDetails = authDetailsService.loadUserByUsername(getId(token));
        return new UsernamePasswordAuthenticationToken(authDetails, "", authDetails.getAuthorities());

    }

    // 토큰 id 불러오기
    private String getId(String token) {
        try {
            return getBody(token).getSubject();
        } catch (Exception e) {
            throw InvaildTokenException.EXCEPTION;
        }
    }

    // Claims : Jwt의 Payload(정보) 부분에서 정보의 한 조각
    private Claims getBody(String token) {

        /* parser() 파서 : 파싱(자료에서 원하는 정보만 가공하고 뽑아서 원하는 때에 불러올 수 있게 하는 것)을 하는 프로그램 = 문자의 구조를
        구문 분석을 행하는 프로그램 */
        return Jwts.parser().setSigningKey(secretKey)
                // .parseClaimsJws()메소드를 통해 토큰을 JWS로 파싱
                // JWS(Json Web Signature) : 서버에서 인증을 증거로 인증 정보를 서버의 private key로 서명한 것을 Token화 한 것
                .parseClaimsJws(token).getBody();
    }

    // Request의 Header에서 token값을 가져온다.
    public String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(HEADER);

        // startsWith() : 어떤 문자열이 특정 문자로 시작하는지 확인하여 결과를 true또는 flase로 반환
        if(bearerToken != null && bearerToken.startsWith(PREFIX)){
            return bearerToken.substring(7);
        }

        return null;
    }

    // 토큰 유효성, 만료일자 검증
    public boolean validateToken(String token) {
        try {

            // Expiration 만료
            // before() 현재 객체가 나타내는 시간보다 앞서는지를 판단, date 값이 주어진 date보다 이전이면 true 반환
            // after() date값이 주어진 date보다 이후이면 false반환
           return getBody(token).getExpiration().after(new Date());
        } catch (Exception e) {
            throw InvaildTokenException.EXCEPTION;
        }
    }
}
