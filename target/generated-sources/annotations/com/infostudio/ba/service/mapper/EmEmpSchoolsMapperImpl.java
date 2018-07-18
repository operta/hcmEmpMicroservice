package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.EmEmpSchools;
import com.infostudio.ba.domain.EmEmployees;
import com.infostudio.ba.service.dto.EmEmpSchoolsDTO;
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
public class EmEmpSchoolsMapperImpl implements EmEmpSchoolsMapper {

    @Autowired
    private EmEmployeesMapper emEmployeesMapper;

    @Override
    public List<EmEmpSchools> toEntity(List<EmEmpSchoolsDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<EmEmpSchools> list = new ArrayList<EmEmpSchools>( dtoList.size() );
        for ( EmEmpSchoolsDTO emEmpSchoolsDTO : dtoList ) {
            list.add( toEntity( emEmpSchoolsDTO ) );
        }

        return list;
    }

    @Override
    public List<EmEmpSchoolsDTO> toDto(List<EmEmpSchools> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<EmEmpSchoolsDTO> list = new ArrayList<EmEmpSchoolsDTO>( entityList.size() );
        for ( EmEmpSchools emEmpSchools : entityList ) {
            list.add( toDto( emEmpSchools ) );
        }

        return list;
    }

    @Override
    public EmEmpSchoolsDTO toDto(EmEmpSchools emEmpSchools) {
        if ( emEmpSchools == null ) {
            return null;
        }

        EmEmpSchoolsDTO emEmpSchoolsDTO = new EmEmpSchoolsDTO();

        Long id = emEmpSchoolsIdEmployeeId( emEmpSchools );
        if ( id != null ) {
            emEmpSchoolsDTO.setIdEmployeeId( id );
        }
        emEmpSchoolsDTO.setId( emEmpSchools.getId() );
        emEmpSchoolsDTO.setDateFrom( emEmpSchools.getDateFrom() );
        emEmpSchoolsDTO.setDateTo( emEmpSchools.getDateTo() );
        emEmpSchoolsDTO.setMajor( emEmpSchools.getMajor() );
        emEmpSchoolsDTO.setDegree( emEmpSchools.getDegree() );
        emEmpSchoolsDTO.setGrade( emEmpSchools.getGrade() );
        emEmpSchoolsDTO.setDescription( emEmpSchools.getDescription() );
        emEmpSchoolsDTO.setCreatedBy( emEmpSchools.getCreatedBy() );
        emEmpSchoolsDTO.setCreatedAt( emEmpSchools.getCreatedAt() );
        emEmpSchoolsDTO.setUpdatedBy( emEmpSchools.getUpdatedBy() );
        emEmpSchoolsDTO.setUpdatedAt( emEmpSchools.getUpdatedAt() );
        emEmpSchoolsDTO.setIdSchool( emEmpSchools.getIdSchool() );
        emEmpSchoolsDTO.setIdQualification( emEmpSchools.getIdQualification() );

        return emEmpSchoolsDTO;
    }

    @Override
    public EmEmpSchools toEntity(EmEmpSchoolsDTO emEmpSchoolsDTO) {
        if ( emEmpSchoolsDTO == null ) {
            return null;
        }

        EmEmpSchools emEmpSchools = new EmEmpSchools();

        emEmpSchools.setIdEmployee( emEmployeesMapper.fromId( emEmpSchoolsDTO.getIdEmployeeId() ) );
        emEmpSchools.setCreatedBy( emEmpSchoolsDTO.getCreatedBy() );
        emEmpSchools.setCreatedAt( emEmpSchoolsDTO.getCreatedAt() );
        emEmpSchools.setUpdatedBy( emEmpSchoolsDTO.getUpdatedBy() );
        emEmpSchools.setUpdatedAt( emEmpSchoolsDTO.getUpdatedAt() );
        emEmpSchools.setId( emEmpSchoolsDTO.getId() );
        emEmpSchools.setDateFrom( emEmpSchoolsDTO.getDateFrom() );
        emEmpSchools.setDateTo( emEmpSchoolsDTO.getDateTo() );
        emEmpSchools.setMajor( emEmpSchoolsDTO.getMajor() );
        emEmpSchools.setDegree( emEmpSchoolsDTO.getDegree() );
        emEmpSchools.setGrade( emEmpSchoolsDTO.getGrade() );
        emEmpSchools.setDescription( emEmpSchoolsDTO.getDescription() );
        emEmpSchools.setIdSchool( emEmpSchoolsDTO.getIdSchool() );
        emEmpSchools.setIdQualification( emEmpSchoolsDTO.getIdQualification() );

        return emEmpSchools;
    }

    private Long emEmpSchoolsIdEmployeeId(EmEmpSchools emEmpSchools) {
        if ( emEmpSchools == null ) {
            return null;
        }
        EmEmployees idEmployee = emEmpSchools.getIdEmployee();
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
