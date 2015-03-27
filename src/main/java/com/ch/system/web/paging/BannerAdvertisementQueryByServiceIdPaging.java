package com.ch.system.web.paging;

import com.ch.system.service.AdvertisementService;
import com.ch.system.web.facade.dto.BannerAdvertisementDTO;

import java.util.List;

/**
 * Created by maren on 2015/3/23.
 */
public class BannerAdvertisementQueryByServiceIdPaging extends AbstractPaging<BannerAdvertisementDTO> {
    private AdvertisementService advertisementService;
    private String serviceId;

    public BannerAdvertisementQueryByServiceIdPaging(AdvertisementService advertisementService,String serviceId) {
        this.advertisementService = advertisementService;
        this.serviceId=serviceId;

    }

    public List<BannerAdvertisementDTO> getItems() {
        if(serviceId.trim().equals("")){
            return  advertisementService.obtainBannerAdvertisements(getStartPosition(),getPageSize());

        }
        return advertisementService.obtainBannerAdvertisementsByServiceId(serviceId, getStartPosition(), getPageSize());
    }

    public long getTotalItemSize() {
        if (totalItemSize >= 0) {
            return totalItemSize;
        }
        if(serviceId.trim().equals("")){
            totalItemSize=advertisementService.obtainBannerAdvertisementSize();
            return totalItemSize;
        }
        totalItemSize = advertisementService.obtainBannerAdvertisementSizeByServiceId(serviceId);
        return totalItemSize;
    }

    public String getParameterValues() {
        return "";
    }
}
