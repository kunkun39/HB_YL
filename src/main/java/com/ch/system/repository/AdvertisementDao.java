package com.ch.system.repository;

import com.ch.common.repository.EntityObjectDao;
import com.ch.system.domain.ChannelAdvertisement;
import com.ch.system.domain.BannerAdvertisement;
import com.ch.system.domain.ModuleAdvertisement;
import com.ch.system.domain.OpenAdvertisement;
import com.ch.system.domain.SubModule;

import java.util.List;

/**
 * User: Jack Wang
 * Date: 15-3-17
 * Time: 下午1:18
 */
public interface AdvertisementDao extends EntityObjectDao {

    /*************************Banner广告部分******************************/

    List<BannerAdvertisement> loadBannerAdvertisements(int startPosition, int pageSize);
    List<BannerAdvertisement> obtainBannerAdvertisementsByServiceId(int serviceId, int startPosition, int pageSize);

    int loadBannerAdvertisementSize();

    int loadBannerAdvertisementSizeByServiceId(int serviceId);

    int getMaxBannerAdvertisementSequence();

    void deleteAndjustAfterBannerAdvertisementSequence(int sequence,int bannerAdvertisementId, int uploadFileId);

    /*************************开机广告部分******************************/

    List<OpenAdvertisement> loadOpenAdvertisements(int startPosition, int pageSize);

    int loadOpenAdvertisementSize();

    int getMaxOpenAdvertisementSequence();

    void deleteAndjustAfterOpenAdvertisementSequence(int position, int openAdvertisementId, int uploadFileId);

    /*************************频道列表广告部分******************************/

    List<ChannelAdvertisement> loadChannelAdvertisements(int startPosition, int pageSize);

    int loadChannelAdvertisementSize();

    int getMaxChannelAdvertisementSequence();

    void deleteAndjustAfterChannelAdvertisementSequence(int position, int channelAdvertisementId, int uploadFileId);

    /*************************八大模块部分******************************/

    List<ModuleAdvertisement> loadModuleAdvertisements();

    List<SubModule> loadSubModules(int moduleAdvertisementId, int startPosition, int pageSize);

    int loadSubModuleSize(int moduleAdvertisementId);

    int getMaxSubModuleSequence(int moduleAdvertisementId);

    void deleteAndjustAfterSubModuleSequence(int subModuleId, int position, int moduleAdvertisementId);

}
