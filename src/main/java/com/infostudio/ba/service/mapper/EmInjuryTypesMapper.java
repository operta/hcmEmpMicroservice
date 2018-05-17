package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.*;
import com.infostudio.ba.service.dto.EmInjuryTypesDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity EmInjuryTypes and its DTO EmInjuryTypesDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface EmInjuryTypesMapper extends EntityMapper<EmInjuryTypesDTO, EmInjuryTypes> {



    default EmInjuryTypes fromId(Long id) {
        if (id == null) {
            return null;
        }
        EmInjuryTypes emInjuryTypes = new EmInjuryTypes();
        emInjuryTypes.setId(id);
        return emInjuryTypes;
    }
}
