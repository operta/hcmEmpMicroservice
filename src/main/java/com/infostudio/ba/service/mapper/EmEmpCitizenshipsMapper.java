package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.*;
import com.infostudio.ba.service.dto.EmEmpCitizenshipsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity EmEmpCitizenships and its DTO EmEmpCitizenshipsDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface EmEmpCitizenshipsMapper extends EntityMapper<EmEmpCitizenshipsDTO, EmEmpCitizenships> {



    default EmEmpCitizenships fromId(Long id) {
        if (id == null) {
            return null;
        }
        EmEmpCitizenships emEmpCitizenships = new EmEmpCitizenships();
        emEmpCitizenships.setId(id);
        return emEmpCitizenships;
    }
}
