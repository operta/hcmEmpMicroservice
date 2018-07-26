package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.EmEmpTasks;
import com.infostudio.ba.service.dto.EmEmpTasksDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-07-26T14:38:32+0200",
    comments = "version: 1.2.0.Final, compiler: Eclipse JDT (IDE) 1.3.200.v20180612-0641, environment: Java 1.8.0_151 (Oracle Corporation)"
)
@Component
public class EmEmpTasksMapperImpl implements EmEmpTasksMapper {

    @Override
    public EmEmpTasksDTO toDto(EmEmpTasks arg0) {
        if ( arg0 == null ) {
            return null;
        }

        EmEmpTasksDTO emEmpTasksDTO = new EmEmpTasksDTO();

        emEmpTasksDTO.setCreatedBy( arg0.getCreatedBy() );
        emEmpTasksDTO.setCreatedAt( arg0.getCreatedAt() );
        emEmpTasksDTO.setUpdatedAt( arg0.getUpdatedAt() );
        emEmpTasksDTO.setUpdatedBy( arg0.getUpdatedBy() );
        emEmpTasksDTO.setId( arg0.getId() );
        emEmpTasksDTO.setIdEmployee( arg0.getIdEmployee() );
        emEmpTasksDTO.setFinished( arg0.getFinished() );
        emEmpTasksDTO.setName( arg0.getName() );
        emEmpTasksDTO.setDescription( arg0.getDescription() );

        return emEmpTasksDTO;
    }

    @Override
    public List<EmEmpTasksDTO> toDto(List<EmEmpTasks> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<EmEmpTasksDTO> list = new ArrayList<EmEmpTasksDTO>( arg0.size() );
        for ( EmEmpTasks emEmpTasks : arg0 ) {
            list.add( toDto( emEmpTasks ) );
        }

        return list;
    }

    @Override
    public EmEmpTasks toEntity(EmEmpTasksDTO arg0) {
        if ( arg0 == null ) {
            return null;
        }

        EmEmpTasks emEmpTasks = new EmEmpTasks();

        emEmpTasks.setCreatedAt( arg0.getCreatedAt() );
        emEmpTasks.setCreatedBy( arg0.getCreatedBy() );
        emEmpTasks.setUpdatedAt( arg0.getUpdatedAt() );
        emEmpTasks.setUpdatedBy( arg0.getUpdatedBy() );
        emEmpTasks.setId( arg0.getId() );
        emEmpTasks.setIdEmployee( arg0.getIdEmployee() );
        emEmpTasks.setFinished( arg0.getFinished() );
        emEmpTasks.setName( arg0.getName() );
        emEmpTasks.setDescription( arg0.getDescription() );

        return emEmpTasks;
    }

    @Override
    public List<EmEmpTasks> toEntity(List<EmEmpTasksDTO> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<EmEmpTasks> list = new ArrayList<EmEmpTasks>( arg0.size() );
        for ( EmEmpTasksDTO emEmpTasksDTO : arg0 ) {
            list.add( toEntity( emEmpTasksDTO ) );
        }

        return list;
    }
}
