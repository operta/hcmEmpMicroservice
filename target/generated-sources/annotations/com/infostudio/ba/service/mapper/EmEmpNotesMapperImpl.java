package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.EmEmpNotes;
import com.infostudio.ba.domain.EmEmployees;
import com.infostudio.ba.service.dto.EmEmpNotesDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-07-18T16:15:20+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_171 (Oracle Corporation)"
)
@Component
public class EmEmpNotesMapperImpl implements EmEmpNotesMapper {

    @Autowired
    private EmEmployeesMapper emEmployeesMapper;

    @Override
    public List<EmEmpNotes> toEntity(List<EmEmpNotesDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<EmEmpNotes> list = new ArrayList<EmEmpNotes>( dtoList.size() );
        for ( EmEmpNotesDTO emEmpNotesDTO : dtoList ) {
            list.add( toEntity( emEmpNotesDTO ) );
        }

        return list;
    }

    @Override
    public List<EmEmpNotesDTO> toDto(List<EmEmpNotes> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<EmEmpNotesDTO> list = new ArrayList<EmEmpNotesDTO>( entityList.size() );
        for ( EmEmpNotes emEmpNotes : entityList ) {
            list.add( toDto( emEmpNotes ) );
        }

        return list;
    }

    @Override
    public EmEmpNotesDTO toDto(EmEmpNotes emEmpNotes) {
        if ( emEmpNotes == null ) {
            return null;
        }

        EmEmpNotesDTO emEmpNotesDTO = new EmEmpNotesDTO();

        Long id = emEmpNotesIdEmployeeId( emEmpNotes );
        if ( id != null ) {
            emEmpNotesDTO.setIdEmployeeId( id );
        }
        emEmpNotesDTO.setId( emEmpNotes.getId() );
        emEmpNotesDTO.setTitle( emEmpNotes.getTitle() );
        emEmpNotesDTO.setDecsription( emEmpNotes.getDecsription() );
        emEmpNotesDTO.setCreatedBy( emEmpNotes.getCreatedBy() );
        emEmpNotesDTO.setCreatedAt( emEmpNotes.getCreatedAt() );
        emEmpNotesDTO.setUpdatedBy( emEmpNotes.getUpdatedBy() );
        emEmpNotesDTO.setUpdatedAt( emEmpNotes.getUpdatedAt() );

        return emEmpNotesDTO;
    }

    @Override
    public EmEmpNotes toEntity(EmEmpNotesDTO emEmpNotesDTO) {
        if ( emEmpNotesDTO == null ) {
            return null;
        }

        EmEmpNotes emEmpNotes = new EmEmpNotes();

        emEmpNotes.setIdEmployee( emEmployeesMapper.fromId( emEmpNotesDTO.getIdEmployeeId() ) );
        emEmpNotes.setCreatedBy( emEmpNotesDTO.getCreatedBy() );
        emEmpNotes.setCreatedAt( emEmpNotesDTO.getCreatedAt() );
        emEmpNotes.setUpdatedBy( emEmpNotesDTO.getUpdatedBy() );
        emEmpNotes.setUpdatedAt( emEmpNotesDTO.getUpdatedAt() );
        emEmpNotes.setId( emEmpNotesDTO.getId() );
        emEmpNotes.setTitle( emEmpNotesDTO.getTitle() );
        emEmpNotes.setDecsription( emEmpNotesDTO.getDecsription() );

        return emEmpNotes;
    }

    private Long emEmpNotesIdEmployeeId(EmEmpNotes emEmpNotes) {
        if ( emEmpNotes == null ) {
            return null;
        }
        EmEmployees idEmployee = emEmpNotes.getIdEmployee();
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
