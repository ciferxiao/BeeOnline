package com.bee.beeonline.http;

import com.bee.beeonline.bean.CartBaseBean;
import com.bee.beeonline.bean.CartUpdate;
import com.bee.beeonline.bean.HomeDataBean;
import com.bee.beeonline.bean.HomeLikeBean;
import com.bee.beeonline.bean.LimitBaseBean;
import com.bee.beeonline.bean.LoginBean;
import com.bee.beeonline.bean.OrderBaseBean;
import com.bee.beeonline.bean.ShowParentBean;
import com.bee.beeonline.bean.SortBean;
import com.bee.beeonline.bean.SortCate;
import com.bee.beeonline.bean.UploadResoutData;
import com.beeonline.library.httpapi.bean.BaseData;
import com.beeonline.library.httpapi.bean.BaseGenericityData;

import java.util.LinkedHashMap;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * Created by 59395 on 2018/3/3.
 */

public interface ApiService {
    @POST("v1/api.auth.login")//登录接口
    @FormUrlEncoded
    Observable<LoginBean> signin(@FieldMap LinkedHashMap<String, Object> paramsMap);


    @POST("v1/api.auth.mobile.send")//获取验证码
    @FormUrlEncoded
    Observable<BaseData> getCode(@FieldMap LinkedHashMap<String, Object> paramsMap);


    @POST("v1/api.home")
    @FormUrlEncoded
    Observable<HomeDataBean> getHomeData(@FieldMap LinkedHashMap<String, Object> paramsMap);

    @POST("v1/api.show")
    @FormUrlEncoded
    Observable<ShowParentBean> getShowData(@FieldMap LinkedHashMap<String, Object> paramsMap);

    @POST("v1/api.home.like")
    @FormUrlEncoded
    Observable<HomeLikeBean> getHomeLikeData(@FieldMap LinkedHashMap<String, Object> paramsMap);


    @POST("v1/api.cate.cond")
    @FormUrlEncoded
    Observable<SortBean> getCateCondData(@FieldMap LinkedHashMap<String, Object> paramsMap);

    @GET("v1/api.cate")
    Observable<SortCate> getCateData(@QueryMap LinkedHashMap<String, Object> paramsMap);


    @POST("v1/api.cate.goods")
    @FormUrlEncoded
    Observable<HomeLikeBean> getCateGoods(@FieldMap LinkedHashMap<String, Object> paramsMap);


    @POST("v1/api.cart.list")
    @FormUrlEncoded
    Observable<CartBaseBean> getCartListData(@FieldMap LinkedHashMap<String, Object> paramsMap);

    @POST("v1/api.home.sale")
    @FormUrlEncoded
    Observable<LimitBaseBean> getHomeSale(@FieldMap LinkedHashMap<String, Object> paramsMap);


    @POST("v1/api.cart.update")
    @FormUrlEncoded
    Observable<CartUpdate> cartUpdate(@FieldMap LinkedHashMap<String, Object> paramsMap);

    @POST("v1/api.cart.delete")
    @FormUrlEncoded
    Observable<CartUpdate> cartDelete(@FieldMap LinkedHashMap<String, Object> paramsMap);


    @POST("v1/api.cart.cancel")
    @FormUrlEncoded
    Observable<CartUpdate> cartCancel(@FieldMap LinkedHashMap<String, Object> paramsMap);

    @POST("v1/api.cart.cancel-all")
    @FormUrlEncoded
    Observable<CartUpdate> cartCancelAll(@FieldMap LinkedHashMap<String, Object> paramsMap);

    @POST("v1/api.cart.select")
    @FormUrlEncoded
    Observable<CartUpdate> cartSelect(@FieldMap LinkedHashMap<String, Object> paramsMap);

    @POST("v1/api.cart.select-all")
    @FormUrlEncoded
    Observable<CartUpdate> cartSelectAll(@FieldMap LinkedHashMap<String, Object> paramsMap);

    @POST("v1/api.watch")
    @FormUrlEncoded
    Observable<BaseData> watch(@FieldMap LinkedHashMap<String, Object> paramsMap);

    @POST("/v1/api.upload")
//多图像上传(评论图片), 不用Sign, 返回图片url, 这里的调试暂时不可用, 建议采用其他方式测试多文件上传
    Observable<BaseGenericityData<UploadResoutData>> upload(@Body MultipartBody files);


    @POST("v1/api.order.list")
    @FormUrlEncoded
    Observable<OrderBaseBean> orderList(@FieldMap LinkedHashMap<String, Object> paramsMap);

}
