package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.*;
import com.infostudio.ba.service.dto.EmBorrowingTypesDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity EmBorrowingTypes and its DTO EmBorrowingTypesDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface EmBorrowingTypesMapper extends EntityMapper<EmBorrowingTypesDTO, EmBorrowingTypes> {



    default EmBorrowingTypes fromId(Long id) {
        if (id == null) {
            return null;
        }
        EmBorrowingTypes emBorrowingTypes = new EmBorrowingTypes();
        emBorrowingTypes.setId(id);
        return emBorrowingTypes;
    }
}
