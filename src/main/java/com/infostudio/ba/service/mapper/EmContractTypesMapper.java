package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.*;
import com.infostudio.ba.service.dto.EmContractTypesDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity EmContractTypes and its DTO EmContractTypesDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface EmContractTypesMapper extends EntityMapper<EmContractTypesDTO, EmContractTypes> {



    default EmContractTypes fromId(Long id) {
        if (id == null) {
            return null;
        }
        EmContractTypes emContractTypes = new EmContractTypes();
        emContractTypes.setId(id);
        return emContractTypes;
    }
}
