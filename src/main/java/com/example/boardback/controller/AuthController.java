
@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    
    private final AuthService authService;

    @PostMapping("/sign-up")
    public ResponseEntity<? super SignUpResponseDto> signup(@RequestBody @Valid SignUpRequestDto requestBody) {
        //responseEntity 타입으로 반환, @valid는 유효성 검증(SignUpRequestDto에서)
        ResponseEntity<? super SignUpResponseDto> response = authService.signUp(requestBody);
        return response;
        //ResponseEntity는 사용안해도 Spring이 자동으로 json으로 변환해주긴 하지만 그 이상으로 제어하고 싶을 때 사용함


    }
    @PostMapping("/sign-in")
    public ResponseEntity<? super SignInResponseDto> signIn(@RequestBody @Valid SignInRequestDto requestBody) {
        ResponseEntity<? super SignIpResponseDto> response = authService.signIn(requestBody);
        return response;
    }
}
