package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.*;
import com.infostudio.ba.service.dto.EmEmpInjuriesDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity EmEmpInjuries and its DTO EmEmpInjuriesDTO.
 */
@Mapper(componentModel = "spring", uses = {EmEmployeesMapper.class, EmInjuryTypesMapper.class})
public interface EmEmpInjuriesMapper extends EntityMapper<EmEmpInjuriesDTO, EmEmpInjuries> {

    @Mapping(source = "idEmployee.id", target = "idEmployeeId")
    @Mapping(source = "idInjury.id", target = "idInjuryId")
    @Mapping(source = "idInjury.name", target = "idInjuryName")
    EmEmpInjuriesDTO toDto(EmEmpInjuries emEmpInjuries);

    @Mapping(source = "idEmployeeId", target = "idEmployee")
    @Mapping(source = "idInjuryId", target = "idInjury")
    EmEmpInjuries toEntity(EmEmpInjuriesDTO emEmpInjuriesDTO);

    default EmEmpInjuries fromId(Long id) {
        if (id == null) {
            return null;
        }
        EmEmpInjuries emEmpInjuries = new EmEmpInjuries();
        emEmpInjuries.setId(id);
        return emEmpInjuries;
    }
}
