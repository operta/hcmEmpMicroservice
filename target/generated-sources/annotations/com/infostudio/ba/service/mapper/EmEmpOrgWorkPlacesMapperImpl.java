package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.EmContractTypes;
import com.infostudio.ba.domain.EmEmpOrgWorkPlaces;
import com.infostudio.ba.domain.EmEmployees;
import com.infostudio.ba.service.dto.EmEmpOrgWorkPlacesDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-07-19T15:37:19+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_171 (Oracle Corporation)"
)
@Component
public class EmEmpOrgWorkPlacesMapperImpl implements EmEmpOrgWorkPlacesMapper {

    @Autowired
    private EmEmployeesMapper emEmployeesMapper;
    @Autowired
    private EmContractTypesMapper emContractTypesMapper;

    @Override
    public List<EmEmpOrgWorkPlaces> toEntity(List<EmEmpOrgWorkPlacesDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<EmEmpOrgWorkPlaces> list = new ArrayList<EmEmpOrgWorkPlaces>( dtoList.size() );
        for ( EmEmpOrgWorkPlacesDTO emEmpOrgWorkPlacesDTO : dtoList ) {
            list.add( toEntity( emEmpOrgWorkPlacesDTO ) );
        }

        return list;
    }

    @Override
    public List<EmEmpOrgWorkPlacesDTO> toDto(List<EmEmpOrgWorkPlaces> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<EmEmpOrgWorkPlacesDTO> list = new ArrayList<EmEmpOrgWorkPlacesDTO>( entityList.size() );
        for ( EmEmpOrgWorkPlaces emEmpOrgWorkPlaces : entityList ) {
            list.add( toDto( emEmpOrgWorkPlaces ) );
        }

        return list;
    }

    @Override
    public EmEmpOrgWorkPlacesDTO toDto(EmEmpOrgWorkPlaces emEmpOrgWorkPlaces) {
        if ( emEmpOrgWorkPlaces == null ) {
            return null;
        }

        EmEmpOrgWorkPlacesDTO emEmpOrgWorkPlacesDTO = new EmEmpOrgWorkPlacesDTO();

        String name = emEmpOrgWorkPlacesIdContractTypeName( emEmpOrgWorkPlaces );
        if ( name != null ) {
            emEmpOrgWorkPlacesDTO.setIdContractTypeName( name );
        }
        Long id = emEmpOrgWorkPlacesIdContractTypeId( emEmpOrgWorkPlaces );
        if ( id != null ) {
            emEmpOrgWorkPlacesDTO.setIdContractTypeId( id );
        }
        Long id1 = emEmpOrgWorkPlacesIdEmployeeId( emEmpOrgWorkPlaces );
        if ( id1 != null ) {
            emEmpOrgWorkPlacesDTO.setIdEmployeeId( id1 );
        }
        emEmpOrgWorkPlacesDTO.setId( emEmpOrgWorkPlaces.getId() );
        emEmpOrgWorkPlacesDTO.setDateFrom( emEmpOrgWorkPlaces.getDateFrom() );
        emEmpOrgWorkPlacesDTO.setDateTo( emEmpOrgWorkPlaces.getDateTo() );
        emEmpOrgWorkPlacesDTO.setWorkHistoryCoefficient( emEmpOrgWorkPlaces.getWorkHistoryCoefficient() );
        emEmpOrgWorkPlacesDTO.setCreatedBy( emEmpOrgWorkPlaces.getCreatedBy() );
        emEmpOrgWorkPlacesDTO.setCreatedAt( emEmpOrgWorkPlaces.getCreatedAt() );
        emEmpOrgWorkPlacesDTO.setUpdatedBy( emEmpOrgWorkPlaces.getUpdatedBy() );
        emEmpOrgWorkPlacesDTO.setUpdatedAt( emEmpOrgWorkPlaces.getUpdatedAt() );
        emEmpOrgWorkPlacesDTO.setIdOrgWorkPlace( emEmpOrgWorkPlaces.getIdOrgWorkPlace() );

        return emEmpOrgWorkPlacesDTO;
    }

    @Override
    public EmEmpOrgWorkPlaces toEntity(EmEmpOrgWorkPlacesDTO emEmpOrgWorkPlacesDTO) {
        if ( emEmpOrgWorkPlacesDTO == null ) {
            return null;
        }

        EmEmpOrgWorkPlaces emEmpOrgWorkPlaces = new EmEmpOrgWorkPlaces();

        emEmpOrgWorkPlaces.setIdContractType( emContractTypesMapper.fromId( emEmpOrgWorkPlacesDTO.getIdContractTypeId() ) );
        emEmpOrgWorkPlaces.setIdEmployee( emEmployeesMapper.fromId( emEmpOrgWorkPlacesDTO.getIdEmployeeId() ) );
        emEmpOrgWorkPlaces.setCreatedBy( emEmpOrgWorkPlacesDTO.getCreatedBy() );
        emEmpOrgWorkPlaces.setCreatedAt( emEmpOrgWorkPlacesDTO.getCreatedAt() );
        emEmpOrgWorkPlaces.setUpdatedBy( emEmpOrgWorkPlacesDTO.getUpdatedBy() );
        emEmpOrgWorkPlaces.setUpdatedAt( emEmpOrgWorkPlacesDTO.getUpdatedAt() );
        emEmpOrgWorkPlaces.setId( emEmpOrgWorkPlacesDTO.getId() );
        emEmpOrgWorkPlaces.setDateFrom( emEmpOrgWorkPlacesDTO.getDateFrom() );
        emEmpOrgWorkPlaces.setDateTo( emEmpOrgWorkPlacesDTO.getDateTo() );
        emEmpOrgWorkPlaces.setWorkHistoryCoefficient( emEmpOrgWorkPlacesDTO.getWorkHistoryCoefficient() );
        emEmpOrgWorkPlaces.setIdOrgWorkPlace( emEmpOrgWorkPlacesDTO.getIdOrgWorkPlace() );

        return emEmpOrgWorkPlaces;
    }

    private String emEmpOrgWorkPlacesIdContractTypeName(EmEmpOrgWorkPlaces emEmpOrgWorkPlaces) {
        if ( emEmpOrgWorkPlaces == null ) {
            return null;
        }
        EmContractTypes idContractType = emEmpOrgWorkPlaces.getIdContractType();
        if ( idContractType == null ) {
            return null;
        }
        String name = idContractType.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private Long emEmpOrgWorkPlacesIdContractTypeId(EmEmpOrgWorkPlaces emEmpOrgWorkPlaces) {
        if ( emEmpOrgWorkPlaces == null ) {
            return null;
        }
        EmContractTypes idContractType = emEmpOrgWorkPlaces.getIdContractType();
        if ( idContractType == null ) {
            return null;
        }
        Long id = idContractType.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long emEmpOrgWorkPlacesIdEmployeeId(EmEmpOrgWorkPlaces emEmpOrgWorkPlaces) {
        if ( emEmpOrgWorkPlaces == null ) {
            return null;
        }
        EmEmployees idEmployee = emEmpOrgWorkPlaces.getIdEmployee();
        if ( idEmployee == null ) {
            return null;
        }
        Long id = idEmployee.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
