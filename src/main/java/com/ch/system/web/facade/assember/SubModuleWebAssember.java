package com.ch.system.web.facade.assember;

import com.ch.common.repository.EntityLoadHolder;
import com.ch.system.domain.ModuleAdvertisement;
import com.ch.system.domain.SubModule;
import com.ch.system.web.facade.dto.SubModuleDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Jack Wang
 * Date: 15-3-19
 * Time: 下午4:05
 */
public class SubModuleWebAssember {

    public static SubModule toSubModuleDomain(SubModuleDTO dto) {
        SubModule subModule = null;
        if(dto == null) {
            return null;
        }
        if (dto.getId() > 0) {
            subModule = (SubModule) EntityLoadHolder.getUserDao().findById(dto.getId(), SubModule.class);
            subModule.setId(dto.getId());
            subModule.setSequence(dto.getSequence());
            subModule.setModuleTitle(dto.getModuleTitle());
            subModule.setModuleUrl(dto.getModuleUrl());
            subModule.setModuleDescription(dto.getModuleDescription());
        } else {
            subModule = new SubModule(dto.getModuleTitle(), dto.getModuleUrl(), dto.getModuleDescription());
            ModuleAdvertisement moduleAdvertisement = new ModuleAdvertisement();
            moduleAdvertisement.setId(dto.getModuleId());
            subModule.setModuleAdvertisement(moduleAdvertisement);
        }
        return subModule;
    }

    public static SubModuleDTO toSubModuleDTO(SubModule subModule) {
        final int id = subModule.getId();
        final int sequence = subModule.getSequence();
        final String moduleTitle = subModule.getModuleTitle();
        final String moduleUrl = subModule.getModuleUrl();
        final String moduleDescription = subModule.getModuleDescription();
        final int moduleId = subModule.getModuleAdvertisement().getId();

        SubModuleDTO dto =  new SubModuleDTO(id, sequence, moduleTitle, moduleUrl, moduleDescription, moduleId);
        return dto;
    }

    public static List<SubModuleDTO> toModuleAdvertisementDTOList(List<SubModule> subModules) {
        List<SubModuleDTO> dtos = new ArrayList<SubModuleDTO>();
        if (subModules != null) {
            for (SubModule subModule : subModules) {
                dtos.add(toSubModuleDTO(subModule));
            }
        }
        return dtos;
    }
}
