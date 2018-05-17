package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.*;
import com.infostudio.ba.service.dto.EmStatusesDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity EmStatuses and its DTO EmStatusesDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface EmStatusesMapper extends EntityMapper<EmStatusesDTO, EmStatuses> {



    default EmStatuses fromId(Long id) {
        if (id == null) {
            return null;
        }
        EmStatuses emStatuses = new EmStatuses();
        emStatuses.setId(id);
        return emStatuses;
    }
}
