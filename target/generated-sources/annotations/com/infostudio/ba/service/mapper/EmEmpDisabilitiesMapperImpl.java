package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.EmEmpDisabilities;
import com.infostudio.ba.service.dto.EmEmpDisabilitiesDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-07-05T11:16:55+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_172 (Oracle Corporation)"
)
@Component
public class EmEmpDisabilitiesMapperImpl implements EmEmpDisabilitiesMapper {

    @Override
    public EmEmpDisabilities toEntity(EmEmpDisabilitiesDTO dto) {
        if ( dto == null ) {
            return null;
        }

        EmEmpDisabilities emEmpDisabilities = new EmEmpDisabilities();

        emEmpDisabilities.setCreatedBy( dto.getCreatedBy() );
        emEmpDisabilities.setCreatedAt( dto.getCreatedAt() );
        emEmpDisabilities.setUpdatedBy( dto.getUpdatedBy() );
        emEmpDisabilities.setUpdatedAt( dto.getUpdatedAt() );
        emEmpDisabilities.setIdEmployee( dto.getIdEmployee() );
        emEmpDisabilities.setId( dto.getId() );
        emEmpDisabilities.setDescription( dto.getDescription() );
        emEmpDisabilities.setPercentage( dto.getPercentage() );

        return emEmpDisabilities;
    }

    @Override
    public EmEmpDisabilitiesDTO toDto(EmEmpDisabilities entity) {
        if ( entity == null ) {
            return null;
        }

        EmEmpDisabilitiesDTO emEmpDisabilitiesDTO = new EmEmpDisabilitiesDTO();

        emEmpDisabilitiesDTO.setIdEmployee( entity.getIdEmployee() );
        emEmpDisabilitiesDTO.setId( entity.getId() );
        emEmpDisabilitiesDTO.setDescription( entity.getDescription() );
        emEmpDisabilitiesDTO.setPercentage( entity.getPercentage() );
        emEmpDisabilitiesDTO.setCreatedBy( entity.getCreatedBy() );
        emEmpDisabilitiesDTO.setCreatedAt( entity.getCreatedAt() );
        emEmpDisabilitiesDTO.setUpdatedBy( entity.getUpdatedBy() );
        emEmpDisabilitiesDTO.setUpdatedAt( entity.getUpdatedAt() );

        return emEmpDisabilitiesDTO;
    }

    @Override
    public List<EmEmpDisabilities> toEntity(List<EmEmpDisabilitiesDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<EmEmpDisabilities> list = new ArrayList<EmEmpDisabilities>( dtoList.size() );
        for ( EmEmpDisabilitiesDTO emEmpDisabilitiesDTO : dtoList ) {
            list.add( toEntity( emEmpDisabilitiesDTO ) );
        }

        return list;
    }

    @Override
    public List<EmEmpDisabilitiesDTO> toDto(List<EmEmpDisabilities> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<EmEmpDisabilitiesDTO> list = new ArrayList<EmEmpDisabilitiesDTO>( entityList.size() );
        for ( EmEmpDisabilities emEmpDisabilities : entityList ) {
            list.add( toDto( emEmpDisabilities ) );
        }

        return list;
    }
}
