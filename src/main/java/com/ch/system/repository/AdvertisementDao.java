package com.ch.system.repository;

import com.ch.common.repository.EntityObjectDao;
import com.ch.system.domain.OpenAdvertisement;

import java.util.List;

/**
 * User: Jack Wang
 * Date: 15-3-17
 * Time: 下午1:18
 */
public interface AdvertisementDao extends EntityObjectDao {

    /*************************开机广告部分******************************/

    List<OpenAdvertisement> loadOpenAdvertisements(int startPosition, int pageSize);

    int loadOpenAdvertisementSize();

    int getMaxOpenAdvertisement();
}
