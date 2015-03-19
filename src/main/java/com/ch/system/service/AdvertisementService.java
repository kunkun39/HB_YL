package com.ch.system.service;

import com.ch.system.web.facade.dto.ModuleAdvertisementDTO;
import com.ch.system.web.facade.dto.OpenAdvertisementDTO;
import com.ch.system.web.facade.dto.SubModuleDTO;

import java.util.List;

/**
 * User: Jack Wang
 * Date: 15-3-17
 * Time: 下午1:45
 */
public interface AdvertisementService {

    /*************************开机广告部分******************************/

    List<OpenAdvertisementDTO> obtainOpenAdvertisements(int startPosition, int pageSize);

    int obtainOpenAdvertisementSize();

    OpenAdvertisementDTO obtainOpenAdvertisementById(int openAdvertisementId);

    void changeOpenAdvertisementDetails(OpenAdvertisementDTO dto);

    void deleteOpenAdvertisement(int openAdvertisementId);

    /*************************八大模块部分******************************/

    List<ModuleAdvertisementDTO> obtainModuleAdvertisements();

    ModuleAdvertisementDTO obtainModuleAdvertisementById(int moduleAdvertisementId);

    void changeModuleAdvertisementDetails(ModuleAdvertisementDTO dto);

    List<SubModuleDTO> obtainSubModules(int moduleAdvertisementId, int startPosition, int pageSize);

    int obtainSubModuleSize(int moduleAdvertisementId);

    SubModuleDTO obtainSubModuleById(int subModuleId);

    void changeSubModuleDetails(SubModuleDTO dto);

    void deleteSubModule(int subModuleId);
}
