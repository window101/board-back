
@RestController
@RequestMapping("/file")
@RequiredArgsConstructor
public class FileController {
    private file FileService fileService;
 
    public String upload(@RequestParam("file") MultipartFile file) { // 이미지 업로드
        String url = fileService.upload(file);
        return url;
    }
    @GetMapping(value="{fileName}", produces={MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE}) // 이미지 불러오기
    public Resource getImage(@PathVariable("fileName") String fileName) {
        Resource resource = fileService.getImage(fileName);
        return resource;
    }
}
