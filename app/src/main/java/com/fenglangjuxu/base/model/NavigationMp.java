package com.fenglangjuxu.base.model;

import android.app.Activity;
import android.app.Application;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.fenglangjuxu.base.utils.CurrentActivityUtil;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;

/**
 * @author syj
 * @date 2019/6/19
 */
public class NavigationMp extends BaseViewModel {
    public NavigationMp(@NonNull Application application) {
        super(application);
    }

    public NavigationMp(@NonNull Application application, String title){
        this(application, title, null);
    }

    public NavigationMp(@NonNull Application application, String title, String right){
        this(application);
        this.title.set(title);
        if (right != null){
            this.right.set(right);
            this.showRight.set(true);
        }else {
            this.showRight.set(false);
        }
    }
    public ObservableField<String> title = new ObservableField<>("");
    public ObservableBoolean showRight = new ObservableBoolean(false);
    public ObservableField<String> right= new ObservableField<>("");
    public BindingCommand back = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            Activity currentActivity = CurrentActivityUtil.getCurrentActivity();
            if (currentActivity != null) {
                currentActivity.finish();
            }
        }
    });
}
