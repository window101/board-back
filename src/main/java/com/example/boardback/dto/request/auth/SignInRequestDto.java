
@Getter
@Setter
@NoArgsConstructor
public class SignInRequestDto {

    @NotBlank
    private String email;

    @NotBlank
    private String password;

}
