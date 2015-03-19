package com.ch.system.web.controller;

import com.ch.common.web.session.SessionKey;
import com.ch.system.service.AdvertisementService;
import com.ch.system.web.facade.dto.ModuleAdvertisementDTO;
import com.ch.system.web.facade.dto.SubModuleDTO;
import com.ch.system.web.paging.SubModulePaging;
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
 * Date: 15-3-19
 * Time: 下午4:01
 */
public class SubModuleManagementController extends AbstractController {

    private AdvertisementService advertisementService;

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.getSession().setAttribute(SessionKey.BROSWER_LOCATION, "AD");

        int moduleAdvertisementId = ServletRequestUtils.getIntParameter(request, "moduleAdvertisementId", -1);
        int current = ServletRequestUtils.getIntParameter(request, "current", 1);
        request.setAttribute("current", current);

        Map<String, Object> model = new HashMap<String, Object>();
        SubModulePaging paging = new SubModulePaging(advertisementService);
        constructPaging(paging, current, moduleAdvertisementId);
        List<SubModuleDTO> modules = paging.getItems();
        model.put("modules", modules);
        model.put("paging", paging);
        ModuleAdvertisementDTO moduleAdvertisement = advertisementService.obtainModuleAdvertisementById(moduleAdvertisementId);
        model.put("moduleAdvertisement", moduleAdvertisement);

        return new ModelAndView("backend/ad/submoduleoverview", model);
    }

    private void constructPaging(SubModulePaging paging, int current, int moduleAdvertisementId) {
        paging.setCurrentPageNumber(current);
        paging.setModuleAdvertisementId(moduleAdvertisementId);
    }

    public void setAdvertisementService(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }
}
