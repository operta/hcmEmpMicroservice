package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.EmEmpAccomplishments;
import com.infostudio.ba.domain.EmEmployees;
import com.infostudio.ba.service.dto.EmEmpAccomplishmentsDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-07-12T09:28:36+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
)
@Component
public class EmEmpAccomplishmentsMapperImpl implements EmEmpAccomplishmentsMapper {

    @Autowired
    private EmEmployeesMapper emEmployeesMapper;

    @Override
    public List<EmEmpAccomplishments> toEntity(List<EmEmpAccomplishmentsDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<EmEmpAccomplishments> list = new ArrayList<EmEmpAccomplishments>( dtoList.size() );
        for ( EmEmpAccomplishmentsDTO emEmpAccomplishmentsDTO : dtoList ) {
            list.add( toEntity( emEmpAccomplishmentsDTO ) );
        }

        return list;
    }

    @Override
    public List<EmEmpAccomplishmentsDTO> toDto(List<EmEmpAccomplishments> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<EmEmpAccomplishmentsDTO> list = new ArrayList<EmEmpAccomplishmentsDTO>( entityList.size() );
        for ( EmEmpAccomplishments emEmpAccomplishments : entityList ) {
            list.add( toDto( emEmpAccomplishments ) );
        }

        return list;
    }

    @Override
    public EmEmpAccomplishmentsDTO toDto(EmEmpAccomplishments emEmpAccomplishments) {
        if ( emEmpAccomplishments == null ) {
            return null;
        }

        EmEmpAccomplishmentsDTO emEmpAccomplishmentsDTO = new EmEmpAccomplishmentsDTO();

        Long id = emEmpAccomplishmentsIdEmployeeId( emEmpAccomplishments );
        if ( id != null ) {
            emEmpAccomplishmentsDTO.setIdEmployeeId( id );
        }
        emEmpAccomplishmentsDTO.setId( emEmpAccomplishments.getId() );
        emEmpAccomplishmentsDTO.setTitle( emEmpAccomplishments.getTitle() );
        emEmpAccomplishmentsDTO.setDescription( emEmpAccomplishments.getDescription() );
        emEmpAccomplishmentsDTO.setOrganization( emEmpAccomplishments.getOrganization() );
        emEmpAccomplishmentsDTO.setLocation( emEmpAccomplishments.getLocation() );
        emEmpAccomplishmentsDTO.setAssociation( emEmpAccomplishments.getAssociation() );
        emEmpAccomplishmentsDTO.setOngoing( emEmpAccomplishments.getOngoing() );
        emEmpAccomplishmentsDTO.setLink( emEmpAccomplishments.getLink() );
        emEmpAccomplishmentsDTO.setDateFrom( emEmpAccomplishments.getDateFrom() );
        emEmpAccomplishmentsDTO.setDateTo( emEmpAccomplishments.getDateTo() );
        emEmpAccomplishmentsDTO.setOccupation( emEmpAccomplishments.getOccupation() );
        emEmpAccomplishmentsDTO.setProficiency( emEmpAccomplishments.getProficiency() );
        emEmpAccomplishmentsDTO.setLicenceNumber( emEmpAccomplishments.getLicenceNumber() );
        emEmpAccomplishmentsDTO.setRating( emEmpAccomplishments.getRating() );
        emEmpAccomplishmentsDTO.setIdAccomplishmentType( emEmpAccomplishments.getIdAccomplishmentType() );

        return emEmpAccomplishmentsDTO;
    }

    @Override
    public EmEmpAccomplishments toEntity(EmEmpAccomplishmentsDTO emEmpAccomplishmentsDTO) {
        if ( emEmpAccomplishmentsDTO == null ) {
            return null;
        }

        EmEmpAccomplishments emEmpAccomplishments = new EmEmpAccomplishments();

        emEmpAccomplishments.setIdEmployee( emEmployeesMapper.fromId( emEmpAccomplishmentsDTO.getIdEmployeeId() ) );
        emEmpAccomplishments.setId( emEmpAccomplishmentsDTO.getId() );
        emEmpAccomplishments.setTitle( emEmpAccomplishmentsDTO.getTitle() );
        emEmpAccomplishments.setDescription( emEmpAccomplishmentsDTO.getDescription() );
        emEmpAccomplishments.setOrganization( emEmpAccomplishmentsDTO.getOrganization() );
        emEmpAccomplishments.setLocation( emEmpAccomplishmentsDTO.getLocation() );
        emEmpAccomplishments.setAssociation( emEmpAccomplishmentsDTO.getAssociation() );
        emEmpAccomplishments.setOngoing( emEmpAccomplishmentsDTO.getOngoing() );
        emEmpAccomplishments.setLink( emEmpAccomplishmentsDTO.getLink() );
        emEmpAccomplishments.setDateFrom( emEmpAccomplishmentsDTO.getDateFrom() );
        emEmpAccomplishments.setDateTo( emEmpAccomplishmentsDTO.getDateTo() );
        emEmpAccomplishments.setOccupation( emEmpAccomplishmentsDTO.getOccupation() );
        emEmpAccomplishments.setProficiency( emEmpAccomplishmentsDTO.getProficiency() );
        emEmpAccomplishments.setLicenceNumber( emEmpAccomplishmentsDTO.getLicenceNumber() );
        emEmpAccomplishments.setRating( emEmpAccomplishmentsDTO.getRating() );
        emEmpAccomplishments.setIdAccomplishmentType( emEmpAccomplishmentsDTO.getIdAccomplishmentType() );

        return emEmpAccomplishments;
    }

    private Long emEmpAccomplishmentsIdEmployeeId(EmEmpAccomplishments emEmpAccomplishments) {
        if ( emEmpAccomplishments == null ) {
            return null;
        }
        EmEmployees idEmployee = emEmpAccomplishments.getIdEmployee();
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
