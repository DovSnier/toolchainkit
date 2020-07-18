package com.dvsnier.toolchain.demo.application;

import android.app.Application;

import com.dvsnier.crash.Crash;
import com.facebook.stetho.Stetho;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by dovsnier on 2018/7/2.
 */
public class DvsnierApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Crash.initialize(this);
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        Stetho.initializeWithDefaults(this);
    }
}
