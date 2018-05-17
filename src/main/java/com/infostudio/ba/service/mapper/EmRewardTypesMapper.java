package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.*;
import com.infostudio.ba.service.dto.EmRewardTypesDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity EmRewardTypes and its DTO EmRewardTypesDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface EmRewardTypesMapper extends EntityMapper<EmRewardTypesDTO, EmRewardTypes> {



    default EmRewardTypes fromId(Long id) {
        if (id == null) {
            return null;
        }
        EmRewardTypes emRewardTypes = new EmRewardTypes();
        emRewardTypes.setId(id);
        return emRewardTypes;
    }
}
