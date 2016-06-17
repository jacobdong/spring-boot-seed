package site.igeek.exception;

/**
 * Created by jacobdong on 16/3/21.
 */
public enum ControllerError {
    //SUCCSS 0x000000010000
    ERROR_001("错误一", 0x0000000020000),
    ERROR_002("错误二", 0x0000000020001),
    ERROR_003("错误三", 0x0000000020002),;

    private String errorMessage;
    private Integer errorCode;


    ControllerError(String errorMessage, Integer errorCode) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
