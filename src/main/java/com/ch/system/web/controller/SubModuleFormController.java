package com.ch.system.web.controller;

import com.ch.common.utils.ValidateUtils;
import com.ch.system.service.AdvertisementService;
import com.ch.system.web.facade.dto.SubModuleDTO;
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
 * Time: 下午5:51
 */
public class SubModuleFormController extends SimpleFormController {

    private AdvertisementService advertisementService;

    public SubModuleFormController() {
        setCommandClass(SubModuleDTO.class);
        setCommandName("subModule");
        setFormView("/backend/ad/submoduleform");
    }

    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {
        int subModuleId = ServletRequestUtils.getIntParameter(request, "subModuleId", -1);
        int moduleAdvertisementId = ServletRequestUtils.getIntParameter(request, "moduleAdvertisementId", -1);
        int current = ServletRequestUtils.getIntParameter(request, "current", -1);

        request.setAttribute("current", current);
        request.setAttribute("moduleAdvertisementId", moduleAdvertisementId);

        if (subModuleId > 0) {
            return advertisementService.obtainSubModuleById(subModuleId);
        }
        return new SubModuleDTO(moduleAdvertisementId);
    }

    @Override
    protected void onBindAndValidate(HttpServletRequest request, Object command, BindException errors) throws Exception {
        String moduleTitle = ServletRequestUtils.getStringParameter(request, "moduleTitle", "");
        if (!StringUtils.hasText(moduleTitle)) {
            errors.rejectValue("moduleTitle", "submodule.ad.title.empty");
        }

        String moduleUrl = ServletRequestUtils.getStringParameter(request, "moduleUrl", "");
        if (StringUtils.hasText(moduleUrl)) {
            if (!ValidateUtils.isValidateURL(moduleUrl)) {
                errors.rejectValue("moduleUrl", "submodule.ad.url.validate");
            }
        } else {
            errors.rejectValue("moduleUrl", "submodule.ad.url.empty");
        }
    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        int current = ServletRequestUtils.getIntParameter(request, "current", -1);
        int moduleAdvertisementId = ServletRequestUtils.getIntParameter(request, "moduleAdvertisementId", -1);

        SubModuleDTO dto = (SubModuleDTO) command;
        advertisementService.changeSubModuleDetails(dto);
        return new ModelAndView(new RedirectView("submoduleoverview.html?current=" + current + "&moduleAdvertisementId=" + moduleAdvertisementId));
    }

    public void setAdvertisementService(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }
}

