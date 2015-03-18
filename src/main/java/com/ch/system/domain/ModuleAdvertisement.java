package com.ch.system.domain;

import com.ch.common.domain.EntityBase;

/**
 * User: Jack Wang
 * Date: 15-3-18
 * Time: 下午4:25
 */
public class ModuleAdvertisement extends EntityBase {

    private int sequence;

    private String advertisememtTitle;

    private AdvertisementFile advertisementFile;

    protected ModuleAdvertisement() {
    }

    public ModuleAdvertisement(int sequence, String advertisememtTitle) {
        this.sequence = sequence;
        this.advertisememtTitle = advertisememtTitle;
    }

    public AdvertisementFile changeAdvertisementFile(AdvertisementFile newAdvertisementFile) {
        AdvertisementFile oldAdvertisementFile = null;

        if (advertisementFile != null) {
            if (newAdvertisementFile != null) {
                oldAdvertisementFile = new AdvertisementFile();
                oldAdvertisementFile.setUploadTime(advertisementFile.getUploadTime());
                oldAdvertisementFile.setUploadFileName(advertisementFile.getUploadFileName());
                oldAdvertisementFile.setActualFileName(advertisementFile.getActualFileName());

                advertisementFile.setUploadFileName(newAdvertisementFile.getUploadFileName());
                advertisementFile.setActualFileName(newAdvertisementFile.getActualFileName());
                advertisementFile.setUploadTime(newAdvertisementFile.getUploadTime());
                advertisementFile.setFile(newAdvertisementFile.getFile());
            }
        } else {
            this.advertisementFile = newAdvertisementFile;
        }

        return oldAdvertisementFile;
    }

    /*************************************************GETTER**********************************************************/

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getAdvertisememtTitle() {
        return advertisememtTitle;
    }

    public void setAdvertisememtTitle(String advertisememtTitle) {
        this.advertisememtTitle = advertisememtTitle;
    }

    public AdvertisementFile getAdvertisementFile() {
        return advertisementFile;
    }

    public void setAdvertisementFile(AdvertisementFile advertisementFile) {
        this.advertisementFile = advertisementFile;
    }
}
