package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.EmEmpResidences;
import com.infostudio.ba.service.dto.EmEmpResidencesDTO;
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
public class EmEmpResidencesMapperImpl implements EmEmpResidencesMapper {

    @Override
    public EmEmpResidences toEntity(EmEmpResidencesDTO dto) {
        if ( dto == null ) {
            return null;
        }

        EmEmpResidences emEmpResidences = new EmEmpResidences();

        emEmpResidences.setCreatedBy( dto.getCreatedBy() );
        emEmpResidences.setCreatedAt( dto.getCreatedAt() );
        emEmpResidences.setUpdatedBy( dto.getUpdatedBy() );
        emEmpResidences.setUpdatedAt( dto.getUpdatedAt() );
        emEmpResidences.setIdCountryWork( dto.getIdCountryWork() );
        emEmpResidences.setIdRegionWork( dto.getIdRegionWork() );
        emEmpResidences.setIdCityWork( dto.getIdCityWork() );
        emEmpResidences.setIdEmployee( dto.getIdEmployee() );
        emEmpResidences.setIdCountry( dto.getIdCountry() );
        emEmpResidences.setIdRegion( dto.getIdRegion() );
        emEmpResidences.setIdCity( dto.getIdCity() );
        emEmpResidences.setId( dto.getId() );
        emEmpResidences.setAddress( dto.getAddress() );
        emEmpResidences.setDateFrom( dto.getDateFrom() );
        emEmpResidences.setDateTo( dto.getDateTo() );
        emEmpResidences.setAddressWork( dto.getAddressWork() );

        return emEmpResidences;
    }

    @Override
    public EmEmpResidencesDTO toDto(EmEmpResidences entity) {
        if ( entity == null ) {
            return null;
        }

        EmEmpResidencesDTO emEmpResidencesDTO = new EmEmpResidencesDTO();

        emEmpResidencesDTO.setIdCountryWork( entity.getIdCountryWork() );
        emEmpResidencesDTO.setIdRegionWork( entity.getIdRegionWork() );
        emEmpResidencesDTO.setIdCityWork( entity.getIdCityWork() );
        emEmpResidencesDTO.setIdEmployee( entity.getIdEmployee() );
        emEmpResidencesDTO.setIdCountry( entity.getIdCountry() );
        emEmpResidencesDTO.setIdRegion( entity.getIdRegion() );
        emEmpResidencesDTO.setIdCity( entity.getIdCity() );
        emEmpResidencesDTO.setId( entity.getId() );
        emEmpResidencesDTO.setAddress( entity.getAddress() );
        emEmpResidencesDTO.setDateFrom( entity.getDateFrom() );
        emEmpResidencesDTO.setDateTo( entity.getDateTo() );
        emEmpResidencesDTO.setAddressWork( entity.getAddressWork() );
        emEmpResidencesDTO.setCreatedBy( entity.getCreatedBy() );
        emEmpResidencesDTO.setCreatedAt( entity.getCreatedAt() );
        emEmpResidencesDTO.setUpdatedBy( entity.getUpdatedBy() );
        emEmpResidencesDTO.setUpdatedAt( entity.getUpdatedAt() );

        return emEmpResidencesDTO;
    }

    @Override
    public List<EmEmpResidences> toEntity(List<EmEmpResidencesDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<EmEmpResidences> list = new ArrayList<EmEmpResidences>( dtoList.size() );
        for ( EmEmpResidencesDTO emEmpResidencesDTO : dtoList ) {
            list.add( toEntity( emEmpResidencesDTO ) );
        }

        return list;
    }

    @Override
    public List<EmEmpResidencesDTO> toDto(List<EmEmpResidences> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<EmEmpResidencesDTO> list = new ArrayList<EmEmpResidencesDTO>( entityList.size() );
        for ( EmEmpResidences emEmpResidences : entityList ) {
            list.add( toDto( emEmpResidences ) );
        }

        return list;
    }
}
