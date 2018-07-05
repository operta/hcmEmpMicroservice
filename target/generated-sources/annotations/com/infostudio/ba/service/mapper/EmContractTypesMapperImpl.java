package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.EmContractTypes;
import com.infostudio.ba.service.dto.EmContractTypesDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-07-05T15:00:57+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_172 (Oracle Corporation)"
)
@Component
public class EmContractTypesMapperImpl implements EmContractTypesMapper {

    @Override
    public EmContractTypes toEntity(EmContractTypesDTO dto) {
        if ( dto == null ) {
            return null;
        }

        EmContractTypes emContractTypes = new EmContractTypes();

        emContractTypes.setCreatedBy( dto.getCreatedBy() );
        emContractTypes.setCreatedAt( dto.getCreatedAt() );
        emContractTypes.setUpdatedBy( dto.getUpdatedBy() );
        emContractTypes.setUpdatedAt( dto.getUpdatedAt() );
        emContractTypes.setId( dto.getId() );
        emContractTypes.setCode( dto.getCode() );
        emContractTypes.setName( dto.getName() );
        emContractTypes.setDescription( dto.getDescription() );

        return emContractTypes;
    }

    @Override
    public EmContractTypesDTO toDto(EmContractTypes entity) {
        if ( entity == null ) {
            return null;
        }

        EmContractTypesDTO emContractTypesDTO = new EmContractTypesDTO();

        emContractTypesDTO.setId( entity.getId() );
        emContractTypesDTO.setCode( entity.getCode() );
        emContractTypesDTO.setName( entity.getName() );
        emContractTypesDTO.setDescription( entity.getDescription() );
        emContractTypesDTO.setCreatedBy( entity.getCreatedBy() );
        emContractTypesDTO.setCreatedAt( entity.getCreatedAt() );
        emContractTypesDTO.setUpdatedBy( entity.getUpdatedBy() );
        emContractTypesDTO.setUpdatedAt( entity.getUpdatedAt() );

        return emContractTypesDTO;
    }

    @Override
    public List<EmContractTypes> toEntity(List<EmContractTypesDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<EmContractTypes> list = new ArrayList<EmContractTypes>( dtoList.size() );
        for ( EmContractTypesDTO emContractTypesDTO : dtoList ) {
            list.add( toEntity( emContractTypesDTO ) );
        }

        return list;
    }

    @Override
    public List<EmContractTypesDTO> toDto(List<EmContractTypes> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<EmContractTypesDTO> list = new ArrayList<EmContractTypesDTO>( entityList.size() );
        for ( EmContractTypes emContractTypes : entityList ) {
            list.add( toDto( emContractTypes ) );
        }

        return list;
    }
}
