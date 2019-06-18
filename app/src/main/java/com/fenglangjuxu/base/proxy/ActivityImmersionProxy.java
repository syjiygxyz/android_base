package com.fenglangjuxu.base.proxy;

import android.app.Activity;

/**
 * @author syj
 * @date 2019/6/10
 */
public class ActivityImmersionProxy {
    private Activity mActivity;
    private SimpleImmersionOwner mSimpleImmersionOwner;
    public ActivityImmersionProxy(Activity activity) {
        this.mActivity = activity;
        if (activity instanceof SimpleImmersionOwner){
            this.mSimpleImmersionOwner = (SimpleImmersionOwner)activity;
        }else {
            throw new IllegalArgumentException("Activity must implements SimpleImmersionOwner interface");
        }
    }

    public void onCreated(){
        if (mActivity != null){
            mSimpleImmersionOwner.initImmersionBar();
        }
    }

    public void onDesdroy(){
        mActivity = null;
        mSimpleImmersionOwner = null;
    }
}
