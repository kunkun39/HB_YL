package com.ch.system.web.paging;

import com.ch.system.service.AdvertisementService;
import com.ch.system.web.facade.dto.ChannelAdvertisementDTO;
import com.ch.system.web.facade.dto.OpenAdvertisementDTO;

import java.util.List;

/**
 * User: Jack Wang
 * Date: 15-3-17
 * Time: 下午2:26
 */
public class ChannelAdvertisementOverviewPaging extends AbstractPaging<ChannelAdvertisementDTO> {

    private AdvertisementService advertisementService;

    public ChannelAdvertisementOverviewPaging(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }

    public List<ChannelAdvertisementDTO> getItems() {
        return advertisementService.obtainChannelAdvertisements(getStartPosition(), getPageSize());
    }

    public long getTotalItemSize() {
        if (totalItemSize >= 0) {
            return totalItemSize;
        }
        totalItemSize = advertisementService.obtainChannelAdvertisementSize();
        return totalItemSize;
    }

    public String getParameterValues() {
        return "";
    }
}