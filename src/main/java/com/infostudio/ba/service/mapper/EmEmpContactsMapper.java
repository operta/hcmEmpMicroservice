package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.*;
import com.infostudio.ba.service.dto.EmEmpContactsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity EmEmpContacts and its DTO EmEmpContactsDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface EmEmpContactsMapper extends EntityMapper<EmEmpContactsDTO, EmEmpContacts> {



    default EmEmpContacts fromId(Long id) {
        if (id == null) {
            return null;
        }
        EmEmpContacts emEmpContacts = new EmEmpContacts();
        emEmpContacts.setId(id);
        return emEmpContacts;
    }
}
