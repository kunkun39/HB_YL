package com.ch.system.web.facade.assember;

import com.ch.common.repository.EntityLoadHolder;
import com.ch.system.domain.AdvertisementFile;
import com.ch.system.domain.BannerAdvertisement;
import com.ch.system.domain.OpenAdvertisement;
import com.ch.system.web.facade.dto.BannerAdvertisementDTO;
import com.ch.system.web.facade.dto.OpenAdvertisementDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Jack Wang
 * Date: 15-3-17
 * Time: 下午1:48
 */
public class BannerAdvertisementWebAssember {

    public static AdvertisementFile toAdvertisementFileDomain(MultipartFile file) {
        return new AdvertisementFile(file);
    }

    public static BannerAdvertisement toBannerAdvertisementDomain(BannerAdvertisementDTO dto) {
        BannerAdvertisement bannerAdvertisement = null;
        if (dto == null) {
            return null;
        }
        if (dto.getId() > 0) {
            bannerAdvertisement = (BannerAdvertisement) EntityLoadHolder.getUserDao().findById(dto.getId(), BannerAdvertisement.class);
            bannerAdvertisement.setId(dto.getId());
            bannerAdvertisement.setSequence(dto.getSequence());
            bannerAdvertisement.setServiceId(dto.getServiceId());
            bannerAdvertisement.setAdvertisememtTitle(dto.getAdvertisementTitle());
        } else {
            bannerAdvertisement = new BannerAdvertisement(dto.getSequence(), dto.getAdvertisementTitle(), dto.getServiceId());
        }
        return bannerAdvertisement;
    }

    public static BannerAdvertisementDTO toBannerAdvertisementDTO(BannerAdvertisement bannerAdvertisement) {
        final int id = bannerAdvertisement.getId();
        final int sequence = bannerAdvertisement.getSequence();
        final String serviceId = bannerAdvertisement.getServiceId();
        final String advertisementTitle = bannerAdvertisement.getAdvertisememtTitle();

        AdvertisementFile file = bannerAdvertisement.getAdvertisementFile();
        final int advertisementFileId = file != null ? file.getId() : -1;
        final String advertisementUploadFileName = file != null ? file.getUploadFileName() : "";
        final String advertisementActualFileName = file != null ? file.getActualFileName() : "";

        BannerAdvertisementDTO dto = new BannerAdvertisementDTO(id, sequence, advertisementTitle,
                advertisementFileId, serviceId, advertisementUploadFileName, advertisementActualFileName);
        return dto;
    }

    public static List<BannerAdvertisementDTO> toBannerAdvertisementDTOList(List<BannerAdvertisement> bannerAdvertisements) {
        List<BannerAdvertisementDTO> dtos = new ArrayList<BannerAdvertisementDTO>();
        if (bannerAdvertisements != null) {
            for (BannerAdvertisement bannerAdvertisement : bannerAdvertisements) {
                dtos.add(toBannerAdvertisementDTO(bannerAdvertisement));
            }
        }
        return dtos;
    }
}
