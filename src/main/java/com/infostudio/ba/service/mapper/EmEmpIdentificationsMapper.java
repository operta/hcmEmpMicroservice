package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.*;
import com.infostudio.ba.service.dto.EmEmpIdentificationsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity EmEmpIdentifications and its DTO EmEmpIdentificationsDTO.
 */
@Mapper(componentModel = "spring", uses = {EmEmployeesMapper.class})
public interface EmEmpIdentificationsMapper extends EntityMapper<EmEmpIdentificationsDTO, EmEmpIdentifications> {

    @Mapping(source = "idEmployee.id", target = "idEmployeeId")
    EmEmpIdentificationsDTO toDto(EmEmpIdentifications emEmpIdentifications);

    @Mapping(source = "idEmployeeId", target = "idEmployee")
    EmEmpIdentifications toEntity(EmEmpIdentificationsDTO emEmpIdentificationsDTO);

    default EmEmpIdentifications fromId(Long id) {
        if (id == null) {
            return null;
        }
        EmEmpIdentifications emEmpIdentifications = new EmEmpIdentifications();
        emEmpIdentifications.setId(id);
        return emEmpIdentifications;
    }
}
