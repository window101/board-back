
@Repository
public interface UserRepository extends JpaRepository<UserEntity, String>{
    //respository 는 interface로 jpa <어떤 entity, 그 entity의 pk 타입>

    boolean existsByEmail(String email); // 쿼리 메서드 -> 알아서 sql문으로 변환
    boolean existsByNickname(String nickname);
    boolean existsByTelNumber(String telNumber);

    UserEntity findByEmail(String email); // 사용자 정보를 조회해서 사용자 엔티티 하나를 받아와서 UserEntity 타입 (객체반환)

}
