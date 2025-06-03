
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="board_list_view")
@Table(name="board_list_view") 
public class BoardListViewEntity {
    // 일전에 게시물 조회 sql에서 view로 단순화 했음
    
    @Id
    private int boardNumber;
    private String title;
    private String content;
    private String titleImage;
    private int viewCount;
    private int favoriteCount;
    private int commentCount;
    private String writeDatetime;
    private String writerEmail;
    private String writerNickname;
    private String writerProfileImage;
}
