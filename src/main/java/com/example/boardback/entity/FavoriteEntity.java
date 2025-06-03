
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="favorite")
@Table(name="favorite")
@IdClass(FavoritePk.class) // 복합키 표시
public class FavoriteEntity {
    
    @Id
    private String userEmail;
    
    @Id
    private int boardNumber;
}
