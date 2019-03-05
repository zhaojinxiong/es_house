package com.coder.es_house.base;

/**
 * @author:apple
 * @date: 2019/2/8
 * @time: 上午10:23
 */
public class ApiResponse {
    private int code;
    private String message;
    private Object data;
    private boolean more;

    public ApiResponse(int code, String message, Object data, boolean more) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.more = more;
    }

    public ApiResponse() {
        this.code = Status.SUCCESS.getCode();
        this.message = Status.SUCCESS.getStandardMessage();
    }

    public static  ApiResponse ofMessage(int code ,String message){
        return  new ApiResponse(code,message,null,false);
    }

    public static  ApiResponse ofSuccess(Object data){
        return  new ApiResponse(Status.SUCCESS.getCode(),Status.SUCCESS.getStandardMessage(),data,false);
    }

    public static ApiResponse ofStatus(Status status){
        return  new ApiResponse(status.getCode(),status.getStandardMessage(),null,false);
    }

    public enum Status {
        SUCCESS(200,"OK"),
        BAD_REQUEST(400,"Bad Request"),
        NOT_FOUND(404,"Not Found"),
        INTERNAL_SERVER_ERROR(500,"Unknown Internal Error"),
        NOT_VALID_PARAM(40005,"Not valid Params"),
        NOT_SUPPORTED_OPERATION(40006,"Operation not supported"),
        NOT_LOGIN(50000,"Not Login");

        private int code;
        private String standardMessage;

        Status(int code, String standarMessage){
            this.code = code;
            this.standardMessage = standardMessage;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getStandardMessage() {
            return standardMessage;
        }

        public void setStandardMessage(String standardMessage) {
            this.standardMessage = standardMessage;
        }
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isMore() {
        return more;
    }

    public void setMore(boolean more) {
        this.more = more;
    }
}
