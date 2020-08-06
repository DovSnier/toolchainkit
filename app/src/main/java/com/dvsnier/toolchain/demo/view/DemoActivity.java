package com.dvsnier.toolchain.demo.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.dvsnier.common.compat.ICompatBaseView;
import com.dvsnier.toolchain.demo.R;
import com.dvsnier.toolchain.demo.presenter.DemoPresenter;
import com.dvsnier.support.view.SupportActivity;
import com.dvsnier.utils.ThreadUtil;

/**
 * DemoActivity
 * Created by DovSnier on 2018/7/14.
 */
public class DemoActivity extends SupportActivity<DemoPresenter> implements ICompatBaseView {

    private TextView content;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        initView();
        initData();
    }

    @Override
    public void initView() {
        Log.d(TAG, String.format("%-19s%2$s", "initView()...", Runtime.getRuntime().availableProcessors()));
        content = (TextView) findViewById(R.id.content);
        content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThreadUtil.execute(new Runnable() {
                    @Override
                    public void run() {
                        initData();
                    }
                });
            }
        });
    }

    @Override
    public void initData() {
        Log.d(TAG, "initData()...");
        if (null != getPresenter()) {
            getPresenter().request();
        }
    }
}