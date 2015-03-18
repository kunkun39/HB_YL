package com.ch.system.web.facade.assember;

import com.ch.common.repository.EntityLoadHolder;
import com.ch.system.domain.AdvertisementFile;
import com.ch.system.domain.OpenAdvertisement;
import com.ch.system.web.facade.dto.OpenAdvertisementDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Jack Wang
 * Date: 15-3-17
 * Time: 下午1:48
 */
public class OpenAdvertisementWebAssember {

    public static AdvertisementFile toAdvertisementFileDomain(MultipartFile file) {
        return new AdvertisementFile(file);
    }

    public static OpenAdvertisement toOpenAdvertisementDomain(OpenAdvertisementDTO dto) {
        OpenAdvertisement openAdvertisement = null;
        if(dto == null) {
            return null;
        }
        if (dto.getId() > 0) {
            openAdvertisement = (OpenAdvertisement) EntityLoadHolder.getUserDao().findById(dto.getId(), OpenAdvertisement.class);
            openAdvertisement.setId(dto.getId());
            openAdvertisement.setSequence(dto.getSequence());
            openAdvertisement.setAdvertisememtTitle(dto.getAdvertisementTitle());
        } else {
            openAdvertisement = new OpenAdvertisement(dto.getSequence(), dto.getAdvertisementTitle());
        }
        return openAdvertisement;
    }

    public static OpenAdvertisementDTO toOpenAdvertisementDTO(OpenAdvertisement openAdvertisement) {
        final int id = openAdvertisement.getId();
        final int sequence = openAdvertisement.getSequence();
        final String advertisementTitle = openAdvertisement.getAdvertisememtTitle();

        AdvertisementFile file = openAdvertisement.getAdvertisementFile();
        final int advertisementFileId = file != null ? file.getId() : -1;
        final String advertisementUploadFileName = file != null ? file.getUploadFileName() : "";
        final String advertisementActualFileName = file != null ? file.getActualFileName() : "";

        OpenAdvertisementDTO dto =  new OpenAdvertisementDTO(id, sequence, advertisementTitle,
                advertisementFileId, advertisementUploadFileName, advertisementActualFileName);
        return dto;
    }

    public static List<OpenAdvertisementDTO> toOpenAdvertisementDTOList(List<OpenAdvertisement> openAdvertisements) {
        List<OpenAdvertisementDTO> dtos = new ArrayList<OpenAdvertisementDTO>();
        if (openAdvertisements != null) {
            for (OpenAdvertisement openAdvertisement : openAdvertisements) {
                dtos.add(toOpenAdvertisementDTO(openAdvertisement));
            }
        }
        return dtos;
    }
}
