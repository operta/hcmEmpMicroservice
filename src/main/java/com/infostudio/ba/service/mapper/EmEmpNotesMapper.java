package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.*;
import com.infostudio.ba.service.dto.EmEmpNotesDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity EmEmpNotes and its DTO EmEmpNotesDTO.
 */
@Mapper(componentModel = "spring", uses = {EmEmployeesMapper.class})
public interface EmEmpNotesMapper extends EntityMapper<EmEmpNotesDTO, EmEmpNotes> {

    @Mapping(source = "idEmployee.id", target = "idEmployeeId")
    EmEmpNotesDTO toDto(EmEmpNotes emEmpNotes);

    @Mapping(source = "idEmployeeId", target = "idEmployee")
    EmEmpNotes toEntity(EmEmpNotesDTO emEmpNotesDTO);

    default EmEmpNotes fromId(Long id) {
        if (id == null) {
            return null;
        }
        EmEmpNotes emEmpNotes = new EmEmpNotes();
        emEmpNotes.setId(id);
        return emEmpNotes;
    }
}
