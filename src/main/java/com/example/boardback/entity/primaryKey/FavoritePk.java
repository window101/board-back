

//favorite 테이블이 외래키만 있기 때문에 현재 pk가 없음. 따라서, pk 만들어주기 위해서

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FavoritePk implements Serializable{
    @Column(name="user_email")
    private String userEmail;
    @Column(name="board_number")
    private int boardNumber;
}
