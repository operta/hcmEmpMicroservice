package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.EmEmployees;
import com.infostudio.ba.domain.EmPenalties;
import com.infostudio.ba.service.dto.EmPenaltiesDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-07-25T10:22:56+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_171 (Oracle Corporation)"
)
@Component
public class EmPenaltiesMapperImpl implements EmPenaltiesMapper {

    @Autowired
    private EmEmployeesMapper emEmployeesMapper;

    @Override
    public List<EmPenalties> toEntity(List<EmPenaltiesDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<EmPenalties> list = new ArrayList<EmPenalties>( dtoList.size() );
        for ( EmPenaltiesDTO emPenaltiesDTO : dtoList ) {
            list.add( toEntity( emPenaltiesDTO ) );
        }

        return list;
    }

    @Override
    public List<EmPenaltiesDTO> toDto(List<EmPenalties> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<EmPenaltiesDTO> list = new ArrayList<EmPenaltiesDTO>( entityList.size() );
        for ( EmPenalties emPenalties : entityList ) {
            list.add( toDto( emPenalties ) );
        }

        return list;
    }

    @Override
    public EmPenaltiesDTO toDto(EmPenalties emPenalties) {
        if ( emPenalties == null ) {
            return null;
        }

        EmPenaltiesDTO emPenaltiesDTO = new EmPenaltiesDTO();

        Long id = emPenaltiesIdEmployeeId( emPenalties );
        if ( id != null ) {
            emPenaltiesDTO.setIdEmployeeId( id );
        }
        emPenaltiesDTO.setId( emPenalties.getId() );
        emPenaltiesDTO.setDescription( emPenalties.getDescription() );
        emPenaltiesDTO.setDateFrom( emPenalties.getDateFrom() );
        emPenaltiesDTO.setDateTo( emPenalties.getDateTo() );
        emPenaltiesDTO.setCreatedBy( emPenalties.getCreatedBy() );
        emPenaltiesDTO.setCreatedAt( emPenalties.getCreatedAt() );
        emPenaltiesDTO.setUpdatedBy( emPenalties.getUpdatedBy() );
        emPenaltiesDTO.setUpdatedAt( emPenalties.getUpdatedAt() );

        return emPenaltiesDTO;
    }

    @Override
    public EmPenalties toEntity(EmPenaltiesDTO emPenaltiesDTO) {
        if ( emPenaltiesDTO == null ) {
            return null;
        }

        EmPenalties emPenalties = new EmPenalties();

        emPenalties.setIdEmployee( emEmployeesMapper.fromId( emPenaltiesDTO.getIdEmployeeId() ) );
        emPenalties.setCreatedBy( emPenaltiesDTO.getCreatedBy() );
        emPenalties.setCreatedAt( emPenaltiesDTO.getCreatedAt() );
        emPenalties.setUpdatedBy( emPenaltiesDTO.getUpdatedBy() );
        emPenalties.setUpdatedAt( emPenaltiesDTO.getUpdatedAt() );
        emPenalties.setId( emPenaltiesDTO.getId() );
        emPenalties.setDescription( emPenaltiesDTO.getDescription() );
        emPenalties.setDateFrom( emPenaltiesDTO.getDateFrom() );
        emPenalties.setDateTo( emPenaltiesDTO.getDateTo() );

        return emPenalties;
    }

    private Long emPenaltiesIdEmployeeId(EmPenalties emPenalties) {
        if ( emPenalties == null ) {
            return null;
        }
        EmEmployees idEmployee = emPenalties.getIdEmployee();
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
