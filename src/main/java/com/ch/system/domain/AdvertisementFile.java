package com.ch.system.domain;

import com.ch.common.domain.EntityBase;
import com.ch.common.utils.CHStringUtils;
import com.ch.common.utils.JodaUtils;
import org.joda.time.DateTime;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * User: Jack Wang
 * Date: 15-3-17
 * Time: 下午3:14
 */
public class AdvertisementFile extends EntityBase {

    private final static int FAKE_FILENAME_LENGTH = 12;

    private MultipartFile file;
    //上传到服务器的文件名
    private String uploadFileName;
    //存放到服务器的文件名
    private String actualFileName;

    //上传时间
    private DateTime uploadTime;

    public AdvertisementFile() {
    }

    public AdvertisementFile(MultipartFile file) {
        this.uploadFileName = file != null ? file.getOriginalFilename() : "";
        this.uploadTime = JodaUtils.currentTime();
        this.file = file;

        int lastDot = uploadFileName.lastIndexOf(".");
        String fileNameSuffix = uploadFileName.substring(lastDot);
        this.actualFileName = CHStringUtils.getRandomString(FAKE_FILENAME_LENGTH) + fileNameSuffix;
    }

    /***********************************************GET/SET******************************************************/

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public String getActualFileName() {
        return actualFileName;
    }

    public void setActualFileName(String actualFileName) {
        this.actualFileName = actualFileName;
    }

    public DateTime getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(DateTime uploadTime) {
        this.uploadTime = uploadTime;
    }
}
