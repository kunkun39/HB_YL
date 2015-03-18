package com.ch.client.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ch.client.repository.ClientAdvertisementDao;
import com.ch.system.domain.ModuleAdvertisement;
import com.ch.system.domain.OpenAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: Jack Wang
 * Date: 15-3-18
 * Time: 下午3:34
 */
@Service("clientAdvertisementService")
public class ClientAdvertisementServiceImpl implements ClientAdvertisementService {

    @Autowired
    private ClientAdvertisementDao clientAdvertisementDao;

    @Value("${application.web.url}")
    private String applicationWebAddress;

    public String obtainClientOpenAdvertisement() {
        List<OpenAdvertisement> advertisements = clientAdvertisementDao.loadAllOpenAdvertisement();

        JSONObject all = new JSONObject();
        JSONArray ads = new JSONArray();
        for (OpenAdvertisement advertisement : advertisements) {
            JSONObject ad = new JSONObject();
            ad.put("index", advertisement.getSequence());
            ad.put("title", advertisement.getAdvertisememtTitle());
            ad.put("url", applicationWebAddress + advertisement.getAdvertisementFile().getActualFileName());
            ads.add(ad);
        }
        all.put("openads", ads);

        return all.toJSONString();
    }

    public String obtainClientModuleAdvertisement() {
        List<ModuleAdvertisement> advertisements = clientAdvertisementDao.loadAllModuleAdvertisement();

        JSONObject all = new JSONObject();
        JSONArray ads = new JSONArray();
        for (ModuleAdvertisement advertisement : advertisements) {
            JSONObject ad = new JSONObject();
            ad.put("index", advertisement.getSequence());
            ad.put("title", advertisement.getAdvertisememtTitle());
            ad.put("url", applicationWebAddress + advertisement.getAdvertisementFile().getActualFileName());
            ads.add(ad);
        }
        all.put("openads", ads);

        return all.toJSONString();
    }
}
