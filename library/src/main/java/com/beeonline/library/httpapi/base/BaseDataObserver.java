package com.beeonline.library.httpapi.base;

import com.beeonline.library.httpapi.bean.BaseData;
import com.beeonline.library.httpapi.exception.ApiException;
import com.beeonline.library.httpapi.interfaces.IDataSubscriber;
import com.beeonline.library.utils.DD;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Allen on 2017/10/27.
 *
 * @author Allen
 * <p>
 * 基类BaseObserver使用BaseData
 */

public abstract class BaseDataObserver<T extends BaseData> implements Observer<T>, IDataSubscriber<T> {

    @Override
    public void onSubscribe(Disposable d) {
        doOnSubscribe(d);
    }

    @Override
    public void onNext(T baseData) {
//        DD.dd("onNext", new Gson().toJson(baseData));
        doOnNext(baseData);
    }

    @Override
    public void onError(Throwable e) {
        String error = ApiException.handleException(e).getMessage();
        int code = ApiException.handleException(e).getCode();
        DD.dd("onError", code + " " + error);
        setError(code, error);
    }

    @Override
    public void onComplete() {
        doOnCompleted();
    }

    private void setError(int errorCode, String errorMsg) {
        doOnError(errorCode, errorMsg);
    }

}
