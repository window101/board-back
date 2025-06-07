
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

    public BoardEntity(PostBoardRequestDto dto, String email) {
        
        Date now = Date.from(Instant.now());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String writeDatetime = simpleDateFormat.format(now);
        this.title = dto.getTitle();
        this.content = dto.getContent();
        this.writeDatetime = writeDatetime;
        this.favoriteCount = 0;
        this.commentCount = 0;
        this.viewCount = 0;
        this.writerEmail = email;
    }
}
