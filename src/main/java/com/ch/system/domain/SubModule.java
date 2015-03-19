package com.ch.system.domain;

import com.ch.common.domain.EntityBase;

/**
 * User: Jack Wang
 * Date: 15-3-19
 * Time: 下午3:53
 */
public class SubModule extends EntityBase {

    private int sequence;

    private String moduleTitle;

    private String moduleUrl;

    private String moduleDescription;

    private ModuleAdvertisement moduleAdvertisement;

    public SubModule() {
    }

    public SubModule(int sequence, String moduleTitle, String moduleUrl, String moduleDescription) {
        this.sequence = sequence;
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

    public ModuleAdvertisement getModuleAdvertisement() {
        return moduleAdvertisement;
    }

    public void setModuleAdvertisement(ModuleAdvertisement moduleAdvertisement) {
        this.moduleAdvertisement = moduleAdvertisement;
    }
}
