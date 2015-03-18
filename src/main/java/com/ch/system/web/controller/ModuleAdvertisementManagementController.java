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

    private String applicationWebAddress;

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.getSession().setAttribute(SessionKey.BROSWER_LOCATION, "AD");

        Map<String, Object> model = new HashMap<String, Object>();
        List<ModuleAdvertisementDTO> ads = advertisementService.obtainModuleAdvertisements();
        model.put("ads", ads);
        model.put("applicationWebAddress", applicationWebAddress);

        return new ModelAndView("backend/ad/moduleadvertisementoverview", model);
    }

    public void setAdvertisementService(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }

    public void setApplicationWebAddress(String applicationWebAddress) {
        this.applicationWebAddress = applicationWebAddress;
    }
}
