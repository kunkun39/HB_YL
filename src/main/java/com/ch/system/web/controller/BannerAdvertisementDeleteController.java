package com.ch.system.web.controller;

import com.ch.system.service.AdvertisementService;
import com.ch.system.service.AdvertisementServiceImpl;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by maren on 2015/3/23.
 */
public class BannerAdvertisementDeleteController extends AbstractController {
    private AdvertisementService advertisementService;
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        int bannerAdvertisementId = ServletRequestUtils.getIntParameter(httpServletRequest, "bannerAdvertisementId", -1);
        String current = ServletRequestUtils.getStringParameter(httpServletRequest, "current", "");

        advertisementService.deleteBannerAdvertisement(bannerAdvertisementId);

        return new ModelAndView(new RedirectView("banneradvertisementoverview.html?current=" + current));
    }

    public void setAdvertisementService(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }

}
