package com.ch.jack;

import com.ch.common.utils.CHStringUtils;
import com.ch.system.domain.AdvertisementFile;
import com.ch.system.domain.BannerAdvertisement;
import com.ch.system.domain.ChannelAdvertisement;
import com.ch.system.domain.OpenAdvertisement;
import junit.framework.TestCase;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * User: Jack Wang
 * Date: 15-3-30
 * Time: 上午9:23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/database.xml", "/applicationContext.xml"})
public class PerformanceDaoTest extends TestCase {

    private final static int MANY_DATA_NUMBER = 200000;

    @Resource
    SessionFactory sessionFactory;

    HibernateTemplate hibernateTemplate;

    @Before
    public void setUp() {
        hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    @After
    public void tearDown() {
        hibernateTemplate = null;
    }

    @Test
    public void testInsertOpenAdvertisement() {
        Session session = hibernateTemplate.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        for (int i = 10; i < MANY_DATA_NUMBER; i++) {
            String title = CHStringUtils.getRandomString(17);
            OpenAdvertisement advertisement = new OpenAdvertisement(i, title);

            AdvertisementFile file = new AdvertisementFile();
            file.setActualFileName("actual.png");
            file.setUploadFileName("upload.png");
            file.setUploadTime(new DateTime());
            advertisement.changeAdvertisementFile(file);
            session.save(advertisement);

            if (i % 50 == 0) {
                session.flush();
                session.clear();
                System.out.println("finished save " + i);
            }
        }

        transaction.commit();
    }

    @Test
    public void testInsertBanner() {
        Session session = hibernateTemplate.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        for (int i = 10; i < MANY_DATA_NUMBER; i++) {
            String title = CHStringUtils.getRandomString(17);
            BannerAdvertisement advertisement = new BannerAdvertisement(i, title, "23");

            AdvertisementFile file = new AdvertisementFile();
            file.setActualFileName("actual.png");
            file.setUploadFileName("upload.png");
            file.setUploadTime(new DateTime());
            advertisement.changeAdvertisementFile(file);
            session.save(advertisement);

            if (i % 50 == 0) {
                session.flush();
                session.clear();
                System.out.println("finished save " + i);
            }
        }

        transaction.commit();
    }

    @Test
    public void testInsertChannleAdvertisement() {
        Session session = hibernateTemplate.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        for (int i = 10; i < MANY_DATA_NUMBER; i++) {
            String title = CHStringUtils.getRandomString(17);
            ChannelAdvertisement advertisement = new ChannelAdvertisement(i, title);

            AdvertisementFile file = new AdvertisementFile();
            file.setActualFileName("actual.png");
            file.setUploadFileName("upload.png");
            file.setUploadTime(new DateTime());
            advertisement.changeAdvertisementFile(file);
            session.save(advertisement);

            if (i % 50 == 0) {
                session.flush();
                session.clear();
                System.out.println("finished save " + i);
            }
        }

        transaction.commit();
    }
}
