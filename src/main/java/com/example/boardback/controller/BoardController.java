
@RestController
@RequestMapping("/api/v1/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping("")
    public ResponseEntity<? super PostBoardResponseDto> postBoard(
        @RequestBody @Valid PostBoardResponseDto requestBody,
        @AuthenticationPrincipal String email
    ) {
        ResponseEntity<? super PostBoardResponseDto> response = boardService.postBoard(requestBody, email);
        return response;
    }
}
/*
 이 요청은 먼저 보내기 전에 /upload 해서 파일 url을 얻은다음
 json 형식으로
 {
    "title" : "제목입니다",
    "content" : "내용입니다",
    "boardImageList" : [
            "http://~",
            "http://~"
        ]
 } 
        보내면됨됨
 */