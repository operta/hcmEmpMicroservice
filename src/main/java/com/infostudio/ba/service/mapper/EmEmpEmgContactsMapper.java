package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.*;
import com.infostudio.ba.service.dto.EmEmpEmgContactsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity EmEmpEmgContacts and its DTO EmEmpEmgContactsDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface EmEmpEmgContactsMapper extends EntityMapper<EmEmpEmgContactsDTO, EmEmpEmgContacts> {



    default EmEmpEmgContacts fromId(Long id) {
        if (id == null) {
            return null;
        }
        EmEmpEmgContacts emEmpEmgContacts = new EmEmpEmgContacts();
        emEmpEmgContacts.setId(id);
        return emEmpEmgContacts;
    }
}
