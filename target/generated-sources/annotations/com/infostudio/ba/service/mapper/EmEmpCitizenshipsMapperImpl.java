package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.EmEmpCitizenships;
import com.infostudio.ba.service.dto.EmEmpCitizenshipsDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-07-25T14:32:30+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_171 (Oracle Corporation)"
)
@Component
public class EmEmpCitizenshipsMapperImpl implements EmEmpCitizenshipsMapper {

    @Override
    public EmEmpCitizenships toEntity(EmEmpCitizenshipsDTO dto) {
        if ( dto == null ) {
            return null;
        }

        EmEmpCitizenships emEmpCitizenships = new EmEmpCitizenships();

        emEmpCitizenships.setCreatedBy( dto.getCreatedBy() );
        emEmpCitizenships.setCreatedAt( dto.getCreatedAt() );
        emEmpCitizenships.setUpdatedBy( dto.getUpdatedBy() );
        emEmpCitizenships.setUpdatedAt( dto.getUpdatedAt() );
        emEmpCitizenships.setId( dto.getId() );
        emEmpCitizenships.setIdEmployee( dto.getIdEmployee() );
        emEmpCitizenships.setIdCountry( dto.getIdCountry() );

        return emEmpCitizenships;
    }

    @Override
    public EmEmpCitizenshipsDTO toDto(EmEmpCitizenships entity) {
        if ( entity == null ) {
            return null;
        }

        EmEmpCitizenshipsDTO emEmpCitizenshipsDTO = new EmEmpCitizenshipsDTO();

        emEmpCitizenshipsDTO.setId( entity.getId() );
        emEmpCitizenshipsDTO.setCreatedBy( entity.getCreatedBy() );
        emEmpCitizenshipsDTO.setCreatedAt( entity.getCreatedAt() );
        emEmpCitizenshipsDTO.setUpdatedBy( entity.getUpdatedBy() );
        emEmpCitizenshipsDTO.setUpdatedAt( entity.getUpdatedAt() );
        emEmpCitizenshipsDTO.setIdEmployee( entity.getIdEmployee() );
        emEmpCitizenshipsDTO.setIdCountry( entity.getIdCountry() );

        return emEmpCitizenshipsDTO;
    }

    @Override
    public List<EmEmpCitizenships> toEntity(List<EmEmpCitizenshipsDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<EmEmpCitizenships> list = new ArrayList<EmEmpCitizenships>( dtoList.size() );
        for ( EmEmpCitizenshipsDTO emEmpCitizenshipsDTO : dtoList ) {
            list.add( toEntity( emEmpCitizenshipsDTO ) );
        }

        return list;
    }

    @Override
    public List<EmEmpCitizenshipsDTO> toDto(List<EmEmpCitizenships> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<EmEmpCitizenshipsDTO> list = new ArrayList<EmEmpCitizenshipsDTO>( entityList.size() );
        for ( EmEmpCitizenships emEmpCitizenships : entityList ) {
            list.add( toDto( emEmpCitizenships ) );
        }

        return list;
    }
}
