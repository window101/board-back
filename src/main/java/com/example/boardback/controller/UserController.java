
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    
    private final UserService userService;

    @GetMapping("")
    public ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(
        @AuthenticationPrincipal String email

    ) {
        ResponseEntity<? super GetSignInUserResponseDto> response = userService.getSignInUser(email);
        return response;
    }
}

/* JwtAuthenticationFilter는 OncePerRequestFilter를 상속하므로 클라이언트 매 요청마다 실행됨
 @AuthenticationPrinciple은 SecurityContext에 등록된 값(email)을 꺼낼 수 있음
 즉, controller에 요청을 보내도 Filter가 중간에 요청을 가로챔 -> Spring Security의 체인에 등록도 하였고 (WebSecurityConfig)에서
 */
