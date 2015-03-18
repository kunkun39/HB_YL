package com.ch.system.service;

import com.ch.system.domain.AdvertisementFile;
import com.ch.system.domain.OpenAdvertisement;
import com.ch.system.repository.AdvertisementDao;
import com.ch.system.web.facade.assember.OpenAdvertisementWebAssember;
import com.ch.system.web.facade.dto.OpenAdvertisementDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * User: Jack Wang
 * Date: 15-3-17
 * Time: 下午1:59
 */
@Service("advertisementService")
public class AdvertisementServiceImpl implements AdvertisementService {

    @Autowired
    private FileManageService fileManageService;

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
            int maxSequence = advertisementDao.getMaxOpenAdvertisementSequence();
            openAdvertisement.setSequence(maxSequence + 1);
        }

        MultipartFile file = dto.getAdvertisementFile();
        AdvertisementFile advertisementFile = null;
        if(file != null && file.getSize() > 0) {
            advertisementFile = OpenAdvertisementWebAssember.toAdvertisementFileDomain(file);
        }

        AdvertisementFile oldAdvertisementFile = openAdvertisement.changeAdvertisementFile(advertisementFile);
        if (oldAdvertisementFile != null) {
            fileManageService.deleteAdvertisementFile(oldAdvertisementFile);
        }
        fileManageService.uploadAdvertisementFile(openAdvertisement.getAdvertisementFile());

        advertisementDao.saveOrUpdate(openAdvertisement);
    }
}
