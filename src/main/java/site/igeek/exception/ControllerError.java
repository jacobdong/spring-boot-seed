package site.igeek.exception;

/**
 * Created by jacobdong on 16/3/21.
 */
public enum ControllerError {
    SYSTEM_AUTHENTICATION_MAINTAIN("认证系统正在维护中", 10000000);

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
