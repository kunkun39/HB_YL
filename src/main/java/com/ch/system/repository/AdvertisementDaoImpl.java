package com.ch.system.repository;

import com.ch.common.repository.HibernateEntityObjectDao;
import com.ch.system.domain.OpenAdvertisement;
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
        builder.append("from OpenAdvertisement oa order by oa.index asc");

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

    public int getMaxOpenAdvertisement() {
        StringBuilder builder = new StringBuilder();
        builder.append("select max(oa.index) from OpenAdvertisement oa");
        List list =  getHibernateTemplate().find(builder.toString());
        return ((Long)list.get(0)).intValue();
    }
}
