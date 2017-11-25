package com.mesor.funnytime.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.avos.avoscloud.AVAnalytics;

import butterknife.ButterKnife;

/**
 * Created by mesor on 2017/11/23.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //AVAnalytics.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //AVAnalytics.onPause(this);
    }
}
