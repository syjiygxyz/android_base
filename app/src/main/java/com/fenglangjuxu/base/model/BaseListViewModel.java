package com.fenglangjuxu.base.model;

import android.app.Application;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.tatarka.bindingcollectionadapter2.BindingRecyclerViewAdapter;
import me.tatarka.bindingcollectionadapter2.collections.MergeObservableList;
import me.tatarka.bindingcollectionadapter2.itembindings.OnItemBindClass;

/**
 * @author syj
 * @date 2019/6/10
 */
public abstract class BaseListViewModel<T> extends BaseViewModel {
    /**
     * 数据集合
     */
    public final ObservableList<T> items = new ObservableArrayList<>();
    /**
     * 头、尾、数据合集
     */
    public final MergeObservableList<Object> headerFooterItems = new MergeObservableList<>();

    /**
     * 类型映射
     */
    public final OnItemBindClass<Object> multipleItems = new OnItemBindClass<>();

    /**
     * 适配器
     */
    public final BindingRecyclerViewAdapter adapter = new BindingRecyclerViewAdapter();

    /**
     * View绑定
     */
    public final BindingRecyclerViewAdapter.ViewHolderFactory viewHolder = new BindingRecyclerViewAdapter.ViewHolderFactory() {
        @Override
        public RecyclerView.ViewHolder createViewHolder(ViewDataBinding binding) {
            return new BaseListViewModel.MyViewHolder(binding.getRoot());
        }
    };

    private static class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }

    public BaseListViewModel(Application context) {
        super(context);
        initData();
    }

    protected void initData(){
        initHeaderFooter(headerFooterItems);
        initViewMapping(multipleItems);
        loadData(1);
    }
    protected abstract void loadData(int pageNo);
    protected abstract void initHeaderFooter(MergeObservableList<Object> headerFooterItems);
    protected abstract void initViewMapping(OnItemBindClass<Object> onItemBindClass);
}
