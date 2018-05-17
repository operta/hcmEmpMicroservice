package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.*;
import com.infostudio.ba.service.dto.EmPenaltiesDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity EmPenalties and its DTO EmPenaltiesDTO.
 */
@Mapper(componentModel = "spring", uses = {EmEmployeesMapper.class})
public interface EmPenaltiesMapper extends EntityMapper<EmPenaltiesDTO, EmPenalties> {

    @Mapping(source = "idEmployee.id", target = "idEmployeeId")
    EmPenaltiesDTO toDto(EmPenalties emPenalties);

    @Mapping(source = "idEmployeeId", target = "idEmployee")
    EmPenalties toEntity(EmPenaltiesDTO emPenaltiesDTO);

    default EmPenalties fromId(Long id) {
        if (id == null) {
            return null;
        }
        EmPenalties emPenalties = new EmPenalties();
        emPenalties.setId(id);
        return emPenalties;
    }
}
