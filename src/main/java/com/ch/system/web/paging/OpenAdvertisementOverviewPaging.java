package com.ch.system.web.paging;

import com.ch.system.service.AdvertisementService;
import com.ch.system.web.facade.dto.OpenAdvertisementDTO;

import java.util.List;

/**
 * User: Jack Wang
 * Date: 15-3-17
 * Time: 下午2:26
 */
public class OpenAdvertisementOverviewPaging extends AbstractPaging<OpenAdvertisementDTO> {

    private AdvertisementService advertisementService;

    public OpenAdvertisementOverviewPaging(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }

    public List<OpenAdvertisementDTO> getItems() {
        return advertisementService.obtainOpenAdvertisements(getStartPosition(), getPageSize());
    }

    public long getTotalItemSize() {
        if (totalItemSize >= 0) {
            return totalItemSize;
        }
        totalItemSize = advertisementService.obtainOpenAdvertisementSize();
        return totalItemSize;
    }

    public String getParameterValues() {
        return "";
    }
}