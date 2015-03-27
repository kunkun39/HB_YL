package com.ch.client.repository;

import com.ch.common.repository.HibernateEntityObjectDao;
import com.ch.system.domain.ChannelAdvertisement;
import com.ch.system.domain.BannerAdvertisement;
import com.ch.system.domain.ModuleAdvertisement;
import com.ch.system.domain.OpenAdvertisement;
import com.ch.system.domain.SubModule;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User: Jack Wang
 * Date: 15-3-18
 * Time: 下午3:40
 */
@Repository("clientAdvertisementDao")
public class ClientAdvertisementDaoImpl extends HibernateEntityObjectDao implements ClientAdvertisementDao {

    public List<BannerAdvertisement> loadAllBannerAdvertisement() {
        return getHibernateTemplate().find("from BannerAdvertisement ba order by ba.sequence asc ");
    }

    public List<OpenAdvertisement> loadAllOpenAdvertisement() {
        return getHibernateTemplate().find("from OpenAdvertisement oa order by oa.sequence asc");
    }

    public List<ChannelAdvertisement> loadAllChannelAdvertisement() {
        return getHibernateTemplate().find("from ChannelAdvertisement oa order by oa.sequence asc");
    }

    public List<ModuleAdvertisement> loadAllModuleAdvertisement() {
        return getHibernateTemplate().find("from ModuleAdvertisement oa order by oa.sequence asc");
    }

    public List<SubModule> loadSubModules(int moduleAdvertisement) {
        return getHibernateTemplate().find("from SubModule sm where sm.moduleAdvertisement.id = ?", new Object[]{moduleAdvertisement});
    }
}
