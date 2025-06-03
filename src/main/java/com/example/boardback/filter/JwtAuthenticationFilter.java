
package com.example.boardback.filter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter{

    // client 요청 시 Filter를 거쳐서 controller로 넘어감
    // Filter에서 jwt 검증을 하고 email을 검증함


    private final JwtProvider jwtProvider; // jwt를 검증하고 사용자 정보 추출, 외부에서 주입받는 의존성성

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        // 모든 요청마다 실행
        try {
            String token = parseBearerToken(request);
            if(token == null) {
                // 검증실패
                filterChain.doFilter(request, response); // 다음 필터로 넘김
                return;
            }
            String email = jwtProvider.validate(token); // email 꺼내옴
            if(email == null) {
                filterChain.doFilter(request, response); // 다음 필터로 넘김
                return;
            }
            //Context에 등록 -> 다른데서도 쓰게 하기 위해
            AbstractAuthenticationToken authenticationToken = 
                new UsernamePasswordAuthenticationToken(email, null, AuthorityUtils.NO_AUTHORITIES);
            // 정보가 담김
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContext securityContext = SecurityContextHolder.createEmptyContext(); // 비어있는 context 하나 만들고
            securityContext.setAuthentication(authenticationToken);

            SecurityContextHolder.setContext(securityContext);
        }catch(Exception exception) {
            exception.printStackTrace();
        }
        filterChain.doFilter(request, response); // 다음 필터로 넘김김
        
    }

    private String parseBearerToken(HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");
        boolean hasAuthorization = StringUtils.hasText(authorization); // 길이가 0이거나 그렇지 않으면 true
        if(!hasAuthorization) return null;
        boolean isBearer = authorization.startsWith("Bearer ");
        if(!isBearer) return null;

        String token = authorization.substring(7);
        return token;

    }









}
