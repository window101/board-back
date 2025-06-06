

@Getter
@AllArgsConstructor
public class ResponseDto {
//모든 response는 code와 message를 가지고 있음
    
    private String code;
    private String message;

    public static ResponseEntity<ResponseDto> databaseError() { // responsedto를 반환
        ResponseDto responseBody = new ResponseDto(ResponseCode.DATABASE_ERROR, ResponseMessage.DATABASE_ERROR);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
    }
    public static ResponseEntity<ResponseDto> validationFailed() {
        ResponseDto responseBody = new ResponseDto(ResponseCode.VALIDATION_FAILED, ResponseMessage.VALIDATION_FAILED);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }
}


/*
    front 에서도 api 폴더 밑에 request, response 폴더가 있음
    response 폴더 밑에 Response.dto.ts 있음


 */

