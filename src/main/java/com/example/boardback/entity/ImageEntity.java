
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="image")
@Table(name="image")

public class ImageEntity {
    @Id @GeneratedValue(strategy="GenerationType.IDENTITY")
    private int sequence;
    
    private int boardNumber;
    private String image;
}
