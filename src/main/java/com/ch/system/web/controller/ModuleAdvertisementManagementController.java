package com.ch.system.web.controller;

import com.ch.common.web.session.SessionKey;
import com.ch.system.service.AdvertisementService;
import com.ch.system.web.facade.dto.ModuleAdvertisementDTO;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: Jack Wang
 * Date: 15-3-18
 * Time: 下午4:35
 */
public class ModuleAdvertisementManagementController extends AbstractController {

    private AdvertisementService advertisementService;

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.getSession().setAttribute(SessionKey.BROSWER_LOCATION, "AD");

        Map<String, Object> model = new HashMap<String, Object>();
        List<ModuleAdvertisementDTO> ads = advertisementService.obtainModuleAdvertisements();
        model.put("ad1", ads.get(0));
        model.put("ad2", ads.get(1));
        model.put("ad3", ads.get(2));
        model.put("ad4", ads.get(3));
        model.put("ad5", ads.get(4));
        model.put("ad6", ads.get(5));
        model.put("ad7", ads.get(6));
        model.put("ad8", ads.get(7));

        return new ModelAndView("backend/ad/moduleadvertisementoverview", model);
    }

    public void setAdvertisementService(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }
}
