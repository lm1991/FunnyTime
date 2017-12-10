package com.mesor.funnytime.main.model;

import com.mesor.funnytime.base.BasePresenter;

/**
 * Created by Limeng on 2017/11/26.
 */

public class MainPresenter extends BasePresenter<MainView> {

    private MainModel model;

    @Override
    protected void initModel() {
        model = new MainModel(view.getApp());
    }

    public void refreshMediaList() {
        model.refresh();
    }

    public void loadMoreMedia() {
        model.getNextPage();
    }

}
