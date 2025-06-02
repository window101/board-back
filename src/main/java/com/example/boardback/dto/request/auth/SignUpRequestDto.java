
@Getter
@Setter
@NoArgsConstructor
public class SignUpRequestDto {
   
    @NotBlank @Email// null과 빈문자열, 공백 아니어야 함
    private String email;

    @NotBlank @Size(min=8, max=20)
    private String password;

    @NotBlank
    private String nickname;

    @NotBlank @Pattern(regexp="^[0-9]{11,13}$") // 0~9 숫자이면서 11~13자리
    private String telNumber;

    @NotBlank
    private String address;
    
    private String addressDetail;

    @NotNull @AssertTrue // true만 받는다
    private Boolean agreedPersonal; // 개인정보 동의여부

}
