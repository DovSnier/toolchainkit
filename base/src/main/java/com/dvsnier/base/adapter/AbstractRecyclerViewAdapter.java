package com.dvsnier.base.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.dvsnier.base.IBaseOnClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * abstract Base Recycle Adapter View
 * Created by lizw on 2016/5/18.
 */
public abstract class AbstractRecyclerViewAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    protected final String TAG = this.getClass().getSimpleName();
    protected Context context;
    @SuppressWarnings("WeakerAccess")
    protected List<T> dataSet = new ArrayList<>();
    protected IBaseOnClickListener onClickListener;

    public AbstractRecyclerViewAdapter() {
    }

    public AbstractRecyclerViewAdapter(@NonNull Context context) {
        this.context = context;
    }

    public AbstractRecyclerViewAdapter(@NonNull Context context, List<T> data) {
        this.context = context;
        if (null != data && !data.isEmpty()) {
            this.dataSet.addAll(data);
        }
    }

    @Override
    public int getItemCount() {
        return null != dataSet ? dataSet.size() : 0;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public T getItem(int position) {
        return dataSet.get(position);
    }

    public IBaseOnClickListener getOnClickListener() {
        return onClickListener;
    }

    public void setOnClickListener(IBaseOnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public List<T> getData() {
        return dataSet;
    }

    public void setData(@NonNull List<T> data) {
        //noinspection ConstantConditions
        if (null != data && !data.isEmpty()) {
            if (!this.dataSet.isEmpty()) {
                this.dataSet.clear();
            }
        }
        this.dataSet.addAll(data);
    }

    public Context getContext() {
        return context;
    }

    public void setContext(@NonNull Context context) {
        this.context = context;
    }
}
