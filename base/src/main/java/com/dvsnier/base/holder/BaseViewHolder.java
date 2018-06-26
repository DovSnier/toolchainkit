package com.dvsnier.base.holder;

import android.content.Context;
import android.support.annotation.CallSuper;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dvsnier.base.IBaseOnClickListener;


/**
 * BaseViewHolder
 * Created by lizw on 2016/5/21.
 */
public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder implements IBaseBindViewHolder<T> {

    protected Context context;
    protected IBaseOnClickListener onClickListener;

    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
        context = itemView.getContext();
    }

    public BaseViewHolder(@NonNull Context context, @LayoutRes int LayoutId, ViewGroup parent) {
        super(LayoutInflater.from(context).inflate(LayoutId, parent, false));
        this.context = context;
    }

    @CallSuper
    @Override
    public void onBindViewHolder(Context context, int position, T bean) {
        // nothing to do
    }

    public Context getContext() {
        return context;
    }

    public void setContext(@NonNull Context context) {
        this.context = context;
    }

    public IBaseOnClickListener getOnClickListener() {
        return onClickListener;
    }

    public void setOnClickListener(IBaseOnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
}
