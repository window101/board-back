
@Service
public class FileServiceImplement implements FileService {

    @Value("${file.path}")
    private String filePath;

    @Value("${file.url}")
    private String fileUrl;

    @Override
    public String upload(MultipartFile file) {
        if(file.isEmpty()) {
            return null;
        }
        String originalFileName = file.getOriginalFilename(); // 파일의 이름
        String extension = originalFileName.substring(originalFileName.lastIndexOf(".")); // 확장자 받아오기
        String uuid = UUID.randomUUID().toString(); 
        String saveFileName = uuid + extension; // 새로운 파일이름 지정
        String savePath = filePath + saveFileName; //저장할 곳
        try {
            file.transferTo(new File(savePath));
        }catch(Exception exception) {
            exception.printStackTrace();
            return null;
        }

    }
    @Override
    public Resource getImage(String fileName) {

    }
}
