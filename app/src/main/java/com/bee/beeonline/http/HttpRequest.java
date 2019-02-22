package com.bee.beeonline.http;

import com.bee.beeonline.BuildConfig;
import com.bee.beeonline.bean.UploadResoutData;
import com.beeonline.library.httpapi.RxHttpUtils;
import com.beeonline.library.httpapi.bean.BaseGenericityData;
import com.beeonline.library.httpapi.interceptor.Transformer;
import com.beeonline.library.httpapi.observer.DataObserver;
import com.beeonline.library.utils.DD;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by 59395 on 2018/3/3.
 */

public class HttpRequest {

    public static void requestConfig() {
        Map<String, Object> headerMaps = new HashMap<>();
        headerMaps.put("Content-Type", "application/json; charset=UTF-8");
//        headerMaps.put("Accept-Encoding", "gzip, deflate");
        headerMaps.put("Connection", "keep-alive");
        headerMaps.put("Accept", "*/*");
        headerMaps.put("Cookie", "add cookies here");
        RxHttpUtils
                .getInstance()
                //开启全局配置
                .config()
                //全局的BaseUrl
                .setBaseUrl(Url.BASE_URL)
                //开启缓存策略
//                .setCache()
                //全局的请求头信息
                .setHeaders(headerMaps)
                //全局持久话cookie,保存本地每次都会携带在header中
                .setCookie(false)
                //全局ssl证书认证
                //信任所有证书,不安全有风险
                .setSslSocketFactory()
                //使用预埋证书，校验服务端证书（自签名证书）
                //.setSslSocketFactory(getAssets().open("your.cer"))
                //使用bks证书和密码管理客户端证书（双向认证），使用预埋证书，校验服务端证书（自签名证书）
                //.setSslSocketFactory(getAssets().open("your.bks"), "123456", getAssets().open("your.cer"))
                //全局超时配置
                .setReadTimeout(30)
                //全局超时配置
                .setWriteTimeout(10)
                //全局超时配置
                .setConnectTimeout(10)
                //全局是否打开请求log日志
                .setLog(BuildConfig.DEBUG);
    }

    public static ApiService createApi() {
        return RxHttpUtils.createApi(ApiService.class);
    }


    public static void uploadImg(List<String> imgs, final OnUploadLis lis) {
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);
        for (String file : imgs) {
            DD.dd("upload:", file);
            File f = new File(file);
            RequestBody requestBody = RequestBody.create(MediaType.parse("image/png"), f);
            long name = System.currentTimeMillis() / 1000;
            builder.addPart(MultipartBody.Part.createFormData("appimg[]", name + ".png", requestBody));
        }
        createApi()
                .upload(builder.build())
                .compose(Transformer.<BaseGenericityData<UploadResoutData>>switchSchedulers())
                .subscribe(new DataObserver<BaseGenericityData<UploadResoutData>>() {
                    @Override
                    protected void onError(int errorCode, String errorMsg) {
                        if (lis != null)
                            lis.onError(errorCode, errorMsg);
                    }

                    @Override
                    protected void onSuccess(BaseGenericityData<UploadResoutData> data) {
                        if (lis != null)
                            lis.onSuccess(data.data);
                    }
                });
    }

    public static List<String> getUpFiles(List<String> files) {
        List<String> up = new ArrayList<>();
        for (String file : files) {
            if (file != null && !file.startsWith("http:") && !file.startsWith("https:"))
                up.add(file);
        }
        return up;
    }


    public static abstract class OnUploadLis {
        protected abstract void onError(int code, String msg);

        protected abstract void onSuccess(UploadResoutData data);
    }
}
