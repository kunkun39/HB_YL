package com.ch.system.web.paging;

import com.ch.system.service.AdvertisementService;
import com.ch.system.web.facade.dto.SubModuleDTO;

import java.util.List;

/**
 * User: Jack Wang
 * Date: 15-3-19
 * Time: 下午4:24
 */
public class SubModulePaging extends AbstractPaging<SubModuleDTO> {

    private AdvertisementService advertisementService;

    private int moduleAdvertisementId;

    public SubModulePaging(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }

     @Override
    public int getPageSize() {
        return 12;
    }

    public List<SubModuleDTO> getItems() {
        return advertisementService.obtainSubModules(moduleAdvertisementId, getStartPosition(), getPageSize());
    }

    public long getTotalItemSize() {
        if (totalItemSize >= 0) {
            return totalItemSize;
        }
        totalItemSize = advertisementService.obtainSubModuleSize(moduleAdvertisementId);
        return totalItemSize;
    }

    public String getParameterValues() {
        return "&moduleAdvertisementId=" + getModuleAdvertisementId();
    }

    public int getModuleAdvertisementId() {
        return moduleAdvertisementId;
    }

    public void setModuleAdvertisementId(int moduleAdvertisementId) {
        this.moduleAdvertisementId = moduleAdvertisementId;
    }
}


