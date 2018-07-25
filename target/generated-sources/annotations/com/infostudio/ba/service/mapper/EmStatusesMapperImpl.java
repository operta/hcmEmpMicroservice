package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.EmStatuses;
import com.infostudio.ba.service.dto.EmStatusesDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-07-25T10:22:57+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_171 (Oracle Corporation)"
)
@Component
public class EmStatusesMapperImpl implements EmStatusesMapper {

    @Override
    public EmStatuses toEntity(EmStatusesDTO dto) {
        if ( dto == null ) {
            return null;
        }

        EmStatuses emStatuses = new EmStatuses();

        emStatuses.setCreatedBy( dto.getCreatedBy() );
        emStatuses.setCreatedAt( dto.getCreatedAt() );
        emStatuses.setUpdatedBy( dto.getUpdatedBy() );
        emStatuses.setUpdatedAt( dto.getUpdatedAt() );
        emStatuses.setId( dto.getId() );
        emStatuses.setCode( dto.getCode() );
        emStatuses.setName( dto.getName() );
        emStatuses.setDescription( dto.getDescription() );

        return emStatuses;
    }

    @Override
    public EmStatusesDTO toDto(EmStatuses entity) {
        if ( entity == null ) {
            return null;
        }

        EmStatusesDTO emStatusesDTO = new EmStatusesDTO();

        emStatusesDTO.setId( entity.getId() );
        emStatusesDTO.setCode( entity.getCode() );
        emStatusesDTO.setName( entity.getName() );
        emStatusesDTO.setDescription( entity.getDescription() );
        emStatusesDTO.setCreatedBy( entity.getCreatedBy() );
        emStatusesDTO.setCreatedAt( entity.getCreatedAt() );
        emStatusesDTO.setUpdatedBy( entity.getUpdatedBy() );
        emStatusesDTO.setUpdatedAt( entity.getUpdatedAt() );

        return emStatusesDTO;
    }

    @Override
    public List<EmStatuses> toEntity(List<EmStatusesDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<EmStatuses> list = new ArrayList<EmStatuses>( dtoList.size() );
        for ( EmStatusesDTO emStatusesDTO : dtoList ) {
            list.add( toEntity( emStatusesDTO ) );
        }

        return list;
    }

    @Override
    public List<EmStatusesDTO> toDto(List<EmStatuses> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<EmStatusesDTO> list = new ArrayList<EmStatusesDTO>( entityList.size() );
        for ( EmStatuses emStatuses : entityList ) {
            list.add( toDto( emStatuses ) );
        }

        return list;
    }
}
