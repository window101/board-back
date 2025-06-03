


public interface ResponseCode {
    // interface는 무조건 public static final(상수)

    public static final String SUCCESS = "SU"; // 200
    public static final String VALIDATION_FAILED = "VF"; //400
    public static final String DUPLICATE_EMAIL = "DE"; //400
    public static final String DUPLICATE_NICKNAME = "DM";
    public static final String DUPLICATE_TEL_NUMBER = "DT";
    public static final String NOT_EXISTED_USER = "NU";
    public static final String NOT_EXISTED_BOARD = "NB";

    public static final String SIGN_IN_FAIL = "SF"; //401
    public static final String AUTHORIZATION_FAIL = "AF";

    public static final String NO_PERMISSION = "NP"; // 403

    public static final String DATABASE_ERROR = "DBE"; //500
    


    
    
}
