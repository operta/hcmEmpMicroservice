package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.*;
import com.infostudio.ba.service.dto.EmEmpResidencesDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity EmEmpResidences and its DTO EmEmpResidencesDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface EmEmpResidencesMapper extends EntityMapper<EmEmpResidencesDTO, EmEmpResidences> {



    default EmEmpResidences fromId(Long id) {
        if (id == null) {
            return null;
        }
        EmEmpResidences emEmpResidences = new EmEmpResidences();
        emEmpResidences.setId(id);
        return emEmpResidences;
    }
}
