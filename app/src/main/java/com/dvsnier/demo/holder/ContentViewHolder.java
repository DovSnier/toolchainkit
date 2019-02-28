package com.dvsnier.demo.holder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dvsnier.base.IBaseOnClickListener;
import com.dvsnier.base.holder.BaseViewHolder;
import com.dvsnier.common.listener.IOnClickListener;
import com.dvsnier.demo.R;
import com.dvsnier.demo.bean.MainBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * ContentViewHolder
 * Created by DovSnier on 2018/7/15.
 */
public class ContentViewHolder extends BaseViewHolder<MainBean> {

    @BindView(R.id.container)
    LinearLayout container;
    @BindView(R.id.content)
    TextView content;

    public ContentViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public ContentViewHolder(@NonNull Context context, int LayoutId, ViewGroup parent) {
        super(context, LayoutId, parent);
//        super(context, R.layout.view_holder_content, parent);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void onBindViewHolder(Context context, final int position, MainBean bean) {
        super.onBindViewHolder(context, position, bean);
        if (null != bean) {
            if (position % 2 == 0) {
                container.setBackgroundColor(ContextCompat.getColor(context, android.R.color.white));
            } else {
                container.setBackgroundColor(ContextCompat.getColor(context, R.color.colorPrimary));
            }
            content.setText(bean.getText());
            content.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (null != getOnClickListener() && getOnClickListener() instanceof IOnClickListener) {
                        ((IOnClickListener) getOnClickListener()).onClick(v, position);
                    }
                }
            });
        }
    }
}