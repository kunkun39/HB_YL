package com.ch.system.web.paging;

import com.ch.system.service.AdvertisementService;
import com.ch.system.web.facade.dto.BannerAdvertisementDTO;

import java.util.List;

/**
 * Created by maren on 2015/3/23.
 */
public class BannerAdvertisementQueryByServiceIdPaging extends AbstractPaging<BannerAdvertisementDTO> {
    private AdvertisementService advertisementService;
    private int serviceId;

    public BannerAdvertisementQueryByServiceIdPaging(AdvertisementService advertisementService,int serviceId) {
        this.advertisementService = advertisementService;
        this.serviceId=serviceId;

    }

    public List<BannerAdvertisementDTO> getItems() {
        if(serviceId==0){
            return  advertisementService.obtainBannerAdvertisements(getStartPosition(),getPageSize());

        }
        return advertisementService.obtainBannerAdvertisementsByServiceId(serviceId, getStartPosition(), getPageSize());
    }

    public long getTotalItemSize() {
        if (totalItemSize >= 0) {
            return totalItemSize;
        }
        if(serviceId==0){
            totalItemSize=advertisementService.obtainBannerAdvertisementSize();
        }
        totalItemSize = advertisementService.obtainBannerAdvertisementSizeByServiceId(serviceId);
        return totalItemSize;
    }

    public String getParameterValues() {
        return "";
    }
}
