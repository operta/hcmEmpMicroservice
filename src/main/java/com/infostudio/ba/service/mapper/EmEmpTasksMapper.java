package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.*;
import com.infostudio.ba.service.dto.EmEmpTasksDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity EmEmpTasks and its DTO EmEmpTasksDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface EmEmpTasksMapper extends EntityMapper<EmEmpTasksDTO, EmEmpTasks> {



    default EmEmpTasks fromId(Long id) {
        if (id == null) {
            return null;
        }
        EmEmpTasks emEmpTasks = new EmEmpTasks();
        emEmpTasks.setId(id);
        return emEmpTasks;
    }
}
