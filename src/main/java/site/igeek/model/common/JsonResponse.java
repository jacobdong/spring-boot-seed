package site.igeek.model.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import site.igeek.exception.ControllerError;

/**
 * Created by jacobdong on 15/8/18.
 */
public class JsonResponse<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonResponse.class);


    private T data;
    private Integer code;
    private String error;
    private String errorDesc;


    public JsonResponse() {
        //保留空构造方法
    }


    public JsonResponse(T data) {
        this.code = 65536;
        this.data = data;
    }

    public static JsonResponse createError(ControllerError error) {
        JsonResponse jsonResponse = new JsonResponse();
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

}
