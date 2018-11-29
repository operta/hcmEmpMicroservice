package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.*;
import com.infostudio.ba.service.dto.EmEmpPreviousJobsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity EmEmpPreviousJobs and its DTO EmEmpPreviousJobsDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface EmEmpPreviousJobsMapper extends EntityMapper<EmEmpPreviousJobsDTO, EmEmpPreviousJobs> {

    @Mapping(source = "idEmployee.id", target= "idEmployeeId")
    @Mapping(source = "idEmployee.name", target = "idEmployeeName")
    EmEmpPreviousJobsDTO toDto(EmEmpPreviousJobs emEmpPreviousJobs);

    @Mapping(source = "idEmployeeId", target = "idEmployee.id")
    EmEmpPreviousJobs toEntity(EmEmpPreviousJobsDTO emEmpPreviousJobsDTO);

    default EmEmpPreviousJobs fromId(Long id) {
        if (id == null) {
            return null;
        }
        EmEmpPreviousJobs emEmpPreviousJobs = new EmEmpPreviousJobs();
        emEmpPreviousJobs.setId(id);
        return emEmpPreviousJobs;
    }
}
