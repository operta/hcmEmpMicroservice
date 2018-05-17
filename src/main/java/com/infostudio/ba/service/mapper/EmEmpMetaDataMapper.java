package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.*;
import com.infostudio.ba.service.dto.EmEmpMetaDataDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity EmEmpMetaData and its DTO EmEmpMetaDataDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface EmEmpMetaDataMapper extends EntityMapper<EmEmpMetaDataDTO, EmEmpMetaData> {



    default EmEmpMetaData fromId(Long id) {
        if (id == null) {
            return null;
        }
        EmEmpMetaData emEmpMetaData = new EmEmpMetaData();
        emEmpMetaData.setId(id);
        return emEmpMetaData;
    }
}
