package com.ch.system.web.facade.assember;

import com.ch.common.repository.EntityLoadHolder;
import com.ch.system.domain.AdvertisementFile;
import com.ch.system.domain.ChannelAdvertisement;
import com.ch.system.web.facade.dto.ChannelAdvertisementDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Jack Wang
 * Date: 15-3-17
 * Time: 下午1:48
 */
public class ChannelAdvertisementWebAssember {

    public static AdvertisementFile toAdvertisementFileDomain(MultipartFile file) {
        return new AdvertisementFile(file);
    }

    public static ChannelAdvertisement toChannelAdvertisementDomain(ChannelAdvertisementDTO dto) {
        ChannelAdvertisement ChannelAdvertisement = null;
        if(dto == null) {
            return null;
        }
        if (dto.getId() > 0) {
            ChannelAdvertisement = (ChannelAdvertisement) EntityLoadHolder.getUserDao().findById(dto.getId(), ChannelAdvertisement.class);
            ChannelAdvertisement.setId(dto.getId());
            ChannelAdvertisement.setSequence(dto.getSequence());
            ChannelAdvertisement.setAdvertisememtTitle(dto.getAdvertisementTitle());
        } else {
            ChannelAdvertisement = new ChannelAdvertisement(dto.getSequence(), dto.getAdvertisementTitle());
        }
        return ChannelAdvertisement;
    }

    public static ChannelAdvertisementDTO toChannelAdvertisementDTO(ChannelAdvertisement ChannelAdvertisement) {
        final int id = ChannelAdvertisement.getId();
        final int sequence = ChannelAdvertisement.getSequence();
        final String advertisementTitle = ChannelAdvertisement.getAdvertisememtTitle();

        AdvertisementFile file = ChannelAdvertisement.getAdvertisementFile();
        final int advertisementFileId = file != null ? file.getId() : -1;
        final String advertisementUploadFileName = file != null ? file.getUploadFileName() : "";
        final String advertisementActualFileName = file != null ? file.getActualFileName() : "";

        ChannelAdvertisementDTO dto =  new ChannelAdvertisementDTO(id, sequence, advertisementTitle,
                advertisementFileId, advertisementUploadFileName, advertisementActualFileName);
        return dto;
    }

    public static List<ChannelAdvertisementDTO> toChannelAdvertisementDTOList(List<ChannelAdvertisement> ChannelAdvertisements) {
        List<ChannelAdvertisementDTO> dtos = new ArrayList<ChannelAdvertisementDTO>();
        if (ChannelAdvertisements != null) {
            for (ChannelAdvertisement ChannelAdvertisement : ChannelAdvertisements) {
                dtos.add(toChannelAdvertisementDTO(ChannelAdvertisement));
            }
        }
        return dtos;
    }
}
