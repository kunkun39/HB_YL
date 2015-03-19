package com.ch.system.web.controller;

import com.ch.system.service.AdvertisementService;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * User: Jack Wang
 * Date: 15-3-19
 * Time: 下午5:43
 */
public class SubModuleDeleteController extends AbstractController {

    private AdvertisementService advertisementService;

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int subModuleId = ServletRequestUtils.getIntParameter(request, "subModuleId", -1);
        int moduleAdvertisementId = ServletRequestUtils.getIntParameter(request, "moduleAdvertisementId", -1);
        int current = ServletRequestUtils.getIntParameter(request, "current", 1);

        advertisementService.deleteSubModule(subModuleId);

        return new ModelAndView(new RedirectView("submoduleoverview.html?current="+current+"&moduleAdvertisementId="+moduleAdvertisementId));
    }

    public void setAdvertisementService(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }
}
