package com.dvsnier.base.adapter;

import android.content.Context;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * Created by lizw on 2016/5/18.
 */
public abstract class BaseRecyclerViewAdapter<T, VH extends RecyclerView.ViewHolder> extends AbstractRecyclerViewAdapter<T, RecyclerView.ViewHolder> {

    public BaseRecyclerViewAdapter() {
    }

    public BaseRecyclerViewAdapter(@NonNull Context context) {
        super(context);
    }

    public BaseRecyclerViewAdapter(@NonNull Context context, List<T> data) {
        super(context, data);
    }

    @Override
    @CallSuper
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    }
}
