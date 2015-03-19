package com.ch.system.domain;

import com.ch.common.domain.EntityBase;

/**
 * User: Jack Wang
 * Date: 15-3-18
 * Time: 下午4:25
 */
public class ModuleAdvertisement extends EntityBase {

    private int sequence;

    private String moduleTitle;

    private String moduleUrl;

    protected ModuleAdvertisement() {
    }

    public ModuleAdvertisement(int sequence, String moduleTitle, String moduleUrl) {
        this.sequence = sequence;
        this.moduleTitle = moduleTitle;
        this.moduleUrl = moduleUrl;
    }

    /*************************************************GETTER**********************************************************/

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
}
