package com.ch.system.web.controller;

import com.ch.common.web.session.SessionKey;
import com.ch.system.service.AdvertisementService;
import com.ch.system.web.facade.dto.OpenAdvertisementDTO;
import com.ch.system.web.paging.OpenAdvertisementOverviewPaging;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: Jack Wang
 * Date: 15-3-17
 * Time: 下午2:23
 */
public class OpenAdvertisementManagementController extends AbstractController {

    private AdvertisementService advertisementService;

    private String applicationWebAddress;

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.getSession().setAttribute(SessionKey.BROSWER_LOCATION, "AD");

        Map<String, Object> model = new HashMap<String, Object>();
        int current = ServletRequestUtils.getIntParameter(request, "current", 1);
        request.setAttribute("current", current);

        OpenAdvertisementOverviewPaging paging = new OpenAdvertisementOverviewPaging(advertisementService);
        constructPaging(paging, current);
        List<OpenAdvertisementDTO> ads = paging.getItems();
        model.put("ads", ads);
        model.put("paging", paging);
        model.put("applicationWebAddress", applicationWebAddress);

        return new ModelAndView("backend/ad/openadvertisementoverview", model);
    }

    private void constructPaging(OpenAdvertisementOverviewPaging paging, int current) {
        paging.setCurrentPageNumber(current);
    }

    public void setAdvertisementService(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }

    public void setApplicationWebAddress(String applicationWebAddress) {
        this.applicationWebAddress = applicationWebAddress;
    }
}
