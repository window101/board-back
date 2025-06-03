
@Service
@RequiredArgsConstructor
public class AuthServiceImplement implements AuthService{
    
    
    private final UserRepository userRepository;
    private final JwtProvider jwtProvider; // 이메일과 비번이 맞으면 토큰을 만들어 주려고 ->create()로

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); // 의존성 직접 주입(비번 암호화 위해)


    @Override
    ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto) {
        
        
        try {
            String email = dto.getEmail();
            boolean existedEmail = userRepository.existsByEmail(email);
            if(existedEmail) {
                return SignUpResponseDto.duplicateEmail(); // email이 존재하면 responsedto에 있는 duplicateEmail 반환
            }
            String nickname = dto.getNickname();
            boolean existedNickname = userRepository.existsByNickname(nickname);
            if(existedNickname) {
                return SignUpResponseDto.duplicateNickname();
            }
            String telNumber = dto.getTelNumber();
            boolean existedTelNumber = userRepository.existsByTelNumber(telNumber);
            if(existedTelNumber) {
                return SignUpResponseDto.duplicateTelNumber();
            }

            String password = dto.getPassword();
            //jpa security에 있는 password encorder
            String encodedPassword = passwordEncoder.encode(password); // 패스워드 암호화
            dto.setPassword(encodedPassword);

            UserEntity userEntity = new UserEntity(dto); // UserEntity에 정의되어있음
            userRepository.save(userEntity); // userRepository를 통해서 저장장

        }catch(Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError(); // 실패시 데이터베이스 에러 메세지
        }
        return SignUpResponseDto.success(); // 성공시 기본 성공메서드
    }

    @Override
    public ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto) {
        String token = null;
        try {
            String email = dto.getEmail();
            UserEntity userEntity = userRepository.findByEmail(email);
            if(userEntity == null) {
                return SignInResponseDto.signInFail();
            }
            String password = dto.getPassword();
            String encodedPassword = userEntity.getPassword(); // userEntity에 있는 암호화된 패스워드
            boolean isMatched = passwordEncoder.matches(password, encodedPassword);
            if(!isMatched ) {
                return SignInResponseDto.signInFail();
            }
            token = jwtProvider.create(email); // 토큰 만들어줌
            

        }catch(Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return SignInResponseDto.success(token);
    }
}
