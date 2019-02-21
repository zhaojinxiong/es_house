package com.coder.es_house.web.dto;

/**
 * @author:apple
 * @date: 2019/2/21
 * @time: 下午7:51
 */
public final class QiNiuPutRetc {
    public String key;
    public String hash;
    public String bucket;
    public int size;

    @Override
    public String toString() {
        return "QiNiuPutRetc{" +
                "key='" + key + '\'' +
                ", hash='" + hash + '\'' +
                ", bucket='" + bucket + '\'' +
                ", size=" + size +
                '}';
    }
}
