package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.EmEmpInjuries;
import com.infostudio.ba.domain.EmEmployees;
import com.infostudio.ba.domain.EmInjuryTypes;
import com.infostudio.ba.service.dto.EmEmpInjuriesDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-07-25T14:32:30+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_171 (Oracle Corporation)"
)
@Component
public class EmEmpInjuriesMapperImpl implements EmEmpInjuriesMapper {

    @Autowired
    private EmEmployeesMapper emEmployeesMapper;
    @Autowired
    private EmInjuryTypesMapper emInjuryTypesMapper;

    @Override
    public List<EmEmpInjuries> toEntity(List<EmEmpInjuriesDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<EmEmpInjuries> list = new ArrayList<EmEmpInjuries>( dtoList.size() );
        for ( EmEmpInjuriesDTO emEmpInjuriesDTO : dtoList ) {
            list.add( toEntity( emEmpInjuriesDTO ) );
        }

        return list;
    }

    @Override
    public List<EmEmpInjuriesDTO> toDto(List<EmEmpInjuries> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<EmEmpInjuriesDTO> list = new ArrayList<EmEmpInjuriesDTO>( entityList.size() );
        for ( EmEmpInjuries emEmpInjuries : entityList ) {
            list.add( toDto( emEmpInjuries ) );
        }

        return list;
    }

    @Override
    public EmEmpInjuriesDTO toDto(EmEmpInjuries emEmpInjuries) {
        if ( emEmpInjuries == null ) {
            return null;
        }

        EmEmpInjuriesDTO emEmpInjuriesDTO = new EmEmpInjuriesDTO();

        String name = emEmpInjuriesIdInjuryName( emEmpInjuries );
        if ( name != null ) {
            emEmpInjuriesDTO.setIdInjuryName( name );
        }
        Long id = emEmpInjuriesIdInjuryId( emEmpInjuries );
        if ( id != null ) {
            emEmpInjuriesDTO.setIdInjuryId( id );
        }
        Long id1 = emEmpInjuriesIdEmployeeId( emEmpInjuries );
        if ( id1 != null ) {
            emEmpInjuriesDTO.setIdEmployeeId( id1 );
        }
        emEmpInjuriesDTO.setId( emEmpInjuries.getId() );
        emEmpInjuriesDTO.setDescription( emEmpInjuries.getDescription() );

        return emEmpInjuriesDTO;
    }

    @Override
    public EmEmpInjuries toEntity(EmEmpInjuriesDTO emEmpInjuriesDTO) {
        if ( emEmpInjuriesDTO == null ) {
            return null;
        }

        EmEmpInjuries emEmpInjuries = new EmEmpInjuries();

        emEmpInjuries.setIdEmployee( emEmployeesMapper.fromId( emEmpInjuriesDTO.getIdEmployeeId() ) );
        emEmpInjuries.setIdInjury( emInjuryTypesMapper.fromId( emEmpInjuriesDTO.getIdInjuryId() ) );
        emEmpInjuries.setId( emEmpInjuriesDTO.getId() );
        emEmpInjuries.setDescription( emEmpInjuriesDTO.getDescription() );

        return emEmpInjuries;
    }

    private String emEmpInjuriesIdInjuryName(EmEmpInjuries emEmpInjuries) {
        if ( emEmpInjuries == null ) {
            return null;
        }
        EmInjuryTypes idInjury = emEmpInjuries.getIdInjury();
        if ( idInjury == null ) {
            return null;
        }
        String name = idInjury.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private Long emEmpInjuriesIdInjuryId(EmEmpInjuries emEmpInjuries) {
        if ( emEmpInjuries == null ) {
            return null;
        }
        EmInjuryTypes idInjury = emEmpInjuries.getIdInjury();
        if ( idInjury == null ) {
            return null;
        }
        Long id = idInjury.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long emEmpInjuriesIdEmployeeId(EmEmpInjuries emEmpInjuries) {
        if ( emEmpInjuries == null ) {
            return null;
        }
        EmEmployees idEmployee = emEmpInjuries.getIdEmployee();
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
