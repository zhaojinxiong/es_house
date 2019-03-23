package com.coder.es_house.service;

/**
 * @author:apple
 * @date: 2019/3/23
 * @time: 上午10:10
 */
public class ServiceResult<T> {

    private boolean success;
    private String message;
    private T result;

    public ServiceResult(boolean success) {
        this.success = success;
    }

    public ServiceResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }


    public ServiceResult(boolean success, String message, T result) {
        this.success = success;
        this.message = message;
        this.result = result;
    }


}
