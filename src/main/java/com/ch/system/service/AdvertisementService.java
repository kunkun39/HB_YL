package com.ch.system.service;

import com.ch.system.web.facade.dto.ChannelAdvertisementDTO;
import com.ch.system.domain.BannerAdvertisement;
import com.ch.system.web.facade.dto.BannerAdvertisementDTO;
import com.ch.system.web.facade.dto.ModuleAdvertisementDTO;
import com.ch.system.web.facade.dto.OpenAdvertisementDTO;
import com.ch.system.web.facade.dto.SubModuleDTO;

import java.util.List;

/**
 * User: Jack Wang
 * Date: 15-3-17
 * Time: 下午1:45
 */
public interface AdvertisementService {

    /*************************Banner广告部分******************************/

    void insertBannerAdvertisement(BannerAdvertisement bannerAdvertisement);

    int obtainBannerAdvertisementSizeByServiceId(String serviceId);

    List<BannerAdvertisementDTO> obtainBannerAdvertisementsByServiceId(String serviceId, int startPosition, int pageSize);

    List<BannerAdvertisementDTO> obtainBannerAdvertisements(int startPosition, int pageSize);

    int obtainBannerAdvertisementSize();

    BannerAdvertisementDTO obtainBannerAdvertisementById(int bannerAdvertisementId);

    void changeBannerAdvertisementDetails(BannerAdvertisementDTO dto);

    void deleteBannerAdvertisement(int bannerAdvertisementId);

    /*************************开机广告部分******************************/

    List<OpenAdvertisementDTO> obtainOpenAdvertisements(int startPosition, int pageSize);

    int obtainOpenAdvertisementSize();

    OpenAdvertisementDTO obtainOpenAdvertisementById(int openAdvertisementId);

    void changeOpenAdvertisementDetails(OpenAdvertisementDTO dto);

    void deleteOpenAdvertisement(int openAdvertisementId);

    /*************************频道列表广告部分******************************/

    List<ChannelAdvertisementDTO> obtainChannelAdvertisements(int startPosition, int pageSize);

    int obtainChannelAdvertisementSize();

    ChannelAdvertisementDTO obtainChannelAdvertisementById(int channelAdvertisementId);

    void changeChannelAdvertisementDetails(ChannelAdvertisementDTO dto);

    void deleteChannelAdvertisement(int channelAdvertisementId);


    /*************************八大模块部分******************************/

    List<ModuleAdvertisementDTO> obtainModuleAdvertisements();

    ModuleAdvertisementDTO obtainModuleAdvertisementById(int moduleAdvertisementId);

    void changeModuleAdvertisementDetails(ModuleAdvertisementDTO dto);

    List<SubModuleDTO> obtainSubModules(int moduleAdvertisementId, int startPosition, int pageSize);

    int obtainSubModuleSize(int moduleAdvertisementId);

    SubModuleDTO obtainSubModuleById(int subModuleId);

    void changeSubModuleDetails(SubModuleDTO dto);

    void deleteSubModule(int subModuleId, int moduleAdvertisementId);
}
