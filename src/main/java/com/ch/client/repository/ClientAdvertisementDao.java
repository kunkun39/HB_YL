package com.ch.client.repository;

import com.ch.common.repository.EntityObjectDao;
import com.ch.system.domain.OpenAdvertisement;

import java.util.List;

/**
 * User: Jack Wang
 * Date: 15-3-18
 * Time: 下午3:38
 */
public interface ClientAdvertisementDao extends EntityObjectDao {

    List<OpenAdvertisement> loadAllOpenAdvertisement();
}
