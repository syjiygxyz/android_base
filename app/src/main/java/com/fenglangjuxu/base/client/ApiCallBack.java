package com.fenglangjuxu.base.client;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class ApiCallBack<T> implements Observer<ApiResult<T>> {

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onNext(ApiResult<T> tApiResult) {
        if (tApiResult.getStatusCode() == 200){
            success(tApiResult.getData());
        }else {
            error(tApiResult.getStatusCode(), tApiResult.getMessage());
        }
    }

    @Override
    public void onError(Throwable e) {

    }

    protected abstract void success(T data);
    protected abstract void error(int errorCode,String message);
}
