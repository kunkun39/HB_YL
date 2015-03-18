package com.ch.system.service;

import com.ch.common.exception.CHDocumentOperationException;
import com.ch.system.domain.AdvertisementFile;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * User: Jack Wang
 * Date: 15-3-17
 * Time: 下午3:50
 */
@Service("fileManageService")
public class FileManageServiceImpl implements FileManageService, InitializingBean {

    private static final Log logger = LogFactory.getLog(FileManageServiceImpl.class);

    //文件存储的基本路径
    @Value("${project.upload.file.path}")
    private String baseStorePath;

    public void afterPropertiesSet() throws Exception {
        Assert.hasText(baseStorePath, "the basic store path not configure");
    }

    public void uploadAdvertisementFile(AdvertisementFile file) {
        if (file != null) {
            //create save file path
            File directory = new File(baseStorePath);
            if (!directory.exists()) {
                directory.mkdir();
            }

            //save the file
            File saveFile = new File(directory, file.getActualFileName());
            try {
                OutputStream dataOut = new FileOutputStream(saveFile);
                FileCopyUtils.copy(file.getFile().getInputStream(), dataOut);
            } catch (Exception e) {
                logger.error(e);
                throw new CHDocumentOperationException("exception update file", e);
            }
        }
    }

    public void deleteAdvertisementFile(AdvertisementFile file) {
        File deleteFile = new File(baseStorePath + File.separatorChar + file.getActualFileName());
        if (deleteFile.exists()) {
            deleteFile.delete();
        }
    }
}
