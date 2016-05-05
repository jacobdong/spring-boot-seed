package site.igeek.model.common;

import org.apache.log4j.Logger;
import site.igeek.exception.ControllerError;

/**
 * Created by jacobdong on 15/8/18.
 */
public class JsonResponse<T> {

    private static final Logger LOGGER = Logger.getLogger(JsonResponse.class);

    private boolean success;

    private T data;
    private Integer code;
    private String error;
    private String errorDesc;


    public JsonResponse() {
    }


    public JsonResponse(T data) {
        this.success = true;
        this.data = data;
    }

    public static JsonResponse createError(ControllerError error) {
        JsonResponse jsonResponse = new JsonResponse();

        jsonResponse.success = false;
        jsonResponse.error = error.name();
        jsonResponse.errorDesc = error.getErrorMessage();
        jsonResponse.code = error.getErrorCode();

        LOGGER.debug(error.toString());
        return jsonResponse;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public void setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
