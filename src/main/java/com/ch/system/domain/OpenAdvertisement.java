package com.ch.system.domain;

import com.ch.common.domain.EntityBase;

/**
 * User: Jack Wang
 * Date: 15-3-17
 *
 * 开机广告
 */
public class OpenAdvertisement extends EntityBase {

    private int index;

    private String title;

    private String url;

    public OpenAdvertisement(int index, String title, String url) {
        setId(-1);
        this.index = index;
        this.title = title;
        this.url = url;
    }

    /*************************************************GETTER**********************************************************/

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
