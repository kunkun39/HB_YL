package com.ch.system.service;

import com.ch.system.domain.AdvertisementFile;
import com.ch.system.domain.ModuleAdvertisement;
import com.ch.system.domain.OpenAdvertisement;
import com.ch.system.repository.AdvertisementDao;
import com.ch.system.web.facade.assember.ModuleAdvertisementWebAssember;
import com.ch.system.web.facade.assember.OpenAdvertisementWebAssember;
import com.ch.system.web.facade.dto.ModuleAdvertisementDTO;
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

    /*************************开机广告部分******************************/

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
        //获得开机广告
        OpenAdvertisement openAdvertisement = OpenAdvertisementWebAssember.toOpenAdvertisementDomain(dto);
        if (openAdvertisement.getId() <= 0) {
            int maxSequence = advertisementDao.getMaxOpenAdvertisementSequence();
            openAdvertisement.setSequence(maxSequence + 1);
        }

        //获得上传的文件
        MultipartFile file = dto.getAdvertisementFile();
        AdvertisementFile advertisementFile = null;
        if(file != null && file.getSize() > 0) {
            advertisementFile = OpenAdvertisementWebAssember.toAdvertisementFileDomain(file);
        }

        //获得老的上传的文件，如果存在就删除
        AdvertisementFile oldAdvertisementFile = openAdvertisement.changeAdvertisementFile(advertisementFile);
        if (oldAdvertisementFile != null) {
            fileManageService.deleteAdvertisementFile(oldAdvertisementFile);
        }
        //如果新的文件存在，则从新上传
        if(file != null && file.getSize() > 0) {
            fileManageService.uploadAdvertisementFile(openAdvertisement.getAdvertisementFile());
        }

        advertisementDao.saveOrUpdate(openAdvertisement);
    }

    public void deleteOpenAdvertisement(int openAdvertisementId) {
        OpenAdvertisement openAdvertisement = (OpenAdvertisement) advertisementDao.findById(openAdvertisementId, OpenAdvertisement.class);
        AdvertisementFile file = openAdvertisement.getAdvertisementFile();

        fileManageService.deleteAdvertisementFile(file);
        advertisementDao.delete(openAdvertisement);
    }

    /*************************八大模块部分******************************/

    public List<ModuleAdvertisementDTO> obtainModuleAdvertisements() {
        List<ModuleAdvertisement> advertisements = advertisementDao.loadModuleAdvertisements();
        return ModuleAdvertisementWebAssember.toModuleAdvertisementDTOList(advertisements);
    }

    public ModuleAdvertisementDTO obtainModuleAdvertisementById(int moduleAdvertisementId) {
        ModuleAdvertisement moduleAdvertisement = (ModuleAdvertisement) advertisementDao.findById(moduleAdvertisementId, ModuleAdvertisement.class);
        return ModuleAdvertisementWebAssember.toModuleAdvertisementDTO(moduleAdvertisement);
    }

    public void changeModuleAdvertisementDetails(ModuleAdvertisementDTO dto) {

    }
}
