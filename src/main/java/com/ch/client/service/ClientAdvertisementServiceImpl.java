package com.ch.client.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ch.client.repository.ClientAdvertisementDao;
import com.ch.system.domain.ModuleAdvertisement;
import com.ch.system.domain.OpenAdvertisement;
import com.ch.system.domain.SubModule;
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

    @Value("${application.image.url}")
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
            ad.put("title", advertisement.getModuleTitle());
            ad.put("description", advertisement.getModuleDescription());
            ads.add(ad);
        }
        all.put("modules", ads);

        return all.toJSONString();
    }

    public String obtainClientSubModule(int moduleAdvertisement) {
        List<SubModule> subModules = clientAdvertisementDao.loadSubModules(moduleAdvertisement);

        JSONObject all = new JSONObject();
        JSONArray ads = new JSONArray();
        for (SubModule subModule : subModules) {
            JSONObject ad = new JSONObject();
            ad.put("subindex", subModule.getSequence());
            ad.put("title", subModule.getModuleTitle());
            ad.put("address", subModule.getModuleUrl());
            ads.add(ad);
        }
        all.put("submodules", ads);

        return all.toJSONString();
    }
}
