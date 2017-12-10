package com.mesor.funnytime.main.model;

import android.os.Parcel;
import android.os.Parcelable;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;

import java.util.Date;

/**
 * Created by Limeng on 2017/11/26.
 */
@Entity
public class Media implements Parcelable {
    @Id
    private Long id;

    private String authorObjectId;
    private String authorAvatar;

    @NotNull
    private String text;
    private Date date;

    private String coverPath;
    private int mediaType;
    private String mediaPath;
    private int width;
    private int height;

    private int commentCount;
    private int likeCount;

    @Generated(hash = 2138871507)
    public Media(Long id, String authorObjectId, String authorAvatar,
            @NotNull String text, Date date, String coverPath, int mediaType,
            String mediaPath, int width, int height, int commentCount,
            int likeCount) {
        this.id = id;
        this.authorObjectId = authorObjectId;
        this.authorAvatar = authorAvatar;
        this.text = text;
        this.date = date;
        this.coverPath = coverPath;
        this.mediaType = mediaType;
        this.mediaPath = mediaPath;
        this.width = width;
        this.height = height;
        this.commentCount = commentCount;
        this.likeCount = likeCount;
    }

    @Generated(hash = 551662551)
    public Media() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getMediaType() {
        return this.mediaType;
    }

    public void setMediaType(int mediaType) {
        this.mediaType = mediaType;
    }

    public String getMediaPath() {
        return this.mediaPath;
    }

    public void setMediaPath(String mediaPath) {
        this.mediaPath = mediaPath;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getCommentCount() {
        return this.commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public int getLikeCount() {
        return this.likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public String getAuthorObjectId() {
        return this.authorObjectId;
    }

    public void setAuthorObjectId(String authorObjectId) {
        this.authorObjectId = authorObjectId;
    }

    public String getAuthorAvatar() {
        return this.authorAvatar;
    }

    public void setAuthorAvatar(String authorAvatar) {
        this.authorAvatar = authorAvatar;
    }

    public String getCoverPath() {
        return this.coverPath;
    }

    public void setCoverPath(String coverPath) {
        this.coverPath = coverPath;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.authorObjectId);
        dest.writeString(this.authorAvatar);
        dest.writeString(this.text);
        dest.writeLong(this.date != null ? this.date.getTime() : -1);
        dest.writeString(this.coverPath);
        dest.writeInt(this.mediaType);
        dest.writeString(this.mediaPath);
        dest.writeInt(this.width);
        dest.writeInt(this.height);
        dest.writeInt(this.commentCount);
        dest.writeInt(this.likeCount);
    }

    protected Media(Parcel in) {
        this.id = (Long) in.readValue(Long.class.getClassLoader());
        this.authorObjectId = in.readString();
        this.authorAvatar = in.readString();
        this.text = in.readString();
        long tmpDate = in.readLong();
        this.date = tmpDate == -1 ? null : new Date(tmpDate);
        this.coverPath = in.readString();
        this.mediaType = in.readInt();
        this.mediaPath = in.readString();
        this.width = in.readInt();
        this.height = in.readInt();
        this.commentCount = in.readInt();
        this.likeCount = in.readInt();
    }

    public static final Parcelable.Creator<Media> CREATOR = new Parcelable.Creator<Media>() {
        @Override
        public Media createFromParcel(Parcel source) {
            return new Media(source);
        }

        @Override
        public Media[] newArray(int size) {
            return new Media[size];
        }
    };
}
