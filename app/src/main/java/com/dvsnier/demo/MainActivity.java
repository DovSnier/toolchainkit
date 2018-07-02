package com.dvsnier.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.dvsnier.base.view.IBaseView;
import com.dvsnier.common.view.BaseCompatActivity;
import com.dvsnier.demo.presenter.MainPresenter;
import com.dvsnier.utils.ThreadUtil;

/**
 * MainActivity
 */
public class MainActivity extends BaseCompatActivity<MainPresenter> implements IBaseView {

    private TextView content;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
