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
            moduleAdvertisement.setAdvertisememtTitle(dto.getAdvertisementTitle());
        } else {
            moduleAdvertisement = new ModuleAdvertisement(dto.getSequence(), dto.getAdvertisementTitle());
        }
        return moduleAdvertisement;
    }

    public static ModuleAdvertisementDTO toModuleAdvertisementDTO(ModuleAdvertisement moduleAdvertisement) {
        final int id = moduleAdvertisement.getId();
        final int sequence = moduleAdvertisement.getSequence();
        final String advertisementTitle = moduleAdvertisement.getAdvertisememtTitle();

        AdvertisementFile file = moduleAdvertisement.getAdvertisementFile();
        final int advertisementFileId = file != null ? file.getId() : -1;
        final String advertisementUploadFileName = file != null ? file.getUploadFileName() : "";
        final String advertisementActualFileName = file != null ? file.getActualFileName() : "";

        ModuleAdvertisementDTO dto =  new ModuleAdvertisementDTO(id, sequence, advertisementTitle,
                advertisementFileId, advertisementUploadFileName, advertisementActualFileName);
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
