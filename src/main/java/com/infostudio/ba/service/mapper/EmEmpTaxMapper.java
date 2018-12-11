package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.*;
import com.infostudio.ba.service.dto.EmEmpTaxDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity EmEmpTax and its DTO EmEmpTaxDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface EmEmpTaxMapper extends EntityMapper<EmEmpTaxDTO, EmEmpTax> {



    default EmEmpTax fromId(Long id) {
        if (id == null) {
            return null;
        }
        EmEmpTax emEmpTax = new EmEmpTax();
        emEmpTax.setId(id);
        return emEmpTax;
    }
}
