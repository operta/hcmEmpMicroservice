package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.EmEmpMetaData;
import com.infostudio.ba.service.dto.EmEmpMetaDataDTO;
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
public class EmEmpMetaDataMapperImpl implements EmEmpMetaDataMapper {

    @Override
    public EmEmpMetaData toEntity(EmEmpMetaDataDTO dto) {
        if ( dto == null ) {
            return null;
        }

        EmEmpMetaData emEmpMetaData = new EmEmpMetaData();

        emEmpMetaData.setCreatedBy( dto.getCreatedBy() );
        emEmpMetaData.setCreatedAt( dto.getCreatedAt() );
        emEmpMetaData.setUpdatedBy( dto.getUpdatedBy() );
        emEmpMetaData.setUpdatedAt( dto.getUpdatedAt() );
        emEmpMetaData.setIdEmployee( dto.getIdEmployee() );
        emEmpMetaData.setIdMetaData( dto.getIdMetaData() );
        emEmpMetaData.setId( dto.getId() );
        emEmpMetaData.setTitle( dto.getTitle() );
        emEmpMetaData.setValue( dto.getValue() );
        emEmpMetaData.setDisplayvalue( dto.getDisplayvalue() );
        emEmpMetaData.setOrdering( dto.getOrdering() );

        return emEmpMetaData;
    }

    @Override
    public EmEmpMetaDataDTO toDto(EmEmpMetaData entity) {
        if ( entity == null ) {
            return null;
        }

        EmEmpMetaDataDTO emEmpMetaDataDTO = new EmEmpMetaDataDTO();

        emEmpMetaDataDTO.setIdMetaData( entity.getIdMetaData() );
        emEmpMetaDataDTO.setIdEmployee( entity.getIdEmployee() );
        emEmpMetaDataDTO.setId( entity.getId() );
        emEmpMetaDataDTO.setTitle( entity.getTitle() );
        emEmpMetaDataDTO.setValue( entity.getValue() );
        emEmpMetaDataDTO.setDisplayvalue( entity.getDisplayvalue() );
        emEmpMetaDataDTO.setOrdering( entity.getOrdering() );
        emEmpMetaDataDTO.setCreatedBy( entity.getCreatedBy() );
        emEmpMetaDataDTO.setCreatedAt( entity.getCreatedAt() );
        emEmpMetaDataDTO.setUpdatedBy( entity.getUpdatedBy() );
        emEmpMetaDataDTO.setUpdatedAt( entity.getUpdatedAt() );

        return emEmpMetaDataDTO;
    }

    @Override
    public List<EmEmpMetaData> toEntity(List<EmEmpMetaDataDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<EmEmpMetaData> list = new ArrayList<EmEmpMetaData>( dtoList.size() );
        for ( EmEmpMetaDataDTO emEmpMetaDataDTO : dtoList ) {
            list.add( toEntity( emEmpMetaDataDTO ) );
        }

        return list;
    }

    @Override
    public List<EmEmpMetaDataDTO> toDto(List<EmEmpMetaData> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<EmEmpMetaDataDTO> list = new ArrayList<EmEmpMetaDataDTO>( entityList.size() );
        for ( EmEmpMetaData emEmpMetaData : entityList ) {
            list.add( toDto( emEmpMetaData ) );
        }

        return list;
    }
}
