package com.ch.client.service;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * User: Jack Wang
 * Date: 15-3-24
 * Time: 下午4:33
 */
@Service("clientCacheService")
public class ClientCacheServiceImpl implements ClientCacheService {
    /***********************************************Banner广告****************************************************/
    private Map<Integer, String> bannerAdvertisementCache=new HashMap<Integer, String>();

    public String getBannerAdvertisementByServiceId(int serviceId) {
        return bannerAdvertisementCache.get(serviceId);
    }

    public void cacheBannerAdvertisement(String value ,int serviceId) {
      bannerAdvertisementCache.put(serviceId,value);
    }

    public void cleanCacheBannerAdvertisement(){
        bannerAdvertisementCache.clear();
    }

    /***********************************************开机广告*******************************************************/

    private final static String OPEN_ADVERTISEMENT_KEY = "OPEN_ADVERTISEMENT_KEY";
    private Map<String, String> openAdvertisementeCache = new HashMap<String, String>();
    public String getOpenAdvertisement() {
        return openAdvertisementeCache.get(OPEN_ADVERTISEMENT_KEY);
    }

    public void cacheOpenAdvertisement(String value) {
        openAdvertisementeCache.put(OPEN_ADVERTISEMENT_KEY, value);
    }

    public void cleanCachedOpenAdvertisement() {
        openAdvertisementeCache.clear();
    }

     /***********************************************八大模块*******************************************************/

    private final static String MODULE_ADVERTISEMENT_KEY = "MODULE_ADVERTISEMENT_KEY";
    private Map<String, String> moduleAdvertisementeCache = new HashMap<String, String>();

    public String getModuleAdvertisement() {
        return moduleAdvertisementeCache.get(MODULE_ADVERTISEMENT_KEY);
    }

    public void cacheModuleAdvertisement(String value) {
        moduleAdvertisementeCache.put(MODULE_ADVERTISEMENT_KEY, value);
    }

    public void cleanCachedModuleAdvertisement() {
        moduleAdvertisementeCache.clear();
    }

    /***********************************************八大模块子模块***************************************************/

    private final static String SUBMODULE_KEY = "SUBMODULE_KEY_";
    private Map<String, String> subModuleCache = new HashMap<String, String>();

    public String getSubModule(int moduleId) {
        return subModuleCache.get(SUBMODULE_KEY + moduleId);
    }

    public void cacheSubModule(int moduleId, String value) {
        subModuleCache.put(SUBMODULE_KEY + moduleId, value);
    }

    public void cleanCachedSubModule(int moduleId) {
        subModuleCache.remove(SUBMODULE_KEY + moduleId);
    }
}
