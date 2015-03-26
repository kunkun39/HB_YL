package com.ch.client.service;

/**
 * User: Jack Wang
 * Date: 15-3-18
 * Time: 下午3:34
 */
public interface ClientAdvertisementService {

    String obtainClientBannerAdvertisement();

    String obtainClientOpenAdvertisement();

    String obtainClientModuleAdvertisement();

    String obtainClientSubModule(int moduleAdvertisementId);
}
