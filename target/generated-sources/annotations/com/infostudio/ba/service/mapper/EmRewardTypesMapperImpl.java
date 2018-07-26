package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.EmRewardTypes;
import com.infostudio.ba.service.dto.EmRewardTypesDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-07-26T11:29:24+0200",
    comments = "version: 1.2.0.Final, compiler: Eclipse JDT (IDE) 1.3.200.v20180612-0641, environment: Java 1.8.0_151 (Oracle Corporation)"
)
@Component
public class EmRewardTypesMapperImpl implements EmRewardTypesMapper {

    @Override
    public EmRewardTypes toEntity(EmRewardTypesDTO dto) {
        if ( dto == null ) {
            return null;
        }

        EmRewardTypes emRewardTypes = new EmRewardTypes();

        emRewardTypes.setCreatedBy( dto.getCreatedBy() );
        emRewardTypes.setCreatedAt( dto.getCreatedAt() );
        emRewardTypes.setUpdatedBy( dto.getUpdatedBy() );
        emRewardTypes.setUpdatedAt( dto.getUpdatedAt() );
        emRewardTypes.setId( dto.getId() );
        emRewardTypes.setCode( dto.getCode() );
        emRewardTypes.setName( dto.getName() );
        emRewardTypes.setDescription( dto.getDescription() );

        return emRewardTypes;
    }

    @Override
    public EmRewardTypesDTO toDto(EmRewardTypes entity) {
        if ( entity == null ) {
            return null;
        }

        EmRewardTypesDTO emRewardTypesDTO = new EmRewardTypesDTO();

        emRewardTypesDTO.setId( entity.getId() );
        emRewardTypesDTO.setCode( entity.getCode() );
        emRewardTypesDTO.setName( entity.getName() );
        emRewardTypesDTO.setDescription( entity.getDescription() );
        emRewardTypesDTO.setCreatedBy( entity.getCreatedBy() );
        emRewardTypesDTO.setCreatedAt( entity.getCreatedAt() );
        emRewardTypesDTO.setUpdatedBy( entity.getUpdatedBy() );
        emRewardTypesDTO.setUpdatedAt( entity.getUpdatedAt() );

        return emRewardTypesDTO;
    }

    @Override
    public List<EmRewardTypes> toEntity(List<EmRewardTypesDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<EmRewardTypes> list = new ArrayList<EmRewardTypes>( dtoList.size() );
        for ( EmRewardTypesDTO emRewardTypesDTO : dtoList ) {
            list.add( toEntity( emRewardTypesDTO ) );
        }

        return list;
    }

    @Override
    public List<EmRewardTypesDTO> toDto(List<EmRewardTypes> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<EmRewardTypesDTO> list = new ArrayList<EmRewardTypesDTO>( entityList.size() );
        for ( EmRewardTypes emRewardTypes : entityList ) {
            list.add( toDto( emRewardTypes ) );
        }

        return list;
    }
}
