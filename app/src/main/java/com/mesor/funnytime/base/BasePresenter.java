package com.mesor.funnytime.base;

/**
 * Created by Limeng on 2017/11/26.
 */

public class BasePresenter<T extends BaseView> {
    protected T view;

    /**
     * need override
     */
    protected void initModel() {
    }

    void attachView(T view){
        this.view = view;
        initModel();
    }

    void detachView() {
        this.view = null;
    }
}
