package com.ch.system.service;

import com.ch.system.domain.AdvertisementFile;

/**
 * User: Jack Wang
 * Date: 15-3-17
 * Time: 下午3:49
 */
public interface FileManageService {

    void uploadAdvertisementFile(AdvertisementFile file);

    void deleteAdvertisementFile(AdvertisementFile file);
}
