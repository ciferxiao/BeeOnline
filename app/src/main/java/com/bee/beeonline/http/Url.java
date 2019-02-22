package com.bee.beeonline.http;

/**
 * Created by 59395 on 2018/3/3.
 */

public class Url {
    public final static String BASE_URL = "http://api.beeonline.com.cn/";//外网测试环境

    /**
     * 图片地址
     */
    public static final String IMAGE_UPLOAD_URL = "v1/api.upload";//多图像上传(评论图片), 不用Sign, 返回图片url, 这里的调试暂时不可用, 建议采用其他方式测试多文件上传

    /**
     * Bugly上报问题产品 0,测试
     */
    public static final int STYLE = 0;
}
