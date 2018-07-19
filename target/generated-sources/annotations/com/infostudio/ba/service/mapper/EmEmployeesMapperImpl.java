package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.EmEmpTypes;
import com.infostudio.ba.domain.EmEmployees;
import com.infostudio.ba.domain.EmStatuses;
import com.infostudio.ba.service.dto.EmEmployeesDTO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-07-19T15:37:16+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_171 (Oracle Corporation)"
)
@Component
public class EmEmployeesMapperImpl implements EmEmployeesMapper {

    @Autowired
    private EmEmpTypesMapper emEmpTypesMapper;
    @Autowired
    private EmStatusesMapper emStatusesMapper;

    @Override
    public List<EmEmployees> toEntity(List<EmEmployeesDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<EmEmployees> list = new ArrayList<EmEmployees>( dtoList.size() );
        for ( EmEmployeesDTO emEmployeesDTO : dtoList ) {
            list.add( toEntity( emEmployeesDTO ) );
        }

        return list;
    }

    @Override
    public List<EmEmployeesDTO> toDto(List<EmEmployees> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<EmEmployeesDTO> list = new ArrayList<EmEmployeesDTO>( entityList.size() );
        for ( EmEmployees emEmployees : entityList ) {
            list.add( toDto( emEmployees ) );
        }

        return list;
    }

    @Override
    public EmEmployeesDTO toDto(EmEmployees emEmployees) {
        if ( emEmployees == null ) {
            return null;
        }

        EmEmployeesDTO emEmployeesDTO = new EmEmployeesDTO();

        String name = emEmployeesIdStatusName( emEmployees );
        if ( name != null ) {
            emEmployeesDTO.setIdStatusName( name );
        }
        String name1 = emEmployeesIdEmploymentTypeName( emEmployees );
        if ( name1 != null ) {
            emEmployeesDTO.setIdEmploymentTypeName( name1 );
        }
        Long id = emEmployeesIdEmploymentTypeId( emEmployees );
        if ( id != null ) {
            emEmployeesDTO.setIdEmploymentTypeId( id );
        }
        Long id1 = emEmployeesIdStatusId( emEmployees );
        if ( id1 != null ) {
            emEmployeesDTO.setIdStatusId( id1 );
        }
        emEmployeesDTO.setId( emEmployees.getId() );
        emEmployeesDTO.setCode( emEmployees.getCode() );
        emEmployeesDTO.setName( emEmployees.getName() );
        emEmployeesDTO.setIdUser( emEmployees.getIdUser() );
        emEmployeesDTO.setMiddleName( emEmployees.getMiddleName() );
        emEmployeesDTO.setSurname( emEmployees.getSurname() );
        emEmployeesDTO.setMaidenName( emEmployees.getMaidenName() );
        emEmployeesDTO.setDisabilityDegree( emEmployees.getDisabilityDegree() );
        emEmployeesDTO.setEthnicGroup( emEmployees.getEthnicGroup() );
        emEmployeesDTO.setGender( emEmployees.getGender() );
        emEmployeesDTO.setResidentialSituation( emEmployees.getResidentialSituation() );
        emEmployeesDTO.setMaritalStatus( emEmployees.getMaritalStatus() );
        emEmployeesDTO.setBloodGroup( emEmployees.getBloodGroup() );
        emEmployeesDTO.setDateOfBirth( emEmployees.getDateOfBirth() );
        emEmployeesDTO.setHireDate( emEmployees.getHireDate() );
        emEmployeesDTO.setSsn( emEmployees.getSsn() );
        emEmployeesDTO.setTaxNumber( emEmployees.getTaxNumber() );
        emEmployeesDTO.setImagePath( emEmployees.getImagePath() );
        emEmployeesDTO.setPhoneNumber( emEmployees.getPhoneNumber() );
        emEmployeesDTO.setEmail( emEmployees.getEmail() );
        emEmployeesDTO.setPersonalPhoneNumber( emEmployees.getPersonalPhoneNumber() );
        emEmployeesDTO.setCreatedBy( emEmployees.getCreatedBy() );
        emEmployeesDTO.setCreatedAt( emEmployees.getCreatedAt() );
        emEmployeesDTO.setUpdatedBy( emEmployees.getUpdatedBy() );
        emEmployeesDTO.setUpdatedAt( emEmployees.getUpdatedAt() );
        emEmployeesDTO.setIdLegalEntity( emEmployees.getIdLegalEntity() );
        emEmployeesDTO.setIdQualification( emEmployees.getIdQualification() );
        emEmployeesDTO.setImageBlobContentType( emEmployees.getImageBlobContentType() );
        byte[] imageBlob = emEmployees.getImageBlob();
        if ( imageBlob != null ) {
            emEmployeesDTO.setImageBlob( Arrays.copyOf( imageBlob, imageBlob.length ) );
        }

        return emEmployeesDTO;
    }

    @Override
    public EmEmployees toEntity(EmEmployeesDTO emEmployeesDTO) {
        if ( emEmployeesDTO == null ) {
            return null;
        }

        EmEmployees emEmployees = new EmEmployees();

        emEmployees.setIdStatus( emStatusesMapper.fromId( emEmployeesDTO.getIdStatusId() ) );
        emEmployees.setIdEmploymentType( emEmpTypesMapper.fromId( emEmployeesDTO.getIdEmploymentTypeId() ) );
        emEmployees.setCreatedBy( emEmployeesDTO.getCreatedBy() );
        emEmployees.setCreatedAt( emEmployeesDTO.getCreatedAt() );
        emEmployees.setUpdatedBy( emEmployeesDTO.getUpdatedBy() );
        emEmployees.setUpdatedAt( emEmployeesDTO.getUpdatedAt() );
        emEmployees.setImageBlobContentType( emEmployeesDTO.getImageBlobContentType() );
        byte[] imageBlob = emEmployeesDTO.getImageBlob();
        if ( imageBlob != null ) {
            emEmployees.setImageBlob( Arrays.copyOf( imageBlob, imageBlob.length ) );
        }
        emEmployees.setId( emEmployeesDTO.getId() );
        emEmployees.setCode( emEmployeesDTO.getCode() );
        emEmployees.setName( emEmployeesDTO.getName() );
        emEmployees.setIdUser( emEmployeesDTO.getIdUser() );
        emEmployees.setMiddleName( emEmployeesDTO.getMiddleName() );
        emEmployees.setSurname( emEmployeesDTO.getSurname() );
        emEmployees.setMaidenName( emEmployeesDTO.getMaidenName() );
        emEmployees.setDisabilityDegree( emEmployeesDTO.getDisabilityDegree() );
        emEmployees.setEthnicGroup( emEmployeesDTO.getEthnicGroup() );
        emEmployees.setGender( emEmployeesDTO.getGender() );
        emEmployees.setResidentialSituation( emEmployeesDTO.getResidentialSituation() );
        emEmployees.setMaritalStatus( emEmployeesDTO.getMaritalStatus() );
        emEmployees.setBloodGroup( emEmployeesDTO.getBloodGroup() );
        emEmployees.setDateOfBirth( emEmployeesDTO.getDateOfBirth() );
        emEmployees.setHireDate( emEmployeesDTO.getHireDate() );
        emEmployees.setSsn( emEmployeesDTO.getSsn() );
        emEmployees.setTaxNumber( emEmployeesDTO.getTaxNumber() );
        emEmployees.setImagePath( emEmployeesDTO.getImagePath() );
        emEmployees.setPhoneNumber( emEmployeesDTO.getPhoneNumber() );
        emEmployees.setEmail( emEmployeesDTO.getEmail() );
        emEmployees.setPersonalPhoneNumber( emEmployeesDTO.getPersonalPhoneNumber() );
        emEmployees.setIdLegalEntity( emEmployeesDTO.getIdLegalEntity() );
        emEmployees.setIdQualification( emEmployeesDTO.getIdQualification() );

        return emEmployees;
    }

    private String emEmployeesIdStatusName(EmEmployees emEmployees) {
        if ( emEmployees == null ) {
            return null;
        }
        EmStatuses idStatus = emEmployees.getIdStatus();
        if ( idStatus == null ) {
            return null;
        }
        String name = idStatus.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String emEmployeesIdEmploymentTypeName(EmEmployees emEmployees) {
        if ( emEmployees == null ) {
            return null;
        }
        EmEmpTypes idEmploymentType = emEmployees.getIdEmploymentType();
        if ( idEmploymentType == null ) {
            return null;
        }
        String name = idEmploymentType.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private Long emEmployeesIdEmploymentTypeId(EmEmployees emEmployees) {
        if ( emEmployees == null ) {
            return null;
        }
        EmEmpTypes idEmploymentType = emEmployees.getIdEmploymentType();
        if ( idEmploymentType == null ) {
            return null;
        }
        Long id = idEmploymentType.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long emEmployeesIdStatusId(EmEmployees emEmployees) {
        if ( emEmployees == null ) {
            return null;
        }
        EmStatuses idStatus = emEmployees.getIdStatus();
        if ( idStatus == null ) {
            return null;
        }
        Long id = idStatus.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
