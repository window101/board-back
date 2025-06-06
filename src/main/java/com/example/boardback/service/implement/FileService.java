

public interface FileService {
    
    String upload(MultipartFile file);
    Resource getImage(String fileName);
}
