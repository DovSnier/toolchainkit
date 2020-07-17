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
        clear();
        addAll(data);
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
        clear();
        addAll(data);
    }

    public void add(@NonNull T data) {
        //noinspection ConstantConditions
        if (null != data) {
            this.dataSet.add(data);
        }
    }

    public void add(int index, @NonNull T data) {
        //noinspection ConstantConditions
        if (index >= 0 && null != data) {
            this.dataSet.add(index, data);
        }
    }

    public void addAll(@NonNull List<T> data) {
        //noinspection ConstantConditions
        if (null != data && !data.isEmpty()) {
            this.dataSet.addAll(data);
        }
    }

    public void remove(@NonNull T data) {
        //noinspection ConstantConditions,RedundantCollectionOperation
        if (null != data && this.dataSet.contains(data)) {
            this.dataSet.remove(data);
        }
    }

    public void remove(int index) {
        if (index >= 0 && this.dataSet.size() > index) {
            this.dataSet.remove(index);
        }
    }

    public void removeAll(@NonNull List<T> data) {
        //noinspection ConstantConditions
        if (null != data && !data.isEmpty() && this.dataSet.containsAll(data)) {
            this.dataSet.removeAll(data);
        }
    }

    protected void clear() {
        if (!this.dataSet.isEmpty()) {
            this.dataSet.clear();
        }
    }

    public Context getContext() {
        return context;
    }

    public void setContext(@NonNull Context context) {
        this.context = context;
    }
}
