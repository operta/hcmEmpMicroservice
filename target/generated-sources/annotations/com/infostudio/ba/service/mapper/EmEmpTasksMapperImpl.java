package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.EmEmpTasks;
import com.infostudio.ba.service.dto.EmEmpTasksDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-10-31T16:40:35+0100",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_151 (Oracle Corporation)"
)
@Component
public class EmEmpTasksMapperImpl implements EmEmpTasksMapper {

    @Override
    public EmEmpTasks toEntity(EmEmpTasksDTO dto) {
        if ( dto == null ) {
            return null;
        }

        EmEmpTasks emEmpTasks = new EmEmpTasks();

        emEmpTasks.setCreatedBy( dto.getCreatedBy() );
        emEmpTasks.setCreatedAt( dto.getCreatedAt() );
        emEmpTasks.setUpdatedBy( dto.getUpdatedBy() );
        emEmpTasks.setUpdatedAt( dto.getUpdatedAt() );
        emEmpTasks.setId( dto.getId() );
        emEmpTasks.setIdEmployee( dto.getIdEmployee() );
        emEmpTasks.setFinished( dto.getFinished() );
        emEmpTasks.setName( dto.getName() );
        emEmpTasks.setDescription( dto.getDescription() );

        return emEmpTasks;
    }

    @Override
    public EmEmpTasksDTO toDto(EmEmpTasks entity) {
        if ( entity == null ) {
            return null;
        }

        EmEmpTasksDTO emEmpTasksDTO = new EmEmpTasksDTO();

        emEmpTasksDTO.setCreatedBy( entity.getCreatedBy() );
        emEmpTasksDTO.setCreatedAt( entity.getCreatedAt() );
        emEmpTasksDTO.setUpdatedAt( entity.getUpdatedAt() );
        emEmpTasksDTO.setUpdatedBy( entity.getUpdatedBy() );
        emEmpTasksDTO.setId( entity.getId() );
        emEmpTasksDTO.setIdEmployee( entity.getIdEmployee() );
        emEmpTasksDTO.setFinished( entity.getFinished() );
        emEmpTasksDTO.setName( entity.getName() );
        emEmpTasksDTO.setDescription( entity.getDescription() );

        return emEmpTasksDTO;
    }

    @Override
    public List<EmEmpTasks> toEntity(List<EmEmpTasksDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<EmEmpTasks> list = new ArrayList<EmEmpTasks>( dtoList.size() );
        for ( EmEmpTasksDTO emEmpTasksDTO : dtoList ) {
            list.add( toEntity( emEmpTasksDTO ) );
        }

        return list;
    }

    @Override
    public List<EmEmpTasksDTO> toDto(List<EmEmpTasks> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<EmEmpTasksDTO> list = new ArrayList<EmEmpTasksDTO>( entityList.size() );
        for ( EmEmpTasks emEmpTasks : entityList ) {
            list.add( toDto( emEmpTasks ) );
        }

        return list;
    }
}
