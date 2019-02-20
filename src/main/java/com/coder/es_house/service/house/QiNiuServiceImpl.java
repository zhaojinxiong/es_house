package com.coder.es_house.service.house;

import com.qiniu.common.QiniuException;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import org.hibernate.procedure.spi.ParameterRegistrationImplementor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.xml.ws.Response;
import java.io.File;
import java.io.InputStream;

/**
 * @author:apple
 * @date: 2019/2/20
 * @time: 下午8:54
 */
@Service
public class QiNiuServiceImpl implements IQiNiuService,InitializingBean {

    @Autowired
    private UploadManager uploadManager;

    @Autowired
    private BucketManager bucketManager;

    @Autowired
    private Auth auth;

    @Value("${qiniu.Bucket}")
    private String bucket;

    private StringMap putPolicy;

    @Override
    public Response uploadFile(File file) throws QiniuException {
        com.qiniu.http.Response response = this.uploadManager.put(file,null,getUploadToken());
        int retry = 0;

        while (response.needRetry() && retry < 3){
            response = this.uploadManager.put(file,null,getUploadToken());
            retry++;
        }
        return null;
    }

    @Override
    public Response uploadFile(InputStream inputStream) throws QiniuException {
        return null;
    }

    @Override
    public Response delete(String key) throws QiniuException {
        return null;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.putPolicy = new StringMap();

        putPolicy.put("returnBody", "{\"key\":\"$(key)\",\"hash\":\"$(etag)\"," +
                "\"bucket\":\"$(bucket)\",\"fsize\":$(fsize)}");
    }

    private String getUploadToken(){
        return this.auth.uploadToken(bucket,null,3600,this.putPolicy);
    }
}
