package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.*;
import com.infostudio.ba.service.dto.EmEmpSkillsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity EmEmpSkills and its DTO EmEmpSkillsDTO.
 */
@Mapper(componentModel = "spring", uses = {EmEmployeesMapper.class})
public interface EmEmpSkillsMapper extends EntityMapper<EmEmpSkillsDTO, EmEmpSkills> {

    @Mapping(source = "idEmployee.id", target = "idEmployeeId")
    EmEmpSkillsDTO toDto(EmEmpSkills emEmpSkills);

    @Mapping(source = "idEmployeeId", target = "idEmployee")
    EmEmpSkills toEntity(EmEmpSkillsDTO emEmpSkillsDTO);

    default EmEmpSkills fromId(Long id) {
        if (id == null) {
            return null;
        }
        EmEmpSkills emEmpSkills = new EmEmpSkills();
        emEmpSkills.setId(id);
        return emEmpSkills;
    }
}
