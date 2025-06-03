

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="user")
@Table(name="user") // 데이터베이스의 user 테이블과 매핑(ORM)
public class UserEntity {
    
    @Id // 키
    private String email;
    private String password;
    private String nickname;
    private String telNumber;
    private String address;
    private String addressDetail;
    private String profileImage;
    private boolean agreedPersonal;

    public UserEntity(SignUpRequestDto dto) {
        this.email = dto.getEmail();
        this.password = dto.getPassword();
        this.nickname = dto.getNickname();
        this.telNumber = dto.getTelNumber();
        this.address = dto.getAddress();
        this.addressDetail = dto.getAddressDetail();
        this.agreedPersonal = dto.getAgreedPersonal();
    }
    // entity 만들었으면 그에 맞는 repository도 만들어야
}
