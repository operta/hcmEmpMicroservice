package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.*;
import com.infostudio.ba.service.dto.EmEmpAccomplishmentsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity EmEmpAccomplishments and its DTO EmEmpAccomplishmentsDTO.
 */
@Mapper(componentModel = "spring", uses = {EmEmployeesMapper.class})
public interface EmEmpAccomplishmentsMapper extends EntityMapper<EmEmpAccomplishmentsDTO, EmEmpAccomplishments> {

    @Mapping(source = "idEmployee.id", target = "idEmployeeId")
    EmEmpAccomplishmentsDTO toDto(EmEmpAccomplishments emEmpAccomplishments);

    @Mapping(source = "idEmployeeId", target = "idEmployee")
    EmEmpAccomplishments toEntity(EmEmpAccomplishmentsDTO emEmpAccomplishmentsDTO);

    default EmEmpAccomplishments fromId(Long id) {
        if (id == null) {
            return null;
        }
        EmEmpAccomplishments emEmpAccomplishments = new EmEmpAccomplishments();
        emEmpAccomplishments.setId(id);
        return emEmpAccomplishments;
    }
}
