package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.*;
import com.infostudio.ba.service.dto.EmEmpBorrowingsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity EmEmpBorrowings and its DTO EmEmpBorrowingsDTO.
 */
@Mapper(componentModel = "spring", uses = {EmEmployeesMapper.class, EmBorrowingTypesMapper.class})
public interface EmEmpBorrowingsMapper extends EntityMapper<EmEmpBorrowingsDTO, EmEmpBorrowings> {

    @Mapping(source = "idEmployee.id", target = "idEmployeeId")
    @Mapping(source = "idBorrowing.id", target = "idBorrowingId")
    @Mapping(source = "idBorrowing.name", target = "idBorrowingName")
    EmEmpBorrowingsDTO toDto(EmEmpBorrowings emEmpBorrowings);

    @Mapping(source = "idEmployeeId", target = "idEmployee")
    @Mapping(source = "idBorrowingId", target = "idBorrowing")
    EmEmpBorrowings toEntity(EmEmpBorrowingsDTO emEmpBorrowingsDTO);

    default EmEmpBorrowings fromId(Long id) {
        if (id == null) {
            return null;
        }
        EmEmpBorrowings emEmpBorrowings = new EmEmpBorrowings();
        emEmpBorrowings.setId(id);
        return emEmpBorrowings;
    }
}
