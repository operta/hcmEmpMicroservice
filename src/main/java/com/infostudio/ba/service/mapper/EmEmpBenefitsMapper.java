package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.*;
import com.infostudio.ba.service.dto.EmEmpBenefitsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity EmEmpBenefits and its DTO EmEmpBenefitsDTO.
 */
@Mapper(componentModel = "spring", uses = {EmEmployeesMapper.class, EmBenefitTypesMapper.class})
public interface EmEmpBenefitsMapper extends EntityMapper<EmEmpBenefitsDTO, EmEmpBenefits> {

    @Mapping(source = "emEmployees.id", target = "emEmployeesId")
    @Mapping(source = "emBenefitTypes.id", target = "emBenefitTypesId")
    EmEmpBenefitsDTO toDto(EmEmpBenefits emEmpBenefits);

    @Mapping(source = "emEmployeesId", target = "emEmployees")
    @Mapping(source = "emBenefitTypesId", target = "emBenefitTypes")
    EmEmpBenefits toEntity(EmEmpBenefitsDTO emEmpBenefitsDTO);

    default EmEmpBenefits fromId(Long id) {
        if (id == null) {
            return null;
        }
        EmEmpBenefits emEmpBenefits = new EmEmpBenefits();
        emEmpBenefits.setId(id);
        return emEmpBenefits;
    }
}
