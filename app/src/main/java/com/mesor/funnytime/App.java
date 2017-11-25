package com.mesor.funnytime;

import android.app.Application;

import com.avos.avoscloud.AVOSCloud;

/**
 * Created by mesor on 2017/11/19.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // 初始化参数依次为 this, AppId, AppKey
        AVOSCloud.initialize(this,"YTAt74fjVszRpnBVu4Fv7IO5-gzGzoHsz","sO2Ryx8G4eyoysmS8spN9D5A");
        // 放在 SDK 初始化语句 AVOSCloud.initialize() 后面，只需要调用一次即可
        AVOSCloud.setDebugLogEnabled(true);
    }
}
