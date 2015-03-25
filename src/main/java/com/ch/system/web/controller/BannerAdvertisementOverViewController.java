package com.ch.system.web.controller;

import com.ch.system.service.AdvertisementServiceImpl;
import com.ch.system.web.paging.BannerAdvertisementOverviewPaging;
import com.ch.system.web.paging.OpenAdvertisementOverviewPaging;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by maren on 2015/3/20.
 */
public class BannerAdvertisementOverViewController extends AbstractController {
    @Resource
    private AdvertisementServiceImpl advertisementService;
    private String applicationWebAddress;

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        int current = ServletRequestUtils.getIntParameter(httpServletRequest, "current", 1);
        httpServletRequest.setAttribute("current",current);
        BannerAdvertisementOverviewPaging paging = new BannerAdvertisementOverviewPaging(advertisementService);
        constructPaging(paging,current);
        ModelAndView mv = new ModelAndView();
        mv.addObject("bas", paging.getItems());
        mv.addObject("paging", paging);
        mv.addObject("applicationWebAddress",applicationWebAddress);
        mv.setViewName("backend/ad/banneradvertisementoverview");
        return mv;

    }

    private void constructPaging(BannerAdvertisementOverviewPaging paging, int current) {
        paging.setCurrentPageNumber(current);
    }


    public void setApplicationWebAddress(String applicationWebAddress) {
        this.applicationWebAddress = applicationWebAddress;
    }


}
