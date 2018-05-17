package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.*;
import com.infostudio.ba.service.dto.EmEmpFamiliesDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity EmEmpFamilies and its DTO EmEmpFamiliesDTO.
 */
@Mapper(componentModel = "spring", uses = {EmEmployeesMapper.class})
public interface EmEmpFamiliesMapper extends EntityMapper<EmEmpFamiliesDTO, EmEmpFamilies> {

    @Mapping(source = "idEmployee.id", target = "idEmployeeId")
    EmEmpFamiliesDTO toDto(EmEmpFamilies emEmpFamilies);

    @Mapping(source = "idEmployeeId", target = "idEmployee")
    EmEmpFamilies toEntity(EmEmpFamiliesDTO emEmpFamiliesDTO);

    default EmEmpFamilies fromId(Long id) {
        if (id == null) {
            return null;
        }
        EmEmpFamilies emEmpFamilies = new EmEmpFamilies();
        emEmpFamilies.setId(id);
        return emEmpFamilies;
    }
}
