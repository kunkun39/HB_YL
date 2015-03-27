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
 * Date: 15-3-18
 * Time: 下午1:41
 */
public class ChannelAdvertisementDeleteController extends AbstractController {

    private AdvertisementService advertisementService;

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int channelAdvertisementId = ServletRequestUtils.getIntParameter(request, "channelAdvertisementId", -1);
        String current = ServletRequestUtils.getStringParameter(request, "current", "");

        advertisementService.deleteChannelAdvertisement(channelAdvertisementId);

        return new ModelAndView(new RedirectView("channeladvertisementoverview.html?current="+current));
    }

    public void setAdvertisementService(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }
}
