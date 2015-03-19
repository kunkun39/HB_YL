package com.ch.system.web.facade.dto;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 * User: Jack Wang
 * Date: 15-3-18
 * Time: 下午4:50
 */
public class ModuleAdvertisementDTO implements Serializable {

    private int id = -1;

    private int sequence = -1;

    private boolean includeSub;

    private String moduleTitle;

    private String moduleUrl;

    private String moduleDescription;

    public ModuleAdvertisementDTO() {
    }

    public ModuleAdvertisementDTO(int id, int sequence, boolean includeSub, String moduleTitle, String moduleUrl, String moduleDescription) {
        this.id = id;
        this.sequence = sequence;
        this.includeSub = includeSub;
        this.moduleTitle = moduleTitle;
        this.moduleUrl = moduleUrl;
        this.moduleDescription = moduleDescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public boolean isIncludeSub() {
        return includeSub;
    }

    public void setIncludeSub(boolean includeSub) {
        this.includeSub = includeSub;
    }

    public String getModuleTitle() {
        return moduleTitle;
    }

    public void setModuleTitle(String moduleTitle) {
        this.moduleTitle = moduleTitle;
    }

    public String getModuleUrl() {
        return moduleUrl;
    }

    public void setModuleUrl(String moduleUrl) {
        this.moduleUrl = moduleUrl;
    }

    public String getModuleDescription() {
        return moduleDescription;
    }

    public void setModuleDescription(String moduleDescription) {
        this.moduleDescription = moduleDescription;
    }
}

