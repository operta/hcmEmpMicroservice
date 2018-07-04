package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.EmEmpFamilies;
import com.infostudio.ba.domain.EmEmployees;
import com.infostudio.ba.service.dto.EmEmpFamiliesDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-07-04T14:12:41+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_172 (Oracle Corporation)"
)
@Component
public class EmEmpFamiliesMapperImpl implements EmEmpFamiliesMapper {

    @Autowired
    private EmEmployeesMapper emEmployeesMapper;

    @Override
    public List<EmEmpFamilies> toEntity(List<EmEmpFamiliesDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<EmEmpFamilies> list = new ArrayList<EmEmpFamilies>( dtoList.size() );
        for ( EmEmpFamiliesDTO emEmpFamiliesDTO : dtoList ) {
            list.add( toEntity( emEmpFamiliesDTO ) );
        }

        return list;
    }

    @Override
    public List<EmEmpFamiliesDTO> toDto(List<EmEmpFamilies> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<EmEmpFamiliesDTO> list = new ArrayList<EmEmpFamiliesDTO>( entityList.size() );
        for ( EmEmpFamilies emEmpFamilies : entityList ) {
            list.add( toDto( emEmpFamilies ) );
        }

        return list;
    }

    @Override
    public EmEmpFamiliesDTO toDto(EmEmpFamilies emEmpFamilies) {
        if ( emEmpFamilies == null ) {
            return null;
        }

        EmEmpFamiliesDTO emEmpFamiliesDTO = new EmEmpFamiliesDTO();

        Long id = emEmpFamiliesIdEmployeeId( emEmpFamilies );
        if ( id != null ) {
            emEmpFamiliesDTO.setIdEmployeeId( id );
        }
        emEmpFamiliesDTO.setId( emEmpFamilies.getId() );
        emEmpFamiliesDTO.setName( emEmpFamilies.getName() );
        emEmpFamiliesDTO.setMiddleName( emEmpFamilies.getMiddleName() );
        emEmpFamiliesDTO.setSurname( emEmpFamilies.getSurname() );
        emEmpFamiliesDTO.setMaidenName( emEmpFamilies.getMaidenName() );
        emEmpFamiliesDTO.setIdentificationNumber( emEmpFamilies.getIdentificationNumber() );
        emEmpFamiliesDTO.setCreatedBy( emEmpFamilies.getCreatedBy() );
        emEmpFamiliesDTO.setCreatedAt( emEmpFamilies.getCreatedAt() );
        emEmpFamiliesDTO.setUpdatedBy( emEmpFamilies.getUpdatedBy() );
        emEmpFamiliesDTO.setUpdatedAt( emEmpFamilies.getUpdatedAt() );
        emEmpFamiliesDTO.setIdFamily( emEmpFamilies.getIdFamily() );

        return emEmpFamiliesDTO;
    }

    @Override
    public EmEmpFamilies toEntity(EmEmpFamiliesDTO emEmpFamiliesDTO) {
        if ( emEmpFamiliesDTO == null ) {
            return null;
        }

        EmEmpFamilies emEmpFamilies = new EmEmpFamilies();

        emEmpFamilies.setIdEmployee( emEmployeesMapper.fromId( emEmpFamiliesDTO.getIdEmployeeId() ) );
        emEmpFamilies.setCreatedBy( emEmpFamiliesDTO.getCreatedBy() );
        emEmpFamilies.setCreatedAt( emEmpFamiliesDTO.getCreatedAt() );
        emEmpFamilies.setUpdatedBy( emEmpFamiliesDTO.getUpdatedBy() );
        emEmpFamilies.setUpdatedAt( emEmpFamiliesDTO.getUpdatedAt() );
        emEmpFamilies.setId( emEmpFamiliesDTO.getId() );
        emEmpFamilies.setName( emEmpFamiliesDTO.getName() );
        emEmpFamilies.setMiddleName( emEmpFamiliesDTO.getMiddleName() );
        emEmpFamilies.setSurname( emEmpFamiliesDTO.getSurname() );
        emEmpFamilies.setMaidenName( emEmpFamiliesDTO.getMaidenName() );
        emEmpFamilies.setIdentificationNumber( emEmpFamiliesDTO.getIdentificationNumber() );
        emEmpFamilies.setIdFamily( emEmpFamiliesDTO.getIdFamily() );

        return emEmpFamilies;
    }

    private Long emEmpFamiliesIdEmployeeId(EmEmpFamilies emEmpFamilies) {
        if ( emEmpFamilies == null ) {
            return null;
        }
        EmEmployees idEmployee = emEmpFamilies.getIdEmployee();
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
