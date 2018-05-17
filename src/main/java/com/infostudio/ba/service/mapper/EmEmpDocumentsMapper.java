package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.*;
import com.infostudio.ba.service.dto.EmEmpDocumentsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity EmEmpDocuments and its DTO EmEmpDocumentsDTO.
 */
@Mapper(componentModel = "spring", uses = {EmEmployeesMapper.class})
public interface EmEmpDocumentsMapper extends EntityMapper<EmEmpDocumentsDTO, EmEmpDocuments> {

    @Mapping(source = "idEmployee.id", target = "idEmployeeId")
    EmEmpDocumentsDTO toDto(EmEmpDocuments emEmpDocuments);

    @Mapping(source = "idEmployeeId", target = "idEmployee")
    EmEmpDocuments toEntity(EmEmpDocumentsDTO emEmpDocumentsDTO);

    default EmEmpDocuments fromId(Long id) {
        if (id == null) {
            return null;
        }
        EmEmpDocuments emEmpDocuments = new EmEmpDocuments();
        emEmpDocuments.setId(id);
        return emEmpDocuments;
    }
}
