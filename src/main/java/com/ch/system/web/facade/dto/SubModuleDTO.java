package com.ch.system.web.facade.dto;

/**
 * User: Jack Wang
 * Date: 15-3-19
 * Time: 下午4:03
 */
public class SubModuleDTO {

    private int id = -1;

    private int sequence = -1;

    private String moduleTitle;

    private String moduleUrl;

    private String moduleDescription;

    private int moduleId;

    public SubModuleDTO(int moduleId) {
        this.moduleId = moduleId;
    }

    public SubModuleDTO(int id, int sequence, String moduleTitle, String moduleUrl, String moduleDescription, int moduleId) {
        this.id = id;
        this.sequence = sequence;
        this.moduleTitle = moduleTitle;
        this.moduleUrl = moduleUrl;
        this.moduleDescription = moduleDescription;
        this.moduleId = moduleId;
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

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }
}
