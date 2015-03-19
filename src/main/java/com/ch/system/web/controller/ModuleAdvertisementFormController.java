package com.ch.system.web.controller;

import com.ch.common.utils.ValidateUtils;
import com.ch.system.service.AdvertisementService;
import com.ch.system.web.facade.dto.ModuleAdvertisementDTO;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * User: Jack Wang
 * Date: 15-3-19
 * Time: 上午11:23
 */
public class ModuleAdvertisementFormController extends SimpleFormController {

    private AdvertisementService advertisementService;

    public ModuleAdvertisementFormController() {
        setCommandClass(ModuleAdvertisementDTO.class);
        setCommandName("moduleAdvertisement");
        setFormView("/backend/ad/moduleadvertisementform");
    }

    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {
        int moduleAdvertisementId = ServletRequestUtils.getIntParameter(request, "moduleAdvertisementId", -1);

        if (moduleAdvertisementId > 0) {
            return advertisementService.obtainModuleAdvertisementById(moduleAdvertisementId);
        }
        return new ModuleAdvertisementDTO();
    }

    @Override
    protected void onBindAndValidate(HttpServletRequest request, Object command, BindException errors) throws Exception {
        String moduleTitle = ServletRequestUtils.getStringParameter(request, "moduleTitle", "");
        if (!StringUtils.hasText(moduleTitle)) {
            errors.rejectValue("moduleTitle", "module.ad.title.empty");
        }

        boolean includeSub = ServletRequestUtils.getBooleanParameter(request, "includeSub", false);
        String moduleUrl = ServletRequestUtils.getStringParameter(request, "moduleUrl", "");
        if (includeSub) {
            if (StringUtils.hasText(moduleUrl)) {
                if (!ValidateUtils.isValidateURL(moduleUrl)) {
                    errors.rejectValue("moduleUrl", "module.ad.url.validate");
                }
            }
        } else {
            if (StringUtils.hasText(moduleUrl)) {
                if (!ValidateUtils.isValidateURL(moduleUrl)) {
                    errors.rejectValue("moduleUrl", "module.ad.url.validate");
                }
            } else {
                errors.rejectValue("moduleUrl", "module.ad.url.empty");
            }
        }
    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        ModuleAdvertisementDTO dto = (ModuleAdvertisementDTO) command;
        advertisementService.changeModuleAdvertisementDetails(dto);
        return new ModelAndView(new RedirectView("moduleadvertisementoverview.html"));
    }

    public void setAdvertisementService(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }
}
