package com.ch.client.service;

/**
 * User: Jack Wang
 * Date: 15-3-24
 * Time: 下午4:33
 */
public interface ClientCacheService {

    /***********************************************开机广告*******************************************************/

    /**
     * 获得开机广告缓存
     */
    String getOpenAdvertisement();

    /**
     * 缓存开机广告
     */
    void cacheOpenAdvertisement(String value);

    /**
     * 清除开机广告缓存
     */
    void cleanCachedOpenAdvertisement();

    /***********************************************八大模块*******************************************************/

    /**
     * 获得八大模块缓存
     */
    String getModuleAdvertisement();

    /**
     * 缓存八大模块
     */
    void cacheModuleAdvertisement(String value);

    /**
     * 清除八大模块的缓存
     */
    void cleanCachedModuleAdvertisement();

    /***********************************************八大模块子模块***************************************************/

    /**
     * 获得八大模块子模块缓存
     */
    String getSubModule(int moduleId);

    /**
     * 缓存八大模块子模块
     */
    void cacheSubModule(int moduleId, String value);

    /**
     * 清除八大模块子模块的缓存
     */
    void cleanCachedSubModule(int moduleId);
}
