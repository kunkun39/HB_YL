package com.ch.system.web.controller;

import com.ch.system.service.AdvertisementServiceImpl;
import com.ch.system.web.facade.dto.BannerAdvertisementDTO;
import com.ch.system.web.paging.BannerAdvertisementQueryByServiceIdPaging;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by maren on 2015/3/23.
 */
public class BannerAdvertisementManagementController extends AbstractController {
    @Resource
    AdvertisementServiceImpl advertisementService;
    private String applicationWebAddress;
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        int current=ServletRequestUtils.getIntParameter(httpServletRequest,"current",1);
        String  serviceId= ServletRequestUtils.getStringParameter(httpServletRequest, "serviceId", "");
        int serviceNum=0;
        if(StringUtils.hasText(serviceId)){
            serviceNum=Integer.valueOf(serviceId);
        }
        httpServletRequest.setAttribute("current",current);
        httpServletRequest.setAttribute("serviceId",serviceId);
        BannerAdvertisementQueryByServiceIdPaging paging=new BannerAdvertisementQueryByServiceIdPaging(advertisementService,serviceNum);
        constructPaging(paging,current);
        List<BannerAdvertisementDTO> bannerAdvertisementDTOs=paging.getItems();
        ModelAndView mv=new ModelAndView();
        mv.addObject("bas",bannerAdvertisementDTOs);
        mv.addObject("paging",paging);
        mv.addObject("applicationWebAddress",applicationWebAddress);
        mv.setViewName("backend/ad/banneradvertisementoverview");
        return mv;
    }


    private void constructPaging(BannerAdvertisementQueryByServiceIdPaging paging, int current) {
        paging.setCurrentPageNumber(current);
    }
    public void setApplicationWebAddress(String applicationWebAddress) {
        this.applicationWebAddress = applicationWebAddress;
    }

}
