package com.dvsnier.demo.presenter;

import android.util.Log;
import android.widget.Toast;

import com.dvsnier.common.presenter.BasePresenter;
import com.dvsnier.demo.MainActivity;
import com.dvsnier.utils.LogUtil;
import com.dvsnier.utils.ThreadUtil;
import com.dvsnier.utils.UiThreadUtil;

/**
 * MainPresenter
 * Created by dovsnier on 2018/7/2.
 */
public class MainPresenter extends BasePresenter<MainActivity> {

    public void request() {
        LogUtil.printThread(TAG, "request()");
        // 测试线程工具类
        ThreadUtil.execute(new Runnable() {
            @Override
            public void run() {
                final long currentTimeMillis = System.currentTimeMillis();
                Log.d(TAG, String.format("%-12s%2$s", "[模拟]请求网络...", currentTimeMillis));
                final long millis = Double.valueOf(Math.random() * 5000).longValue();
                try {
                    Thread.sleep(millis);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.d(TAG, String.format("%-12s%2$s", "[模拟]网络数据...", millis));
                if (getActivity() != null) {
                    UiThreadUtil.getInstance().runUiThread(getActivity(), new Runnable() {
                        @Override
                        public void run() {
                            Log.d(TAG, String.format("%-12s%2$s", "[模拟]测试数据...", "成功"));
                            Toast.makeText(getActivity(), "Demo 模拟数据测试成功。", Toast.LENGTH_SHORT).show();
                        }
                    }, 2000);
                }
            }
        });
    }
}
