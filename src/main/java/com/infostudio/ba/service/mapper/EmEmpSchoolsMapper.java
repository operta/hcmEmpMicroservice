package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.*;
import com.infostudio.ba.service.dto.EmEmpSchoolsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity EmEmpSchools and its DTO EmEmpSchoolsDTO.
 */
@Mapper(componentModel = "spring", uses = {EmEmployeesMapper.class})
public interface EmEmpSchoolsMapper extends EntityMapper<EmEmpSchoolsDTO, EmEmpSchools> {

    @Mapping(source = "idEmployee.id", target = "idEmployeeId")
    EmEmpSchoolsDTO toDto(EmEmpSchools emEmpSchools);

    @Mapping(source = "idEmployeeId", target = "idEmployee")
    EmEmpSchools toEntity(EmEmpSchoolsDTO emEmpSchoolsDTO);

    default EmEmpSchools fromId(Long id) {
        if (id == null) {
            return null;
        }
        EmEmpSchools emEmpSchools = new EmEmpSchools();
        emEmpSchools.setId(id);
        return emEmpSchools;
    }
}
