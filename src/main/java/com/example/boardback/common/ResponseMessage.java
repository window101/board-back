


public interface ResponseMessage {
    public static final String SUCCESS = "Success"; // 200
    public static final String VALIDATION_FAILED = "Validation failed"; //400
    public static final String DUPLICATE_EMAIL = "Duplicate email"; //400
    public static final String DUPLICATE_NICKNAME = "Duplicate nickname";
    public static final String DUPLICATE_TEL_NUMBER = "Duplicate tel number";
    public static final String NOT_EXISTED_USER = "This User does not exist";
    public static final String NOT_EXISTED_BOARD = "This board does not exist";

    public static final String SIGN_IN_FAIL = "Login information mismatch"; //401
    public static final String AUTHORIZATION_FAIL = "Authorization Failed";

    public static final String NO_PERMISSION = "Do not have permission"; // 403

    public static final String DATABASE_ERROR = "Database error"; //500
}
