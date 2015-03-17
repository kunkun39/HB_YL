package com.ch.system.service;

import com.ch.system.domain.OpenAdvertisement;
import com.ch.system.repository.AdvertisementDao;
import com.ch.system.web.facade.assember.OpenAdvertisementWebAssember;
import com.ch.system.web.facade.dto.OpenAdvertisementDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: Jack Wang
 * Date: 15-3-17
 * Time: 下午1:59
 */
@Service("advertisementService")
public class AdvertisementServiceImpl implements AdvertisementService {

    @Autowired
    private AdvertisementDao advertisementDao;

    public List<OpenAdvertisementDTO> obtainOpenAdvertisements(int startPosition, int pageSize) {
        List<OpenAdvertisement> ads = advertisementDao.loadOpenAdvertisements(startPosition, pageSize);
        return OpenAdvertisementWebAssember.toOpenAdvertisementDTOList(ads);
    }

    public int obtainOpenAdvertisementSize() {
        return advertisementDao.loadOpenAdvertisementSize();
    }

    public OpenAdvertisementDTO obtainOpenAdvertisementById(int openAdvertisementId) {
        OpenAdvertisement openAdvertisement = (OpenAdvertisement) advertisementDao.findById(openAdvertisementId, OpenAdvertisement.class);
        return OpenAdvertisementWebAssember.toOpenAdvertisementDTO(openAdvertisement);
    }

    /**
     * synchronized aim is set id is unique in the system
     */
    public synchronized void changeOpenAdvertisementDetails(OpenAdvertisementDTO dto) {
        OpenAdvertisement openAdvertisement = OpenAdvertisementWebAssember.toOpenAdvertisementDomain(dto);
        if (openAdvertisement.getId() <= 0) {
            int maxIndex = advertisementDao.getMaxOpenAdvertisement();
            openAdvertisement.setIndex(maxIndex + 1);

        }
        advertisementDao.saveOrUpdate(openAdvertisement);
    }
}
