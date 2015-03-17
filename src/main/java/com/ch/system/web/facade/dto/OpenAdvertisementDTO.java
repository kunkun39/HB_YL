package com.ch.system.web.facade.dto;

import java.io.Serializable;

/**
 * User: Jack Wang
 * Date: 15-3-17
 * Time: 下午1:48
 */
public class OpenAdvertisementDTO implements Serializable {
    private int id = -1;
    private int index = -1;
    private String title;
    private String url;

    public OpenAdvertisementDTO() {
    }

    public OpenAdvertisementDTO(int id, int index, String title, String url) {
        this.id = id;
        this.index = index;
        this.title = title;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
