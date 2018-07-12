package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.EmContractTypes;
import com.infostudio.ba.domain.EmEmpSalaries;
import com.infostudio.ba.domain.EmEmployees;
import com.infostudio.ba.service.dto.EmEmpSalariesDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-07-12T15:45:59+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
)
@Component
public class EmEmpSalariesMapperImpl implements EmEmpSalariesMapper {

    @Autowired
    private EmEmployeesMapper emEmployeesMapper;
    @Autowired
    private EmContractTypesMapper emContractTypesMapper;

    @Override
    public List<EmEmpSalaries> toEntity(List<EmEmpSalariesDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<EmEmpSalaries> list = new ArrayList<EmEmpSalaries>( dtoList.size() );
        for ( EmEmpSalariesDTO emEmpSalariesDTO : dtoList ) {
            list.add( toEntity( emEmpSalariesDTO ) );
        }

        return list;
    }

    @Override
    public List<EmEmpSalariesDTO> toDto(List<EmEmpSalaries> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<EmEmpSalariesDTO> list = new ArrayList<EmEmpSalariesDTO>( entityList.size() );
        for ( EmEmpSalaries emEmpSalaries : entityList ) {
            list.add( toDto( emEmpSalaries ) );
        }

        return list;
    }

    @Override
    public EmEmpSalariesDTO toDto(EmEmpSalaries emEmpSalaries) {
        if ( emEmpSalaries == null ) {
            return null;
        }

        EmEmpSalariesDTO emEmpSalariesDTO = new EmEmpSalariesDTO();

        String name = emEmpSalariesIdContractTypeName( emEmpSalaries );
        if ( name != null ) {
            emEmpSalariesDTO.setIdContractTypeName( name );
        }
        Long id = emEmpSalariesIdContractTypeId( emEmpSalaries );
        if ( id != null ) {
            emEmpSalariesDTO.setIdContractTypeId( id );
        }
        Long id1 = emEmpSalariesIdEmployeeId( emEmpSalaries );
        if ( id1 != null ) {
            emEmpSalariesDTO.setIdEmployeeId( id1 );
        }
        emEmpSalariesDTO.setId( emEmpSalaries.getId() );
        emEmpSalariesDTO.setDateFrom( emEmpSalaries.getDateFrom() );
        emEmpSalariesDTO.setDateTo( emEmpSalaries.getDateTo() );
        emEmpSalariesDTO.setSalaryAmount( emEmpSalaries.getSalaryAmount() );
        emEmpSalariesDTO.setSalaryCoefficient( emEmpSalaries.getSalaryCoefficient() );
        emEmpSalariesDTO.setWorkHistoryCoefficient( emEmpSalaries.getWorkHistoryCoefficient() );
        emEmpSalariesDTO.setCreatedBy( emEmpSalaries.getCreatedBy() );
        emEmpSalariesDTO.setCreatedAt( emEmpSalaries.getCreatedAt() );
        emEmpSalariesDTO.setUpdatedBy( emEmpSalaries.getUpdatedBy() );
        emEmpSalariesDTO.setUpdatedAt( emEmpSalaries.getUpdatedAt() );
        emEmpSalariesDTO.setIdWorkPlace( emEmpSalaries.getIdWorkPlace() );

        return emEmpSalariesDTO;
    }

    @Override
    public EmEmpSalaries toEntity(EmEmpSalariesDTO emEmpSalariesDTO) {
        if ( emEmpSalariesDTO == null ) {
            return null;
        }

        EmEmpSalaries emEmpSalaries = new EmEmpSalaries();

        emEmpSalaries.setIdContractType( emContractTypesMapper.fromId( emEmpSalariesDTO.getIdContractTypeId() ) );
        emEmpSalaries.setIdEmployee( emEmployeesMapper.fromId( emEmpSalariesDTO.getIdEmployeeId() ) );
        emEmpSalaries.setCreatedBy( emEmpSalariesDTO.getCreatedBy() );
        emEmpSalaries.setCreatedAt( emEmpSalariesDTO.getCreatedAt() );
        emEmpSalaries.setUpdatedBy( emEmpSalariesDTO.getUpdatedBy() );
        emEmpSalaries.setUpdatedAt( emEmpSalariesDTO.getUpdatedAt() );
        emEmpSalaries.setId( emEmpSalariesDTO.getId() );
        emEmpSalaries.setDateFrom( emEmpSalariesDTO.getDateFrom() );
        emEmpSalaries.setDateTo( emEmpSalariesDTO.getDateTo() );
        emEmpSalaries.setSalaryAmount( emEmpSalariesDTO.getSalaryAmount() );
        emEmpSalaries.setSalaryCoefficient( emEmpSalariesDTO.getSalaryCoefficient() );
        emEmpSalaries.setWorkHistoryCoefficient( emEmpSalariesDTO.getWorkHistoryCoefficient() );
        emEmpSalaries.setIdWorkPlace( emEmpSalariesDTO.getIdWorkPlace() );

        return emEmpSalaries;
    }

    private String emEmpSalariesIdContractTypeName(EmEmpSalaries emEmpSalaries) {
        if ( emEmpSalaries == null ) {
            return null;
        }
        EmContractTypes idContractType = emEmpSalaries.getIdContractType();
        if ( idContractType == null ) {
            return null;
        }
        String name = idContractType.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private Long emEmpSalariesIdContractTypeId(EmEmpSalaries emEmpSalaries) {
        if ( emEmpSalaries == null ) {
            return null;
        }
        EmContractTypes idContractType = emEmpSalaries.getIdContractType();
        if ( idContractType == null ) {
            return null;
        }
        Long id = idContractType.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long emEmpSalariesIdEmployeeId(EmEmpSalaries emEmpSalaries) {
        if ( emEmpSalaries == null ) {
            return null;
        }
        EmEmployees idEmployee = emEmpSalaries.getIdEmployee();
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
