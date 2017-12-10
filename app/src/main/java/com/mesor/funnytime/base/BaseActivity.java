package com.mesor.funnytime.base;

import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.mesor.funnytime.App;
import com.mesor.funnytime.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mesor on 2017/11/23.
 */

public class BaseActivity extends AppCompatActivity implements BaseView {

    protected final static int CODE_REQUEST_PERMISSION = 0;

    private OnRequestPermissionSuccessListener onRequestPermissionSuccessListener;

    @BindView(R.id.rootView)
    protected View rootView;

    protected BasePresenter presenter;

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (presenter != null)
            presenter.attachView(this);
        //AVAnalytics.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (presenter != null)
            presenter.detachView();
        //AVAnalytics.onPause(this);
    }

    protected void mayRequestPermissions(final String permission, OnRequestPermissionSuccessListener onRequestPermissionSuccessListener) {
        this.onRequestPermissionSuccessListener = onRequestPermissionSuccessListener;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED) {
                if (onRequestPermissionSuccessListener != null)
                    onRequestPermissionSuccessListener.onSuccess();
                return;
            }
            if (shouldShowRequestPermissionRationale(permission)) {
                prompt(R.string.permission_rationale, new PromptActionListener() {
                    @TargetApi(Build.VERSION_CODES.M)
                    @Override
                    public void onPrompt() {
                        requestPermissions(new String[]{permission}, CODE_REQUEST_PERMISSION);
                    }
                });
            } else {
                requestPermissions(new String[]{permission}, CODE_REQUEST_PERMISSION);
            }
            return;
        } else {
            if (this.onRequestPermissionSuccessListener != null) this.onRequestPermissionSuccessListener.onSuccess();
            return;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (onRequestPermissionSuccessListener == null) return;
        if (requestCode == CODE_REQUEST_PERMISSION) {
            if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                onRequestPermissionSuccessListener.onSuccess();
            } else {
                onRequestPermissionSuccessListener.onFailed();
            }
        }
    }

    protected void prompt(int stringId, final PromptActionListener action) {
        if (action != null)
            Snackbar.make(rootView, stringId, Snackbar.LENGTH_INDEFINITE)
                    .setAction(android.R.string.ok, new View.OnClickListener() {
                        @TargetApi(Build.VERSION_CODES.M)
                        @Override
                        public void onClick(View v) {
                            action.onPrompt();
                        }
                    });
        else {
            Snackbar.make(rootView, stringId, Snackbar.LENGTH_INDEFINITE);
        }
    }

    @Override
    public App getApp() {
        return (App) getApplication();
    }

    protected interface PromptActionListener {
        void onPrompt();
    }

    protected interface OnRequestPermissionSuccessListener {
        void onSuccess();

        void onFailed();
    }
}
