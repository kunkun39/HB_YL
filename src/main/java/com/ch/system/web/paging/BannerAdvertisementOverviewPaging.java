package com.ch.system.web.paging;

import com.ch.system.service.AdvertisementService;
import com.ch.system.web.facade.dto.BannerAdvertisementDTO;

import java.util.List;

/**
 * Created by maren on 2015/3/20.
 */
public class BannerAdvertisementOverviewPaging extends AbstractPaging<BannerAdvertisementDTO> {

    private AdvertisementService advertisementService;

    public BannerAdvertisementOverviewPaging(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }

    public List<BannerAdvertisementDTO> getItems() {
        return advertisementService.obtainBannerAdvertisements(getStartPosition(), getPageSize());
    }

    public long getTotalItemSize() {
        if (totalItemSize >= 0) {
            return totalItemSize;
        }
        totalItemSize = advertisementService.obtainBannerAdvertisementSize();
        return totalItemSize;
    }

    public String getParameterValues() {
        return "";
    }
}
