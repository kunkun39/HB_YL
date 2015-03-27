package com.ch.system.web.controller;

import com.ch.system.service.AdvertisementService;
import com.ch.system.web.facade.dto.ChannelAdvertisementDTO;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * User: Jack Wang
 * Date: 15-3-17
 * Time: 下午2:52
 */
public class ChannelAdvertisementFormController extends SimpleFormController {

    private AdvertisementService advertisementService;

    private String applicationWebAddress;

    public ChannelAdvertisementFormController() {
        setCommandClass(ChannelAdvertisementDTO.class);
        setCommandName("channelAdvertisement");
        setFormView("/backend/ad/channeladvertisementform");
    }

    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {
        int channelAdvertisementId = ServletRequestUtils.getIntParameter(request, "channelAdvertisementId", -1);
        String current = ServletRequestUtils.getStringParameter(request, "current", "");
        request.setAttribute("current", current);
        request.setAttribute("applicationWebAddress", applicationWebAddress);

        if (channelAdvertisementId > 0) {
            return advertisementService.obtainChannelAdvertisementById(channelAdvertisementId);
        }
        return new ChannelAdvertisementDTO();
    }

    @Override
    protected void onBindAndValidate(HttpServletRequest request, Object command, BindException errors) throws Exception {
        String advertisementTitle = ServletRequestUtils.getStringParameter(request, "advertisementTitle", "");
        int advertisementFileId = ServletRequestUtils.getIntParameter(request, "advertisementFileId", -1);
        if (!StringUtils.hasText(advertisementTitle)) {
            errors.rejectValue("advertisementTitle", "channel.ad.title.empty");
        }

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartRequest.getFile("advertisementFile");
        if (advertisementFileId <= 0) {
            if (file == null || file.getSize() == 0) {
                errors.rejectValue("advertisementFile", "channel.ad.file.empty");
            }
        }
    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        String current = ServletRequestUtils.getStringParameter(request, "current", "");

        ChannelAdvertisementDTO dto = (ChannelAdvertisementDTO) command;
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartRequest.getFile("advertisementFile");
        if (file != null && file.getSize() > 0) {
            dto.setAdvertisementFile(file);
        }

        advertisementService.changeChannelAdvertisementDetails(dto);
        return new ModelAndView(new RedirectView("channeladvertisementoverview.html?current="+current));
    }

    public void setAdvertisementService(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }

    public void setApplicationWebAddress(String applicationWebAddress) {
        this.applicationWebAddress = applicationWebAddress;
    }
}
