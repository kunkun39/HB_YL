package com.ch.client.service;

import IceUtilInternal.StringUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ch.client.repository.ClientAdvertisementDao;
import com.ch.system.domain.BannerAdvertisement;
import com.ch.system.domain.ModuleAdvertisement;
import com.ch.system.domain.OpenAdvertisement;
import com.ch.system.domain.SubModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: Jack Wang
 * Date: 15-3-18
 * Time: 下午3:34
 */
@Service("clientAdvertisementService")
public class ClientAdvertisementServiceImpl implements ClientAdvertisementService {

    @Autowired
    private ClientAdvertisementDao clientAdvertisementDao;

    @Autowired
    private ClientCacheService clientCacheService;

    @Value("${application.image.url}")
    private String applicationWebAddress;

    public String obtainClientBannerAdvertisement() {
        String cachedValue = clientCacheService.getBannerAdvertisement();

        if (StringUtils.hasText(cachedValue)) {
            /**
             * 发现有缓存，直接返回用户数据
             */
            return cachedValue;
        } else {
            /**
             * 没有缓存，从数据库中拿数据，然后缓存起来
             */
            List<BannerAdvertisement> bannerAdvertisementList = clientAdvertisementDao.loadAllBannerAdvertisement();
            JSONObject all = new JSONObject();
            JSONArray bas = new JSONArray();
            for (BannerAdvertisement bannerAdvertisement : bannerAdvertisementList) {
                JSONObject ba = new JSONObject();
                ba.put("index", bannerAdvertisement.getSequence());
                ba.put("title", bannerAdvertisement.getAdvertisememtTitle());
                ba.put("url", applicationWebAddress + bannerAdvertisement.getAdvertisementFile().getActualFileName());
                ba.put("serviceId", bannerAdvertisement.getServiceId());
                bas.add(ba);
            }
            all.put("bannersads", bas);
            String returnValue = all.toJSONString();
            clientCacheService.cacheBannerAdvertisement(returnValue);
            return returnValue;
        }
    }

    public String obtainClientOpenAdvertisement() {
        String cachedValue = clientCacheService.getOpenAdvertisement();

        if (StringUtils.hasText(cachedValue)) {
            /**
             * 发现有缓存，直接返回用户数据
             */
            return cachedValue;
        } else {
            /**
             * 没有缓存，从数据库中拿数据，然后缓存起来
             */
            List<OpenAdvertisement> advertisements = clientAdvertisementDao.loadAllOpenAdvertisement();
            JSONObject all = new JSONObject();
            JSONArray ads = new JSONArray();
            for (OpenAdvertisement advertisement : advertisements) {
                JSONObject ad = new JSONObject();
                ad.put("index", advertisement.getSequence());
                ad.put("title", advertisement.getAdvertisememtTitle());
                ad.put("url", applicationWebAddress + advertisement.getAdvertisementFile().getActualFileName());
                ads.add(ad);
            }
            all.put("openads", ads);
            String returnValue = all.toJSONString();
            clientCacheService.cacheOpenAdvertisement(returnValue);
            return returnValue;
        }
    }

    public String obtainClientModuleAdvertisement() {
        String cachedValue = clientCacheService.getModuleAdvertisement();

        if (StringUtils.hasText(cachedValue)) {
            /**
             * 发现有缓存，直接返回用户数据
             */
            return cachedValue;
        } else {
            /**
             * 没有缓存，从数据库中拿数据，然后缓存起来
             */
            List<ModuleAdvertisement> advertisements = clientAdvertisementDao.loadAllModuleAdvertisement();
            JSONObject all = new JSONObject();
            JSONArray ads = new JSONArray();
            for (ModuleAdvertisement advertisement : advertisements) {
                JSONObject ad = new JSONObject();
                ad.put("index", advertisement.getSequence());
                ad.put("title", advertisement.getModuleTitle());
                ad.put("includesub", advertisement.isIncludeSub());
                ad.put("address", advertisement.getModuleUrl());
                ads.add(ad);
            }
            all.put("modules", ads);
            String returnValue = all.toJSONString();
            clientCacheService.cacheModuleAdvertisement(returnValue);
            return returnValue;
        }
    }

    public String obtainClientSubModule(int moduleAdvertisement) {
        String cachedValue = clientCacheService.getSubModule(moduleAdvertisement);

        if (StringUtils.hasText(cachedValue)) {
            /**
             * 发现有缓存，直接返回用户数据
             */
            return cachedValue;
        } else {
            /**
             * 没有缓存，从数据库中拿数据，然后缓存起来
             */
            List<SubModule> subModules = clientAdvertisementDao.loadSubModules(moduleAdvertisement);

            JSONObject all = new JSONObject();
            JSONArray ads = new JSONArray();
            for (SubModule subModule : subModules) {
                JSONObject ad = new JSONObject();
                ad.put("subindex", subModule.getSequence());
                ad.put("title", subModule.getModuleTitle());
                ad.put("address", subModule.getModuleUrl());
                ads.add(ad);
            }
            all.put("submodules", ads);
            String returnValue = all.toJSONString();
            clientCacheService.cacheSubModule(moduleAdvertisement, returnValue);
            return returnValue;
        }
    }
}
