package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.*;
import com.infostudio.ba.service.dto.EmEmpPreviousJobsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity EmEmpPreviousJobs and its DTO EmEmpPreviousJobsDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface EmEmpPreviousJobsMapper extends EntityMapper<EmEmpPreviousJobsDTO, EmEmpPreviousJobs> {



    default EmEmpPreviousJobs fromId(Long id) {
        if (id == null) {
            return null;
        }
        EmEmpPreviousJobs emEmpPreviousJobs = new EmEmpPreviousJobs();
        emEmpPreviousJobs.setId(id);
        return emEmpPreviousJobs;
    }
}
