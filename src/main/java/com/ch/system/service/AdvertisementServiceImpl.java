package com.ch.system.service;


import com.ch.system.domain.*;

import com.ch.client.service.ClientCacheService;
import com.ch.system.domain.AdvertisementFile;
import com.ch.system.domain.ModuleAdvertisement;
import com.ch.system.domain.OpenAdvertisement;
import com.ch.system.domain.ChannelAdvertisement;
import com.ch.system.domain.SubModule;

import com.ch.system.repository.AdvertisementDao;
import com.ch.system.web.facade.assember.BannerAdvertisementWebAssember;
import com.ch.system.web.facade.assember.ModuleAdvertisementWebAssember;
import com.ch.system.web.facade.assember.OpenAdvertisementWebAssember;
import com.ch.system.web.facade.assember.ChannelAdvertisementWebAssember;
import com.ch.system.web.facade.assember.SubModuleWebAssember;
import com.ch.system.web.facade.dto.BannerAdvertisementDTO;
import com.ch.system.web.facade.dto.ModuleAdvertisementDTO;
import com.ch.system.web.facade.dto.OpenAdvertisementDTO;
import com.ch.system.web.facade.dto.ChannelAdvertisementDTO;
import com.ch.system.web.facade.dto.SubModuleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    private ClientCacheService clientCacheService;

    @Autowired
    private FileManageService fileManageService;

    @Autowired
    private AdvertisementDao advertisementDao;


    /*************************Banner广告部分******************************/

    public void insertBannerAdvertisement(BannerAdvertisement bannerAdvertisement) {
        advertisementDao.saveOrUpdate(bannerAdvertisement);

    }

    public int obtainBannerAdvertisementSizeByServiceId(int serviceId) {
        return advertisementDao.loadBannerAdvertisementSizeByServiceId(serviceId);

    }

    public List<BannerAdvertisementDTO> obtainBannerAdvertisementsByServiceId(int serviceId, int startPosition, int pageSize) {
        List<BannerAdvertisement> ads=advertisementDao.obtainBannerAdvertisementsByServiceId(serviceId, startPosition, pageSize);
        return BannerAdvertisementWebAssember.toBannerAdvertisementDTOList(ads);
    }

    public List<BannerAdvertisementDTO> obtainBannerAdvertisements(int startPosition, int pageSize) {
        List<BannerAdvertisement> ads = advertisementDao.loadBannerAdvertisements(startPosition, pageSize);
        return BannerAdvertisementWebAssember.toBannerAdvertisementDTOList(ads);
    }

    public int obtainBannerAdvertisementSize() {
        return advertisementDao.loadBannerAdvertisementSize();
    }

    public BannerAdvertisementDTO obtainBannerAdvertisementById(int bannerAdvertisementId) {
        BannerAdvertisement bannerAdvertisement = (BannerAdvertisement) advertisementDao.findById(bannerAdvertisementId, BannerAdvertisement.class);
        return BannerAdvertisementWebAssember.toBannerAdvertisementDTO(bannerAdvertisement);
    }

    public void changeBannerAdvertisementDetails(BannerAdvertisementDTO dto) {
        //获得开机广告
        BannerAdvertisement bannerAdvertisement = BannerAdvertisementWebAssember.toBannerAdvertisementDomain(dto);
        if (bannerAdvertisement.getId() <= 0) {
            int maxSequence = advertisementDao.getMaxBannerAdvertisementSequence();
            bannerAdvertisement.setSequence(maxSequence + 1);
        }

        //获得上传的文件
        MultipartFile file = dto.getAdvertisementFile();
        AdvertisementFile advertisementFile = null;
        if(file != null && file.getSize() > 0) {
            advertisementFile = BannerAdvertisementWebAssember.toAdvertisementFileDomain(file);
        }

        //获得老的上传的文件，如果存在就删除
        AdvertisementFile oldAdvertisementFile = bannerAdvertisement.changeAdvertisementFile(advertisementFile);
        if (oldAdvertisementFile != null) {
            fileManageService.deleteAdvertisementFile(oldAdvertisementFile);
        }
        //如果新的文件存在，则从新上传
        if(file != null && file.getSize() > 0) {
            fileManageService.uploadAdvertisementFile(bannerAdvertisement.getAdvertisementFile());
        }

        advertisementDao.saveOrUpdate(bannerAdvertisement);

        clientCacheService.cleanCacheBannerAdvertisement();
    }

    public void deleteBannerAdvertisement(int bannerAdvertisementId) {
        BannerAdvertisement bannerAdvertisement = (BannerAdvertisement) advertisementDao.findById(bannerAdvertisementId, BannerAdvertisement.class);
        AdvertisementFile file = bannerAdvertisement.getAdvertisementFile();

        fileManageService.deleteAdvertisementFile(file);
        advertisementDao.deleteAndjustAfterBannerAdvertisementSequence(bannerAdvertisement.getSequence(), bannerAdvertisementId);
        clientCacheService.cleanCacheBannerAdvertisement();
    }

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

        //更改后清除缓存
        clientCacheService.cleanCachedOpenAdvertisement();
    }

    public void deleteOpenAdvertisement(int openAdvertisementId) {
        OpenAdvertisement openAdvertisement = (OpenAdvertisement) advertisementDao.findById(openAdvertisementId, OpenAdvertisement.class);
        AdvertisementFile file = openAdvertisement.getAdvertisementFile();

        fileManageService.deleteAdvertisementFile(file);
        advertisementDao.deleteAndjustAfterOpenAdvertisementSequence(openAdvertisement.getSequence(), openAdvertisementId);

        //更改后清除缓存
        clientCacheService.cleanCachedOpenAdvertisement();
    }

    /*************************频道列表广告部分******************************/

    public List<ChannelAdvertisementDTO> obtainChannelAdvertisements(int startPosition, int pageSize) {
        List<ChannelAdvertisement> ads = advertisementDao.loadChannelAdvertisements(startPosition, pageSize);
        return ChannelAdvertisementWebAssember.toChannelAdvertisementDTOList(ads);
    }

    public int obtainChannelAdvertisementSize() {
        return advertisementDao.loadChannelAdvertisementSize();
    }

    public ChannelAdvertisementDTO obtainChannelAdvertisementById(int channelAdvertisementId) {
        ChannelAdvertisement channelAdvertisement = (ChannelAdvertisement) advertisementDao.findById(channelAdvertisementId, ChannelAdvertisement.class);
        return ChannelAdvertisementWebAssember.toChannelAdvertisementDTO(channelAdvertisement);
    }

    /**
     * synchronized aim is set id is unique in the system
     */
    public synchronized void changeChannelAdvertisementDetails(ChannelAdvertisementDTO dto) {
        //获得频道列表广告
        ChannelAdvertisement channelAdvertisement = ChannelAdvertisementWebAssember.toChannelAdvertisementDomain(dto);
        if (channelAdvertisement.getId() <= 0) {
            int maxSequence = advertisementDao.getMaxChannelAdvertisementSequence();
            channelAdvertisement.setSequence(maxSequence + 1);
        }

        //获得上传的文件
        MultipartFile file = dto.getAdvertisementFile();
        AdvertisementFile advertisementFile = null;
        if(file != null && file.getSize() > 0) {
            advertisementFile = ChannelAdvertisementWebAssember.toAdvertisementFileDomain(file);
        }

        //获得老的上传的文件，如果存在就删除
        AdvertisementFile oldAdvertisementFile = channelAdvertisement.changeAdvertisementFile(advertisementFile);
        if (oldAdvertisementFile != null) {
            fileManageService.deleteAdvertisementFile(oldAdvertisementFile);
        }
        //如果新的文件存在，则从新上传
        if(file != null && file.getSize() > 0) {
            fileManageService.uploadAdvertisementFile(channelAdvertisement.getAdvertisementFile());
        }

        advertisementDao.saveOrUpdate(channelAdvertisement);
    }

    public void deleteChannelAdvertisement(int channelAdvertisementId) {
        ChannelAdvertisement channelAdvertisement = (ChannelAdvertisement) advertisementDao.findById(channelAdvertisementId, ChannelAdvertisement.class);

        AdvertisementFile file = channelAdvertisement.getAdvertisementFile();

        fileManageService.deleteAdvertisementFile(file);
        advertisementDao.deleteAndjustAfterChannelAdvertisementSequence(channelAdvertisement.getSequence(), channelAdvertisementId);
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
        ModuleAdvertisement moduleAdvertisement = ModuleAdvertisementWebAssember.toModuleAdvertisementDomain(dto);
        advertisementDao.saveOrUpdate(moduleAdvertisement);

        //更改后清除缓存
        clientCacheService.cleanCachedModuleAdvertisement();
    }

    public List<SubModuleDTO> obtainSubModules(int moduleAdvertisementId, int startPosition, int pageSize) {
        List<SubModule> subModules = advertisementDao.loadSubModules(moduleAdvertisementId, startPosition, pageSize);
        return SubModuleWebAssember.toModuleAdvertisementDTOList(subModules);
    }

    public int obtainSubModuleSize(int moduleAdvertisementId) {
        return advertisementDao.loadSubModuleSize(moduleAdvertisementId);
    }

    public SubModuleDTO obtainSubModuleById(int subModuleId) {
        SubModule subModule = (SubModule) advertisementDao.findById(subModuleId, SubModule.class);
        return SubModuleWebAssember.toSubModuleDTO(subModule);
    }

    public void changeSubModuleDetails(SubModuleDTO dto) {
        SubModule subModule = SubModuleWebAssember.toSubModuleDomain(dto);
        if (subModule.getId() <= 0) {
            int maxSequence = advertisementDao.getMaxSubModuleSequence(dto.getModuleId());
            subModule.setSequence(maxSequence + 1);
        }
        advertisementDao.saveOrUpdate(subModule);

        //更改后清除缓存
        clientCacheService.cleanCachedSubModule(dto.getModuleId());
    }

    public void deleteSubModule(int subModuleId, int moduleAdvertisementId) {
        SubModule subModule = (SubModule) advertisementDao.findById(subModuleId, SubModule.class);

        advertisementDao.deleteAndjustAfterSubModuleSequence(subModule.getId(), subModule.getSequence(), moduleAdvertisementId);

        //更改后清除缓存
        clientCacheService.cleanCachedSubModule(moduleAdvertisementId);
    }
}
