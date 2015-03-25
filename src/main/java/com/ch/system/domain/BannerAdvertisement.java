package com.ch.system.domain;

import com.ch.common.domain.EntityBase;

/**
 * Created by maren on 2015/3/20.
 */
public class BannerAdvertisement extends EntityBase{

    private int sequence;

    private String advertisememtTitle;

    private AdvertisementFile advertisementFile;
    private int serviceId;

    public BannerAdvertisement() {
    }

    public BannerAdvertisement(int sequence, String advertisememtTitle,int serviceId) {
        this.sequence = sequence;
        this.advertisememtTitle = advertisememtTitle;
        this.serviceId=serviceId;

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
    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }
}
