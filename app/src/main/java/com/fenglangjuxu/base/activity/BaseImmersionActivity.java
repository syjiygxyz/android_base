package com.fenglangjuxu.base.activity;

import android.databinding.ViewDataBinding;

import com.fenglangjuxu.base.proxy.ActivityImmersionProxy;
import com.fenglangjuxu.base.proxy.SimpleImmersionOwner;
import com.fenglangjuxu.base.utils.CurrentActivityUtil;

import me.goldze.mvvmhabit.base.BaseActivity;
import me.goldze.mvvmhabit.base.BaseViewModel;

/**
 * @author syj
 * @date 2019/6/10
 */

public abstract class BaseImmersionActivity<V extends ViewDataBinding, VM extends BaseViewModel> extends BaseActivity<V, VM> implements SimpleImmersionOwner {

    private ActivityImmersionProxy mActivityImmersionProxy = new ActivityImmersionProxy(this);

    @Override
    protected void onResume() {
        super.onResume();
        CurrentActivityUtil.setCurrentActivity(this);
        CurrentActivityUtil.setRxLifecycle(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        CurrentActivityUtil.setCurrentActivity(null);
        CurrentActivityUtil.setRxLifecycle(null);
    }

    @Override
    public void initParam() {
        mActivityImmersionProxy.onCreated();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mActivityImmersionProxy.onDesdroy();
    }

    @Override
    public boolean immersionBarEnabled() {
        return true;
    }

}
