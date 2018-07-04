package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.EmEmpDocuments;
import com.infostudio.ba.domain.EmEmployees;
import com.infostudio.ba.service.dto.EmEmpDocumentsDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-07-04T14:12:40+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_172 (Oracle Corporation)"
)
@Component
public class EmEmpDocumentsMapperImpl implements EmEmpDocumentsMapper {

    @Autowired
    private EmEmployeesMapper emEmployeesMapper;

    @Override
    public List<EmEmpDocuments> toEntity(List<EmEmpDocumentsDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<EmEmpDocuments> list = new ArrayList<EmEmpDocuments>( dtoList.size() );
        for ( EmEmpDocumentsDTO emEmpDocumentsDTO : dtoList ) {
            list.add( toEntity( emEmpDocumentsDTO ) );
        }

        return list;
    }

    @Override
    public List<EmEmpDocumentsDTO> toDto(List<EmEmpDocuments> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<EmEmpDocumentsDTO> list = new ArrayList<EmEmpDocumentsDTO>( entityList.size() );
        for ( EmEmpDocuments emEmpDocuments : entityList ) {
            list.add( toDto( emEmpDocuments ) );
        }

        return list;
    }

    @Override
    public EmEmpDocumentsDTO toDto(EmEmpDocuments emEmpDocuments) {
        if ( emEmpDocuments == null ) {
            return null;
        }

        EmEmpDocumentsDTO emEmpDocumentsDTO = new EmEmpDocumentsDTO();

        Long id = emEmpDocumentsIdEmployeeId( emEmpDocuments );
        if ( id != null ) {
            emEmpDocumentsDTO.setIdEmployeeId( id );
        }
        emEmpDocumentsDTO.setId( emEmpDocuments.getId() );
        emEmpDocumentsDTO.setName( emEmpDocuments.getName() );
        emEmpDocumentsDTO.setDescription( emEmpDocuments.getDescription() );
        emEmpDocumentsDTO.setDateCreated( emEmpDocuments.getDateCreated() );
        emEmpDocumentsDTO.setValidFrom( emEmpDocuments.getValidFrom() );
        emEmpDocumentsDTO.setValidTo( emEmpDocuments.getValidTo() );
        emEmpDocumentsDTO.setCreatedBy( emEmpDocuments.getCreatedBy() );
        emEmpDocumentsDTO.setCreatedAt( emEmpDocuments.getCreatedAt() );
        emEmpDocumentsDTO.setUpdatedBy( emEmpDocuments.getUpdatedBy() );
        emEmpDocumentsDTO.setUpdatedAt( emEmpDocuments.getUpdatedAt() );
        emEmpDocumentsDTO.setIdDocumentType( emEmpDocuments.getIdDocumentType() );
        emEmpDocumentsDTO.setIdDocumentLink( emEmpDocuments.getIdDocumentLink() );

        return emEmpDocumentsDTO;
    }

    @Override
    public EmEmpDocuments toEntity(EmEmpDocumentsDTO emEmpDocumentsDTO) {
        if ( emEmpDocumentsDTO == null ) {
            return null;
        }

        EmEmpDocuments emEmpDocuments = new EmEmpDocuments();

        emEmpDocuments.setIdEmployee( emEmployeesMapper.fromId( emEmpDocumentsDTO.getIdEmployeeId() ) );
        emEmpDocuments.setCreatedBy( emEmpDocumentsDTO.getCreatedBy() );
        emEmpDocuments.setCreatedAt( emEmpDocumentsDTO.getCreatedAt() );
        emEmpDocuments.setUpdatedBy( emEmpDocumentsDTO.getUpdatedBy() );
        emEmpDocuments.setUpdatedAt( emEmpDocumentsDTO.getUpdatedAt() );
        emEmpDocuments.setId( emEmpDocumentsDTO.getId() );
        emEmpDocuments.setName( emEmpDocumentsDTO.getName() );
        emEmpDocuments.setDescription( emEmpDocumentsDTO.getDescription() );
        emEmpDocuments.setDateCreated( emEmpDocumentsDTO.getDateCreated() );
        emEmpDocuments.setValidFrom( emEmpDocumentsDTO.getValidFrom() );
        emEmpDocuments.setValidTo( emEmpDocumentsDTO.getValidTo() );
        emEmpDocuments.setIdDocumentType( emEmpDocumentsDTO.getIdDocumentType() );
        emEmpDocuments.setIdDocumentLink( emEmpDocumentsDTO.getIdDocumentLink() );

        return emEmpDocuments;
    }

    private Long emEmpDocumentsIdEmployeeId(EmEmpDocuments emEmpDocuments) {
        if ( emEmpDocuments == null ) {
            return null;
        }
        EmEmployees idEmployee = emEmpDocuments.getIdEmployee();
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
