package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.*;
import com.infostudio.ba.service.dto.EmEmpOrgWorkPlacesDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity EmEmpOrgWorkPlaces and its DTO EmEmpOrgWorkPlacesDTO.
 */
@Mapper(componentModel = "spring", uses = {EmEmployeesMapper.class, EmContractTypesMapper.class})
public interface EmEmpOrgWorkPlacesMapper extends EntityMapper<EmEmpOrgWorkPlacesDTO, EmEmpOrgWorkPlaces> {

    @Mapping(source = "idEmployee.id", target = "idEmployeeId")
    @Mapping(source = "idContractType.id", target = "idContractTypeId")
    @Mapping(source = "idContractType.name", target = "idContractTypeName")
    EmEmpOrgWorkPlacesDTO toDto(EmEmpOrgWorkPlaces emEmpOrgWorkPlaces);

    @Mapping(source = "idEmployeeId", target = "idEmployee")
    @Mapping(source = "idContractTypeId", target = "idContractType")
    EmEmpOrgWorkPlaces toEntity(EmEmpOrgWorkPlacesDTO emEmpOrgWorkPlacesDTO);

    default EmEmpOrgWorkPlaces fromId(Long id) {
        if (id == null) {
            return null;
        }
        EmEmpOrgWorkPlaces emEmpOrgWorkPlaces = new EmEmpOrgWorkPlaces();
        emEmpOrgWorkPlaces.setId(id);
        return emEmpOrgWorkPlaces;
    }
}
