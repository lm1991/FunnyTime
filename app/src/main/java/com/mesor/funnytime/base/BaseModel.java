package com.mesor.funnytime.base;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.mesor.funnytime.App;

/**
 * Created by Limeng on 2017/11/26.
 */

public abstract class BaseModel {
    public final App app;

    public BaseModel(App app) {
        this.app = app;
    }

    protected boolean isNetworkConnected() {
        ConnectivityManager mConnectivityManager = (ConnectivityManager) app
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
        if (mNetworkInfo != null) {
            return mNetworkInfo.isAvailable();
        }
        return false;
    }

}
