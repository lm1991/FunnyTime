package com.mesor.funnytime.main.model;

import com.mesor.funnytime.App;
import com.mesor.funnytime.base.BaseModel;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Limeng on 2017/11/26.
 */

//TODO
public class MainModel extends BaseModel {

    private final int pageSize = 20;

    //TODO multi pages
    /**
     * The oldest and newest date of current display medias.
     */
    private Date oldDateOfMedia = null, newDateOfMedia = null;

    public MainModel(App app) {
        super(app);
    }

    /**
     * Refresh Media List
     * Request Data From Network
     * @return
     */
    public List<Media> refresh() {
        return null;
    }

    public List<Media> getNextPage() {
        if (oldDateOfMedia == null) {
        }
        return  null;
    }

    private List<Media> getLocalMedia(Date date) {
        List<Media> list = app.getDaoSession().getMediaDao().queryRaw(MediaDao.Properties.Date.columnName + "<", date.toString());
        if (list == null) return new ArrayList<>();
        return list;
    }


}
