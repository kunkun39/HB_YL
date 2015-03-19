package com.ch.system.repository;

import com.ch.common.repository.HibernateEntityObjectDao;
import com.ch.system.domain.ModuleAdvertisement;
import com.ch.system.domain.OpenAdvertisement;
import com.ch.system.domain.SubModule;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User: Jack Wang
 * Date: 15-3-17
 * Time: 下午1:19
 */
@Repository("advertisementDao")
public class AdvertisementDaoImpl extends HibernateEntityObjectDao implements AdvertisementDao {

    public List<OpenAdvertisement> loadOpenAdvertisements(int startPosition, int pageSize) {
        StringBuilder builder = new StringBuilder();
        builder.append("from OpenAdvertisement oa order by oa.sequence asc");

        Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
        Query query = session.createQuery(builder.toString());
        query.setMaxResults(pageSize);
        query.setFirstResult(startPosition);

        List<OpenAdvertisement> openAds = query.list();
        return openAds;
    }

    public int loadOpenAdvertisementSize() {
        StringBuilder builder = new StringBuilder();
        builder.append("select count(oa.id) from OpenAdvertisement oa");
        List list =  getHibernateTemplate().find(builder.toString());
        return ((Long)list.get(0)).intValue();
    }

    public int getMaxOpenAdvertisementSequence() {
        StringBuilder builder = new StringBuilder();
        builder.append("select max(oa.sequence) from OpenAdvertisement oa");
        List list =  getHibernateTemplate().find(builder.toString());

        Object value = list.get(0);
        if (value != null) {
            return ((Integer) value).intValue();
        }
        return 0;
    }

    public List<ModuleAdvertisement> loadModuleAdvertisements() {
        return getHibernateTemplate().find("from ModuleAdvertisement") ;
    }

    public List<SubModule> loadSubModules(int moduleAdvertisementId, int startPosition, int pageSize) {
        StringBuilder builder = new StringBuilder();
        builder.append("from SubModule sm where sm.moduleAdvertisement.id=" + moduleAdvertisementId + " order by sm.sequence asc");

        Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
        Query query = session.createQuery(builder.toString());
        query.setMaxResults(pageSize);
        query.setFirstResult(startPosition);

        List<SubModule> modules = query.list();
        return modules;
    }

    public int loadSubModuleSize(int moduleAdvertisementId) {
        StringBuilder builder = new StringBuilder();
        builder.append("select count(sm.id) from SubModule sm where sm.moduleAdvertisement.id=" + moduleAdvertisementId + " order by sm.sequence asc");
        List list =  getHibernateTemplate().find(builder.toString());
        return ((Long)list.get(0)).intValue();
    }
}
