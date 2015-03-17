package com.ch.system.web.facade.assember;

import com.ch.common.repository.EntityLoadHolder;
import com.ch.system.domain.OpenAdvertisement;
import com.ch.system.web.facade.dto.OpenAdvertisementDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Jack Wang
 * Date: 15-3-17
 * Time: 下午1:48
 */
public class OpenAdvertisementWebAssember {

    public static OpenAdvertisement toOpenAdvertisementDomain(OpenAdvertisementDTO dto) {
        OpenAdvertisement openAdvertisement = null;
        if(dto == null) {
            return null;
        }
        if (dto.getId() > 0) {
            openAdvertisement = (OpenAdvertisement) EntityLoadHolder.getUserDao().findById(dto.getId(), OpenAdvertisement.class);
            openAdvertisement.setId(dto.getId());
            openAdvertisement.setIndex(dto.getIndex());
            openAdvertisement.setTitle(dto.getTitle());
            openAdvertisement.setUrl(dto.getUrl());

        } else {
            openAdvertisement = new OpenAdvertisement(dto.getIndex(), dto.getTitle(), dto.getUrl());
        }
        return openAdvertisement;
    }

    public static OpenAdvertisementDTO toOpenAdvertisementDTO(OpenAdvertisement openAdvertisement) {
        final int id = openAdvertisement.getId();
        final int index = openAdvertisement.getIndex();
        final String title = openAdvertisement.getTitle();
        final String url = openAdvertisement.getUrl();

        OpenAdvertisementDTO dto =  new OpenAdvertisementDTO(id, index, title, url);
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
