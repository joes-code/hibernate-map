package com.joe.example.hibernate_map.test.service;

import com.joe.example.hibernate_map.test.entity.Asset;
import com.joe.example.hibernate_map.test.entity.AssetDetail;
import com.joe.example.hibernate_map.test.entity.AssetDetailId;
import com.joe.example.hibernate_map.test.entity.AssetId;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HibernateTest {

    private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    private Session session;

    @Before
    public void setup() {
        session = sessionFactory.openSession();
    }

    @After
    public void tearDown() {
        try {
            if (session != null && session.isOpen()) {
                session.close();
            }
        } finally {
            sessionFactory.close();
        }
    }

    @Test
    public void testSaveAndUpdate() {
        Asset asset = getComputerAsset(1);
        save(asset);

        asset = session.get(Asset.class, asset.getId());
        // Test passes if detech wasn't performed, comment out the following line to see
        session.detach(asset);

        asset.setPrice(new BigDecimal("3000"));
        asset.getAssetDetail().setDescription("macbook");

        update(asset);

        asset = session.get(Asset.class, asset.getId());
        assertThat(asset.getPrice(), is(new BigDecimal("3000")));
        session.close();
    }

    private void update(Asset asset) {
        session.beginTransaction();
        session.merge(asset);
        session.getTransaction().commit();
    }

    private void save(Asset asset) {
        session.beginTransaction();
        session.save(asset);
        session.getTransaction().commit();
    }

    private Asset getComputerAsset(Integer assetId) {
        Asset asset = new Asset();
        asset.setId(new AssetId());
        asset.getId().setAssetId(assetId);

        AssetDetail assetDetail = new AssetDetail();
        assetDetail.setId(new AssetDetailId());
        assetDetail.getId().setAssetId(assetId);
        assetDetail.setDescription("macbook pro");

        asset.setPrice(new BigDecimal("10000.00"));
        asset.setAssetDetail(assetDetail);
        return asset;
    }
}
