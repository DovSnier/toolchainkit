package com.dvsnier.toolchain.demo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.dvsnier.base.adapter.BaseRecyclerViewAdapter;
import com.dvsnier.toolchain.demo.R;
import com.dvsnier.toolchain.demo.bean.MainBean;
import com.dvsnier.toolchain.demo.holder.ContentViewHolder;

import java.util.List;

/**
 * MainAdapter
 * Created by DovSnier on 2018/7/15.
 */
public class MainAdapter extends BaseRecyclerViewAdapter<MainBean, RecyclerView.ViewHolder> {

    public MainAdapter() {
    }

    public MainAdapter(@NonNull Context context) {
        super(context);
    }

    public MainAdapter(@NonNull Context context, List<MainBean> data) {
        super(context, data);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ContentViewHolder(getContext(), R.layout.view_holder_content, parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        if (null != holder) {
            MainBean item = getItem(position);
            if (holder instanceof ContentViewHolder) {
                ((ContentViewHolder) holder).setOnClickListener(getOnClickListener());
                ((ContentViewHolder) holder).onBindViewHolder(getContext(), position, item);
            } else {
                // nothing to do
            }
        }
    }
}
