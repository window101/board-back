
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="search_log")
@Table(name="search_log")
public class SearchLogEntity {
    
    @Id @GeneratedValue(strategy="GenerationType.IDENTITY")
    private int sequence;

    private String searchWord;
    private String relationWord;
    private boolean relation;
}
