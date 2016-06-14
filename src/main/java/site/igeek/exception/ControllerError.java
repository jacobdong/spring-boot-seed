package site.igeek.exception;

/**
 * Created by jacobdong on 16/3/21.
 */
public enum ControllerError {
    //SUCCSS 0x000000010000
    SYSTEM_AUTHENTICATION_MAINTAIN("认证系统正在维护中", 0x0000000020000);

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


    public static void main(String[] args) {

        for (ControllerError error : ControllerError.values()) {
            System.out.println(error.name() + error.getErrorCode());
        }

    }
}
