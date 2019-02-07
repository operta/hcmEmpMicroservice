package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.*;
import com.infostudio.ba.service.dto.EmBenefitTypesDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity EmBenefitTypes and its DTO EmBenefitTypesDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface EmBenefitTypesMapper extends EntityMapper<EmBenefitTypesDTO, EmBenefitTypes> {



    default EmBenefitTypes fromId(Long id) {
        if (id == null) {
            return null;
        }
        EmBenefitTypes emBenefitTypes = new EmBenefitTypes();
        emBenefitTypes.setId(id);
        return emBenefitTypes;
    }
}
