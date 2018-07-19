package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.EmEmpIdentifications;
import com.infostudio.ba.domain.EmEmployees;
import com.infostudio.ba.service.dto.EmEmpIdentificationsDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-07-19T16:28:03+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
)
@Component
public class EmEmpIdentificationsMapperImpl implements EmEmpIdentificationsMapper {

    @Autowired
    private EmEmployeesMapper emEmployeesMapper;

    @Override
    public List<EmEmpIdentifications> toEntity(List<EmEmpIdentificationsDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<EmEmpIdentifications> list = new ArrayList<EmEmpIdentifications>( dtoList.size() );
        for ( EmEmpIdentificationsDTO emEmpIdentificationsDTO : dtoList ) {
            list.add( toEntity( emEmpIdentificationsDTO ) );
        }

        return list;
    }

    @Override
    public List<EmEmpIdentificationsDTO> toDto(List<EmEmpIdentifications> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<EmEmpIdentificationsDTO> list = new ArrayList<EmEmpIdentificationsDTO>( entityList.size() );
        for ( EmEmpIdentifications emEmpIdentifications : entityList ) {
            list.add( toDto( emEmpIdentifications ) );
        }

        return list;
    }

    @Override
    public EmEmpIdentificationsDTO toDto(EmEmpIdentifications emEmpIdentifications) {
        if ( emEmpIdentifications == null ) {
            return null;
        }

        EmEmpIdentificationsDTO emEmpIdentificationsDTO = new EmEmpIdentificationsDTO();

        Long id = emEmpIdentificationsIdEmployeeId( emEmpIdentifications );
        if ( id != null ) {
            emEmpIdentificationsDTO.setIdEmployeeId( id );
        }
        emEmpIdentificationsDTO.setId( emEmpIdentifications.getId() );
        emEmpIdentificationsDTO.setIdentificationNumber( emEmpIdentifications.getIdentificationNumber() );
        emEmpIdentificationsDTO.setJurisdiction( emEmpIdentifications.getJurisdiction() );
        emEmpIdentificationsDTO.setValidThrough( emEmpIdentifications.getValidThrough() );
        emEmpIdentificationsDTO.setIdIdentification( emEmpIdentifications.getIdIdentification() );
        emEmpIdentificationsDTO.setIdRegion( emEmpIdentifications.getIdRegion() );

        return emEmpIdentificationsDTO;
    }

    @Override
    public EmEmpIdentifications toEntity(EmEmpIdentificationsDTO emEmpIdentificationsDTO) {
        if ( emEmpIdentificationsDTO == null ) {
            return null;
        }

        EmEmpIdentifications emEmpIdentifications = new EmEmpIdentifications();

        emEmpIdentifications.setIdEmployee( emEmployeesMapper.fromId( emEmpIdentificationsDTO.getIdEmployeeId() ) );
        emEmpIdentifications.setId( emEmpIdentificationsDTO.getId() );
        emEmpIdentifications.setIdentificationNumber( emEmpIdentificationsDTO.getIdentificationNumber() );
        emEmpIdentifications.setJurisdiction( emEmpIdentificationsDTO.getJurisdiction() );
        emEmpIdentifications.setValidThrough( emEmpIdentificationsDTO.getValidThrough() );
        emEmpIdentifications.setIdIdentification( emEmpIdentificationsDTO.getIdIdentification() );
        emEmpIdentifications.setIdRegion( emEmpIdentificationsDTO.getIdRegion() );

        return emEmpIdentifications;
    }

    private Long emEmpIdentificationsIdEmployeeId(EmEmpIdentifications emEmpIdentifications) {
        if ( emEmpIdentifications == null ) {
            return null;
        }
        EmEmployees idEmployee = emEmpIdentifications.getIdEmployee();
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
