package com.ch.system.repository;

import com.ch.common.repository.HibernateEntityObjectDao;
import com.ch.system.domain.ChannelAdvertisement;
import com.ch.system.domain.BannerAdvertisement;
import com.ch.system.domain.ModuleAdvertisement;
import com.ch.system.domain.OpenAdvertisement;
import com.ch.system.domain.SubModule;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
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

    /*************************Banner广告部分******************************/

    public List<BannerAdvertisement> obtainBannerAdvertisementsByServiceId(int serviceId, int startPosition, int pageSize) {
        StringBuilder builder = new StringBuilder();
        builder.append("from BannerAdvertisement as ba  where ba.serviceId = " + serviceId);

        Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
        Query query = session.createQuery(builder.toString());
        query.setMaxResults(pageSize);
        query.setFirstResult(startPosition);
        List<BannerAdvertisement> bannerAds = query.list();
        return bannerAds;
    }

    public List<BannerAdvertisement> loadBannerAdvertisements(int startPosition, int pageSize) {
        StringBuilder builder = new StringBuilder();
        builder.append("from BannerAdvertisement ba order by ba.sequence asc");

        Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
        Query query = session.createQuery(builder.toString());
        query.setMaxResults(pageSize);
        query.setFirstResult(startPosition);
        List<BannerAdvertisement> bannerAds = query.list();
        return bannerAds;
    }

    public int loadBannerAdvertisementSizeByServiceId(int serviceId) {
        StringBuilder builder = new StringBuilder();
        builder.append("select count(ba.id) from BannerAdvertisement ba where ba.serviceId = " + serviceId);
        List list =  getHibernateTemplate().find(builder.toString());
        Long i=(Long)list.get(0);
        int sum=((Long)list.get(0)).intValue();
        return sum;
    }

    public int loadBannerAdvertisementSize() {
        StringBuilder builder = new StringBuilder();
        builder.append("select count(ba.id) from BannerAdvertisement ba");
        List list =  getHibernateTemplate().find(builder.toString());
        return ((Long)list.get(0)).intValue();
    }

    public int getMaxBannerAdvertisementSequence() {
        StringBuilder builder = new StringBuilder();
        builder.append("select max(ba.sequence) from BannerAdvertisement ba");
        List list =  getHibernateTemplate().find(builder.toString());
        Object value = list.get(0);
        if (value != null) {
            return ((Integer) value).intValue();
        }
        return 0;
    }

    public void deleteAndjustAfterBannerAdvertisementSequence(int sequence, int bannerAdvertisementId) {
        Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
        SQLQuery update = session.createSQLQuery("update banner_advertisement s set s.sequence = s.sequence - 1 where s.sequence>" + sequence);
        update.executeUpdate();

        SQLQuery delete = session.createSQLQuery("delete from banner_advertisement where id = " + bannerAdvertisementId);
        delete.executeUpdate();
    }

    /*************************开机广告部分******************************/

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

    public void deleteAndjustAfterOpenAdvertisementSequence(int position, int openAdvertisementId) {
        Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
        SQLQuery update = session.createSQLQuery("update open_advertisement s set s.sequence = s.sequence - 1 where s.sequence>" + position);
        update.executeUpdate();

        SQLQuery delete = session.createSQLQuery("delete from open_advertisement where id = " + openAdvertisementId);
        delete.executeUpdate();
    }

    /*************************频道列表广告部分******************************/

    public List<ChannelAdvertisement> loadChannelAdvertisements(int startPosition, int pageSize) {
        StringBuilder builder = new StringBuilder();
        builder.append("from ChannelAdvertisement oa order by oa.sequence asc");

        Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
        Query query = session.createQuery(builder.toString());
        query.setMaxResults(pageSize);
        query.setFirstResult(startPosition);

        List<ChannelAdvertisement> channelAds = query.list();
        return channelAds;
    }

    public int loadChannelAdvertisementSize() {
        StringBuilder builder = new StringBuilder();
        builder.append("select count(oa.id) from ChannelAdvertisement oa");
        List list =  getHibernateTemplate().find(builder.toString());
        return ((Long)list.get(0)).intValue();
    }

    public int getMaxChannelAdvertisementSequence() {
        StringBuilder builder = new StringBuilder();
        builder.append("select max(oa.sequence) from ChannelAdvertisement oa");
        List list =  getHibernateTemplate().find(builder.toString());

        Object value = list.get(0);
        if (value != null) {
            return ((Integer) value).intValue();
        }
        return 0;
    }

    public void deleteAndjustAfterChannelAdvertisementSequence(int position, int channelAdvertisementId) {
        Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
        SQLQuery update = session.createSQLQuery("update channel_advertisement s set s.sequence = s.sequence - 1 where s.sequence>" + position);
        update.executeUpdate();

        SQLQuery delete = session.createSQLQuery("delete from channel_advertisement where id = " + channelAdvertisementId);
        delete.executeUpdate();
    }

    /*************************八大模块部分******************************/

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

    public int getMaxSubModuleSequence(int moduleAdvertisementId) {
        StringBuilder builder = new StringBuilder();
        builder.append("select max(sm.sequence) from SubModule sm where sm.moduleAdvertisement.id=" + moduleAdvertisementId);
        List list =  getHibernateTemplate().find(builder.toString());

        Object value = list.get(0);
        if (value != null) {
            return ((Integer) value).intValue();
        }
        return 0;
    }

    public void deleteAndjustAfterSubModuleSequence(int subModuleId, int position, int moduleAdvertisementId) {
        Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
        SQLQuery update = session.createSQLQuery("update submodule_advertisement s set s.sequence = s.sequence - 1 " +
                "where s.sequence>" + position + " and module_advertisement_id=" + moduleAdvertisementId);
        update.executeUpdate();

        SQLQuery delete = session.createSQLQuery("delete from submodule_advertisement where id = " + subModuleId);
        delete.executeUpdate();
    }
}
