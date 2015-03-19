package com.ch.system.web.facade.assember;

import com.ch.common.repository.EntityLoadHolder;
import com.ch.system.domain.AdvertisementFile;
import com.ch.system.domain.ModuleAdvertisement;
import com.ch.system.web.facade.dto.ModuleAdvertisementDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Jack Wang
 * Date: 15-3-18
 * Time: 下午4:48
 */
public class ModuleAdvertisementWebAssember {

    public static ModuleAdvertisement toModuleAdvertisementDomain(ModuleAdvertisementDTO dto) {
        ModuleAdvertisement moduleAdvertisement = null;
        if(dto == null) {
            return null;
        }
        if (dto.getId() > 0) {
            moduleAdvertisement = (ModuleAdvertisement) EntityLoadHolder.getUserDao().findById(dto.getId(), ModuleAdvertisement.class);
            moduleAdvertisement.setId(dto.getId());
            moduleAdvertisement.setSequence(dto.getSequence());
            moduleAdvertisement.setIncludeSub(dto.isIncludeSub());
            moduleAdvertisement.setModuleTitle(dto.getModuleTitle());
            moduleAdvertisement.setModuleUrl(dto.getModuleUrl());
            moduleAdvertisement.setModuleDescription(dto.getModuleDescription());
        } else {
            moduleAdvertisement = new ModuleAdvertisement(dto.getSequence(), dto.isIncludeSub(), dto.getModuleTitle(), dto.getModuleUrl(), dto.getModuleDescription());
        }
        return moduleAdvertisement;
    }

    public static ModuleAdvertisementDTO toModuleAdvertisementDTO(ModuleAdvertisement moduleAdvertisement) {
        final int id = moduleAdvertisement.getId();
        final int sequence = moduleAdvertisement.getSequence();
        final boolean includeSub = moduleAdvertisement.isIncludeSub();
        final String moduleTitle = moduleAdvertisement.getModuleTitle();
        final String moduleUrl = moduleAdvertisement.getModuleUrl();
        final String moduleDescription = moduleAdvertisement.getModuleDescription();

        ModuleAdvertisementDTO dto =  new ModuleAdvertisementDTO(id, sequence, includeSub, moduleTitle, moduleUrl, moduleDescription);
        return dto;
    }

    public static List<ModuleAdvertisementDTO> toModuleAdvertisementDTOList(List<ModuleAdvertisement> moduleAdvertisements) {
        List<ModuleAdvertisementDTO> dtos = new ArrayList<ModuleAdvertisementDTO>();
        if (moduleAdvertisements != null) {
            for (ModuleAdvertisement openAdvertisement : moduleAdvertisements) {
                dtos.add(toModuleAdvertisementDTO(openAdvertisement));
            }
        }
        return dtos;
    }
}
