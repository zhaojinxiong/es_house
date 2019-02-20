package com.coder.es_house.service.house;

import com.qiniu.common.QiniuException;

import javax.xml.ws.Response;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Field;

/**
 * 七牛云服务
 * @author:apple
 * @date: 2019/2/20
 * @time: 下午8:48
 */
public interface IQiNiuService {

    Response uploadFile(File file ) throws QiniuException;

    Response uploadFile(InputStream inputStream) throws  QiniuException;

    Response delete(String key) throws QiniuException;




}
