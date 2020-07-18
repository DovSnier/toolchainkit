package com.dvsnier.toolchain.demo.presenter;

import android.util.Log;
import android.widget.Toast;

import com.dvsnier.toolchain.demo.view.DemoActivity;
import com.dvsnier.support.presenter.SupportPresenter;
import com.dvsnier.utils.LogUtil;
import com.dvsnier.utils.ThreadUtil;
import com.dvsnier.utils.UiThreadUtil;

/**
 * DemoPresenter
 * Created by DovSnier on 2018/7/14.
 */
public class DemoPresenter extends SupportPresenter<DemoActivity> {

    public void request() {
        LogUtil.printThread(TAG, "request()");
        // 测试线程工具类
        ThreadUtil.execute(new Runnable() {
            @Override
            public void run() {
                final long currentTimeMillis = System.currentTimeMillis();
                LogUtil.printThread(TAG, "execute()");
                Log.d(TAG, String.format("%-12s%2$s", "[模拟]请求网络...", currentTimeMillis));
                final long millis = Double.valueOf(Math.random() * 5000).longValue();
                try {
                    Thread.sleep(millis);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.d(TAG, String.format("%-12s%2$s", "[模拟]网络数据...", millis));
                if (getView() != null) {
                    UiThreadUtil.getInstance().runUiThread(getView(), new Runnable() {
                        @Override
                        public void run() {
                            Log.d(TAG, String.format("%-12s%2$s", "[模拟]测试数据...", "成功"));
                            Toast.makeText(getView(), "Demo 模拟数据测试成功。", Toast.LENGTH_SHORT).show();
                        }
                    }, 200);
                }
            }
        });
    }
}
