package com.mesor.funnytime;

import android.app.Application;

import com.avos.avoscloud.AVOSCloud;
import com.mesor.funnytime.main.model.DaoMaster;
import com.mesor.funnytime.main.model.DaoSession;

import org.greenrobot.greendao.database.Database;

/**
 * Created by mesor on 2017/11/19.
 */

public class App extends Application {

    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        // 初始化参数依次为 this, AppId, AppKey
        AVOSCloud.initialize(this,"YTAt74fjVszRpnBVu4Fv7IO5-gzGzoHsz","sO2Ryx8G4eyoysmS8spN9D5A");
        // 放在 SDK 初始化语句 AVOSCloud.initialize() 后面，只需要调用一次即可
        AVOSCloud.setDebugLogEnabled(true);
    }

    public synchronized DaoSession getDaoSession() {
        if(daoSession == null) {
            DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "fun_mesor_com_db");
            Database db = helper.getWritableDb();
            daoSession = new DaoMaster(db).newSession();
        }
        return daoSession;
    }
}
