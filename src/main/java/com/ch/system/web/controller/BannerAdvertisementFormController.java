package com.ch.system.web.controller;

import com.ch.system.service.AdvertisementServiceImpl;
import com.ch.system.web.facade.dto.BannerAdvertisementDTO;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by maren on 2015/3/20.
 */
public class BannerAdvertisementFormController extends SimpleFormController {
    @Resource
    private AdvertisementServiceImpl advertisementService;
    private String applicationWebAddress;

    public BannerAdvertisementFormController() {
        setCommandClass(BannerAdvertisementDTO.class);
        setCommandName("bannerAdvertisement");
        setFormView("/backend/ad/banneradvertisementform");
    }

    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {
        int bannerAdvertisementId = ServletRequestUtils.getIntParameter(request, "bannerAdvertisementId", -1);
        String current = ServletRequestUtils.getStringParameter(request, "current", "");
        request.setAttribute("current", current);
        request.setAttribute("applicationWebAddress", applicationWebAddress);

        if (bannerAdvertisementId > 0) {
            return advertisementService.obtainBannerAdvertisementById(bannerAdvertisementId);
        }
        return new BannerAdvertisementDTO();
    }

    @Override
    protected void onBindAndValidate(HttpServletRequest request, Object command, BindException errors) throws Exception {
        String advertisementTitle = ServletRequestUtils.getStringParameter(request, "advertisementTitle", "");
        int advertisementFileId = ServletRequestUtils.getIntParameter(request, "advertisementFileId", -1);
        if (!StringUtils.hasText(advertisementTitle)) {
            errors.rejectValue("advertisementTitle", "open.ad.title.empty");
        }

        String serviceId = ServletRequestUtils.getStringParameter(request, "serviceId", "");
        if (StringUtils.hasText(serviceId)) {
            try {
                Integer.valueOf(serviceId);
            } catch (Exception e) {
                errors.rejectValue("serviceId", "banner.ad.serviceId.validate");
            }
        }

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartRequest.getFile("advertisementFile");
        if (advertisementFileId <= 0) {
            if (file == null || file.getSize() == 0) {
                errors.rejectValue("advertisementFile", "open.ad.file.empty");
            }
        }
    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        String current = ServletRequestUtils.getStringParameter(request, "current", "");
        BannerAdvertisementDTO dto = (BannerAdvertisementDTO) command;
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartRequest.getFile("advertisementFile");
        if (file != null && file.getSize() > 0) {
            dto.setAdvertisementFile(file);
        }

        advertisementService.changeBannerAdvertisementDetails(dto);
        return new ModelAndView(new RedirectView("banneradvertisementoverview.html?current=" + current));
    }

    public void setApplicationWebAddress(String applicationWebAddress) {
        this.applicationWebAddress = applicationWebAddress;
    }

}
