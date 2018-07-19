package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.EmEmpEmgContacts;
import com.infostudio.ba.service.dto.EmEmpEmgContactsDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-07-19T16:28:04+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
)
@Component
public class EmEmpEmgContactsMapperImpl implements EmEmpEmgContactsMapper {

    @Override
    public EmEmpEmgContacts toEntity(EmEmpEmgContactsDTO dto) {
        if ( dto == null ) {
            return null;
        }

        EmEmpEmgContacts emEmpEmgContacts = new EmEmpEmgContacts();

        emEmpEmgContacts.setCreatedBy( dto.getCreatedBy() );
        emEmpEmgContacts.setCreatedAt( dto.getCreatedAt() );
        emEmpEmgContacts.setUpdatedBy( dto.getUpdatedBy() );
        emEmpEmgContacts.setUpdatedAt( dto.getUpdatedAt() );
        emEmpEmgContacts.setId( dto.getId() );
        emEmpEmgContacts.setIdEmployee( dto.getIdEmployee() );
        emEmpEmgContacts.setIdContactType( dto.getIdContactType() );
        emEmpEmgContacts.setFirstName( dto.getFirstName() );
        emEmpEmgContacts.setLastName( dto.getLastName() );
        emEmpEmgContacts.setPhoneNumber( dto.getPhoneNumber() );
        emEmpEmgContacts.setEmail( dto.getEmail() );

        return emEmpEmgContacts;
    }

    @Override
    public EmEmpEmgContactsDTO toDto(EmEmpEmgContacts entity) {
        if ( entity == null ) {
            return null;
        }

        EmEmpEmgContactsDTO emEmpEmgContactsDTO = new EmEmpEmgContactsDTO();

        emEmpEmgContactsDTO.setIdEmployee( entity.getIdEmployee() );
        emEmpEmgContactsDTO.setIdContactType( entity.getIdContactType() );
        emEmpEmgContactsDTO.setId( entity.getId() );
        emEmpEmgContactsDTO.setFirstName( entity.getFirstName() );
        emEmpEmgContactsDTO.setLastName( entity.getLastName() );
        emEmpEmgContactsDTO.setCreatedBy( entity.getCreatedBy() );
        emEmpEmgContactsDTO.setCreatedAt( entity.getCreatedAt() );
        emEmpEmgContactsDTO.setUpdatedBy( entity.getUpdatedBy() );
        emEmpEmgContactsDTO.setUpdatedAt( entity.getUpdatedAt() );
        emEmpEmgContactsDTO.setPhoneNumber( entity.getPhoneNumber() );
        emEmpEmgContactsDTO.setEmail( entity.getEmail() );

        return emEmpEmgContactsDTO;
    }

    @Override
    public List<EmEmpEmgContacts> toEntity(List<EmEmpEmgContactsDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<EmEmpEmgContacts> list = new ArrayList<EmEmpEmgContacts>( dtoList.size() );
        for ( EmEmpEmgContactsDTO emEmpEmgContactsDTO : dtoList ) {
            list.add( toEntity( emEmpEmgContactsDTO ) );
        }

        return list;
    }

    @Override
    public List<EmEmpEmgContactsDTO> toDto(List<EmEmpEmgContacts> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<EmEmpEmgContactsDTO> list = new ArrayList<EmEmpEmgContactsDTO>( entityList.size() );
        for ( EmEmpEmgContacts emEmpEmgContacts : entityList ) {
            list.add( toDto( emEmpEmgContacts ) );
        }

        return list;
    }
}
