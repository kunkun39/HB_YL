package com.ch.system.web.facade.dto;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 * User: Jack Wang
 * Date: 15-3-17
 * Time: 下午1:48
 */
public class OpenAdvertisementDTO implements Serializable {

    private int id = -1;

    private int sequence = -1;

    private String advertisementTitle;

    private int advertisementFileId;

    private String advertisementUploadFileName;

    private String advertisementActualFileName;

    private MultipartFile advertisementFile;

    public OpenAdvertisementDTO() {
    }

    public OpenAdvertisementDTO(int id, int sequence, String advertisementTitle,
                                int advertisementFileId, String advertisementUploadFileName, String advertisementActualFileName) {
        this.id = id;
        this.sequence = sequence;
        this.advertisementTitle = advertisementTitle;
        this.advertisementFileId = advertisementFileId;
        this.advertisementUploadFileName = advertisementUploadFileName;
        this.advertisementActualFileName = advertisementActualFileName;
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

    public String getAdvertisementTitle() {
        return advertisementTitle;
    }

    public void setAdvertisementTitle(String advertisementTitle) {
        this.advertisementTitle = advertisementTitle;
    }

    public int getAdvertisementFileId() {
        return advertisementFileId;
    }

    public void setAdvertisementFileId(int advertisementFileId) {
        this.advertisementFileId = advertisementFileId;
    }

    public String getAdvertisementUploadFileName() {
        return advertisementUploadFileName;
    }

    public void setAdvertisementUploadFileName(String advertisementUploadFileName) {
        this.advertisementUploadFileName = advertisementUploadFileName;
    }

    public String getAdvertisementActualFileName() {
        return advertisementActualFileName;
    }

    public void setAdvertisementActualFileName(String advertisementActualFileName) {
        this.advertisementActualFileName = advertisementActualFileName;
    }

    public MultipartFile getAdvertisementFile() {
        return advertisementFile;
    }

    public void setAdvertisementFile(MultipartFile advertisementFile) {
        this.advertisementFile = advertisementFile;
    }
}
