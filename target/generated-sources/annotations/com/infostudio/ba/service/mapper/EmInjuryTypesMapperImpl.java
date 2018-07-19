package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.EmInjuryTypes;
import com.infostudio.ba.service.dto.EmInjuryTypesDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-07-19T14:01:55+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
)
@Component
public class EmInjuryTypesMapperImpl implements EmInjuryTypesMapper {

    @Override
    public EmInjuryTypes toEntity(EmInjuryTypesDTO dto) {
        if ( dto == null ) {
            return null;
        }

        EmInjuryTypes emInjuryTypes = new EmInjuryTypes();

        emInjuryTypes.setCreatedBy( dto.getCreatedBy() );
        emInjuryTypes.setCreatedAt( dto.getCreatedAt() );
        emInjuryTypes.setUpdatedBy( dto.getUpdatedBy() );
        emInjuryTypes.setUpdatedAt( dto.getUpdatedAt() );
        emInjuryTypes.setId( dto.getId() );
        emInjuryTypes.setCode( dto.getCode() );
        emInjuryTypes.setName( dto.getName() );
        emInjuryTypes.setDescription( dto.getDescription() );

        return emInjuryTypes;
    }

    @Override
    public EmInjuryTypesDTO toDto(EmInjuryTypes entity) {
        if ( entity == null ) {
            return null;
        }

        EmInjuryTypesDTO emInjuryTypesDTO = new EmInjuryTypesDTO();

        emInjuryTypesDTO.setId( entity.getId() );
        emInjuryTypesDTO.setCode( entity.getCode() );
        emInjuryTypesDTO.setName( entity.getName() );
        emInjuryTypesDTO.setDescription( entity.getDescription() );
        emInjuryTypesDTO.setCreatedBy( entity.getCreatedBy() );
        emInjuryTypesDTO.setCreatedAt( entity.getCreatedAt() );
        emInjuryTypesDTO.setUpdatedBy( entity.getUpdatedBy() );
        emInjuryTypesDTO.setUpdatedAt( entity.getUpdatedAt() );

        return emInjuryTypesDTO;
    }

    @Override
    public List<EmInjuryTypes> toEntity(List<EmInjuryTypesDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<EmInjuryTypes> list = new ArrayList<EmInjuryTypes>( dtoList.size() );
        for ( EmInjuryTypesDTO emInjuryTypesDTO : dtoList ) {
            list.add( toEntity( emInjuryTypesDTO ) );
        }

        return list;
    }

    @Override
    public List<EmInjuryTypesDTO> toDto(List<EmInjuryTypes> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<EmInjuryTypesDTO> list = new ArrayList<EmInjuryTypesDTO>( entityList.size() );
        for ( EmInjuryTypes emInjuryTypes : entityList ) {
            list.add( toDto( emInjuryTypes ) );
        }

        return list;
    }
}
