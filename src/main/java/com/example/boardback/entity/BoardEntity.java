
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="board")
@Table(name="board") // 데이터베이스의 board 테이블과 매핑(ORM)
public class BoardEntity {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) // AUTO INCREMENT
    private int boardNumber;
    private String title;
    private String content;
    private String write_datetime;
    private int favoriteCount;
    private int commentCount;
    private int viewCount;
    private String writerEmail; 


}
