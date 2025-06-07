
@Service
@RequiredArgsConstructor
public class OAuth2UserServiceImplement extends DefaultOAuth2UserService{
    private final UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest request) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(request);
        String oauthClientName = request.getClientRegistration().getClientName(); // 어떤 oauth로 로그인했는지 
        try {

        }catch(Exception exception) {
            exception.printStackTrace();
        }

        UserEntity userEntity = null;
        String userId = null;
        String email = "email@email.com";

        if(oauthClientName.equals("kakao")) {
            userId = "kakao_" + oAuth2User.getAttributes().get("id");
            userEntity = new UserEntity(userId, email, "kakao");


        }
        if(oauthClientName.equals("naver")) {
            Map<String, String> responseMap = (Map<String, String>)oAuth2User.getAttributes().get("response"); // 아이디를 꺼내오는 과정
            userId = "naver_" + responseMap.get("id").substring(0,14); // 20자리
            email = responseMap.get("email");
            userEntity = new UserEntity(userId, email, "naver"); 
        }
        userRepository.save(userEntity);
        return OAuth2User;
    }
}
