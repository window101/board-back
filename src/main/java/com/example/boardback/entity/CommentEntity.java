
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="comment")
@Table(name="comment") // 데이터베이스의 comment 테이블과 매핑(ORM)
public class CommentEntity {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int commentNumber;
    private String content;
    private String writeDatetime;
    private String userEmail;
    private int boardNumber;

}
