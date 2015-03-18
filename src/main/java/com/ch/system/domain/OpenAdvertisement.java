package com.ch.system.domain;

import com.ch.common.domain.EntityBase;

/**
 * User: Jack Wang
 * Date: 15-3-17
 *
 * 开机广告
 */
public class OpenAdvertisement extends EntityBase {

    private int sequence;

    private String advertisememtTitle;

    private AdvertisementFile advertisementFile;

    protected OpenAdvertisement() {
    }

    public OpenAdvertisement(int sequence, String advertisememtTitle) {
        this.sequence = sequence;
        this.advertisememtTitle = advertisememtTitle;
    }

    public AdvertisementFile changeAdvertisementFile(AdvertisementFile newAdvertisementFile) {
        AdvertisementFile oldAdvertisementFile = null;

        if (advertisementFile != null) {
            oldAdvertisementFile = new AdvertisementFile();
            oldAdvertisementFile.setUploadTime(advertisementFile.getUploadTime());
            oldAdvertisementFile.setUploadFileName(advertisementFile.getUploadFileName());
            oldAdvertisementFile.setActualFileName(advertisementFile.getActualFileName());

            advertisementFile.setUploadFileName(newAdvertisementFile.getUploadFileName());
            advertisementFile.setActualFileName(newAdvertisementFile.getActualFileName());
            advertisementFile.setUploadTime(newAdvertisementFile.getUploadTime());
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
