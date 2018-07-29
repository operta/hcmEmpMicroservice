package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.EmEmpContacts;
import com.infostudio.ba.service.dto.EmEmpContactsDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-07-27T16:20:58+0200",
    comments = "version: 1.2.0.Final, compiler: Eclipse JDT (IDE) 1.3.200.v20180612-0641, environment: Java 1.8.0_151 (Oracle Corporation)"
)
@Component
public class EmEmpContactsMapperImpl implements EmEmpContactsMapper {

    @Override
    public EmEmpContacts toEntity(EmEmpContactsDTO dto) {
        if ( dto == null ) {
            return null;
        }

        EmEmpContacts emEmpContacts = new EmEmpContacts();

        emEmpContacts.setCreatedBy( dto.getCreatedBy() );
        emEmpContacts.setCreatedAt( dto.getCreatedAt() );
        emEmpContacts.setUpdatedBy( dto.getUpdatedBy() );
        emEmpContacts.setUpdatedAt( dto.getUpdatedAt() );
        emEmpContacts.setIdEmployee( dto.getIdEmployee() );
        emEmpContacts.setId( dto.getId() );
        emEmpContacts.setContact( dto.getContact() );
        emEmpContacts.setDescription( dto.getDescription() );

        return emEmpContacts;
    }

    @Override
    public EmEmpContactsDTO toDto(EmEmpContacts entity) {
        if ( entity == null ) {
            return null;
        }

        EmEmpContactsDTO emEmpContactsDTO = new EmEmpContactsDTO();

        emEmpContactsDTO.setId( entity.getId() );
        emEmpContactsDTO.setIdEmployee( entity.getIdEmployee() );
        emEmpContactsDTO.setContact( entity.getContact() );
        emEmpContactsDTO.setDescription( entity.getDescription() );
        emEmpContactsDTO.setCreatedBy( entity.getCreatedBy() );
        emEmpContactsDTO.setCreatedAt( entity.getCreatedAt() );
        emEmpContactsDTO.setUpdatedBy( entity.getUpdatedBy() );
        emEmpContactsDTO.setUpdatedAt( entity.getUpdatedAt() );

        return emEmpContactsDTO;
    }

    @Override
    public List<EmEmpContacts> toEntity(List<EmEmpContactsDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<EmEmpContacts> list = new ArrayList<EmEmpContacts>( dtoList.size() );
        for ( EmEmpContactsDTO emEmpContactsDTO : dtoList ) {
            list.add( toEntity( emEmpContactsDTO ) );
        }

        return list;
    }

    @Override
    public List<EmEmpContactsDTO> toDto(List<EmEmpContacts> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<EmEmpContactsDTO> list = new ArrayList<EmEmpContactsDTO>( entityList.size() );
        for ( EmEmpContacts emEmpContacts : entityList ) {
            list.add( toDto( emEmpContacts ) );
        }

        return list;
    }
}
