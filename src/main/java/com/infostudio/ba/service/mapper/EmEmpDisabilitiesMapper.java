package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.*;
import com.infostudio.ba.service.dto.EmEmpDisabilitiesDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity EmEmpDisabilities and its DTO EmEmpDisabilitiesDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface EmEmpDisabilitiesMapper extends EntityMapper<EmEmpDisabilitiesDTO, EmEmpDisabilities> {



    default EmEmpDisabilities fromId(Long id) {
        if (id == null) {
            return null;
        }
        EmEmpDisabilities emEmpDisabilities = new EmEmpDisabilities();
        emEmpDisabilities.setId(id);
        return emEmpDisabilities;
    }
}
