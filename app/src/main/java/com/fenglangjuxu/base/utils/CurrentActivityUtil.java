package com.fenglangjuxu.base.utils;

import android.app.Activity;
import android.util.Log;

import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.LifecycleTransformer;

/**
 * @author syj
 * @date 2019/6/19
 */
public class CurrentActivityUtil {
    protected static Activity currentActivity;
    protected static LifecycleProvider currentLifecycleProvider;

    public static Activity getCurrentActivity() {

        return currentActivity;
    }

    public static void setCurrentActivity(Activity currentActivity) {
        if (currentActivity==null){
            Log.d("CurrentActivityUtil","清除当前Activity");
        }else{
            Log.d("CurrentActivityUtil","设置当前Activity->"+currentActivity.getClass().getSimpleName());
        }

        CurrentActivityUtil.currentActivity = currentActivity;
    }
    public static void setRxLifecycle(LifecycleProvider lifecycleProvider){
        currentLifecycleProvider=lifecycleProvider;
    }

    public static LifecycleTransformer bindCurrentActivity() {
        if (currentLifecycleProvider==null){
            return null;
        }
        return currentLifecycleProvider.bindToLifecycle();
    }
}
