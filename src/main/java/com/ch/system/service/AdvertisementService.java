package com.ch.system.service;

import com.ch.system.web.facade.dto.OpenAdvertisementDTO;

import java.util.List;

/**
 * User: Jack Wang
 * Date: 15-3-17
 * Time: 下午1:45
 */
public interface AdvertisementService {

    /*************************开机广告部分******************************/

    List<OpenAdvertisementDTO> obtainOpenAdvertisements(int startPosition, int pageSize);

    int obtainOpenAdvertisementSize();

    OpenAdvertisementDTO obtainOpenAdvertisementById(int openAdvertisementId);

    void changeOpenAdvertisementDetails(OpenAdvertisementDTO dto);

    void deleteOpenAdvertisement(int openAdvertisementId);
}
