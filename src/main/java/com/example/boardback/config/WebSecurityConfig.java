
@Configurable
@EnableWebSecurity
@RequireArgsConstructor
public class WebSecurityConfig {
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final DefaultOAuth2UserService oAuth2UserService;
    
    @Bean
    protected SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity // 기본 cors 정책
            .cors().and()
            .csrf().disable()
            .httpBasic().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and() // session 정책 사용안함
            .authorizeRequests()
            .antMatchers("/", "/api/v1/auth/**", "/api/v1/search/**", "/file/**", "/oauth2/**").permitAll() // 매칭된거만 permit
            .andMatchers(HttpMethod.GET, "/api/v1/board/**", "/api/v1/user/*").permitAll() // board관련 get 요청은 모두 허용
            .oauth2Login(oauth2 -> oauth2
                .redirectionEndpoint(endpoint -> endpoint.baseUri("/oauth2/callback/*"))
                .userInfoEndpoint(endpoint -> endpoint.userService(oAuth2UserService))
            )
            .anyRequest().authenticated().and() // 그 외는 인증을 받도록
            .exceptionHandling().authenticationEntryPoint(new FailedAuthenticationEntryPoint()); // 예외처리시 

        httpSecurity.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build();


    } 




}
class FailedAuthenticationEntryPoint implements AuthenticationEntryPoint { // 인증 실패시시

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setContentType("application/json"); // json 형태로 반환
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 권한 없음
        response.getWriter().write(" {\"code\" : \"AF\", \"message\": \" AUTHORIZATION FAILED.\" }")

    }
}