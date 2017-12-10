package com.mesor.funnytime.main.model;

import com.mesor.funnytime.base.BaseView;

import java.util.List;

/**
 * Created by Limeng on 2017/11/26.
 */

public interface MainView extends BaseView {
    void refresh(List<Media> list);
    void stopLoading();
}
