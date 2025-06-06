
@Service
@RequiredArgsConstructor
public class UserServiceImplement implements UserService{
    private final UserRepository userRepository;
    @Override
    public ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(String email) {
        UserEntity userEntity = null;

        try{
            userEntity = userRepository.findByEmail(email);
            if(userEntity == null) {
                return GetSignInUserResponseDto.notExistUser();
            }
        }catch(Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetSignInUserResponseDto.success(userEntity);
    }
}
