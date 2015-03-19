package com.ch.system.domain;

import com.ch.common.domain.EntityBase;

/**
 * User: Jack Wang
 * Date: 15-3-18
 * Time: 下午4:25
 */
public class ModuleAdvertisement extends EntityBase {

    private int sequence;

    private boolean includeSub;

    private String moduleTitle;

    private String moduleUrl;

    private String moduleDescription;

    protected ModuleAdvertisement() {
    }

    public ModuleAdvertisement(int sequence, boolean includeSub, String moduleTitle, String moduleUrl, String moduleDescription) {
        this.sequence = sequence;
        this.includeSub = includeSub;
        this.moduleTitle = moduleTitle;
        this.moduleUrl = moduleUrl;
        this.moduleDescription = moduleDescription;
    }

    /*************************************************GETTER**********************************************************/

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
