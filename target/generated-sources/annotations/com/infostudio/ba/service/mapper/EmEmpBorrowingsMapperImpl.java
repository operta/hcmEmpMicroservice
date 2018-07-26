package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.EmBorrowingTypes;
import com.infostudio.ba.domain.EmEmpBorrowings;
import com.infostudio.ba.domain.EmEmployees;
import com.infostudio.ba.service.dto.EmEmpBorrowingsDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-07-26T11:29:24+0200",
    comments = "version: 1.2.0.Final, compiler: Eclipse JDT (IDE) 1.3.200.v20180612-0641, environment: Java 1.8.0_151 (Oracle Corporation)"
)
@Component
public class EmEmpBorrowingsMapperImpl implements EmEmpBorrowingsMapper {

    @Autowired
    private EmEmployeesMapper emEmployeesMapper;
    @Autowired
    private EmBorrowingTypesMapper emBorrowingTypesMapper;

    @Override
    public List<EmEmpBorrowings> toEntity(List<EmEmpBorrowingsDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<EmEmpBorrowings> list = new ArrayList<EmEmpBorrowings>( dtoList.size() );
        for ( EmEmpBorrowingsDTO emEmpBorrowingsDTO : dtoList ) {
            list.add( toEntity( emEmpBorrowingsDTO ) );
        }

        return list;
    }

    @Override
    public List<EmEmpBorrowingsDTO> toDto(List<EmEmpBorrowings> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<EmEmpBorrowingsDTO> list = new ArrayList<EmEmpBorrowingsDTO>( entityList.size() );
        for ( EmEmpBorrowings emEmpBorrowings : entityList ) {
            list.add( toDto( emEmpBorrowings ) );
        }

        return list;
    }

    @Override
    public EmEmpBorrowingsDTO toDto(EmEmpBorrowings emEmpBorrowings) {
        if ( emEmpBorrowings == null ) {
            return null;
        }

        EmEmpBorrowingsDTO emEmpBorrowingsDTO = new EmEmpBorrowingsDTO();

        Long id = emEmpBorrowingsIdBorrowingId( emEmpBorrowings );
        if ( id != null ) {
            emEmpBorrowingsDTO.setIdBorrowingId( id );
        }
        String name = emEmpBorrowingsIdBorrowingName( emEmpBorrowings );
        if ( name != null ) {
            emEmpBorrowingsDTO.setIdBorrowingName( name );
        }
        Long id1 = emEmpBorrowingsIdEmployeeId( emEmpBorrowings );
        if ( id1 != null ) {
            emEmpBorrowingsDTO.setIdEmployeeId( id1 );
        }
        emEmpBorrowingsDTO.setId( emEmpBorrowings.getId() );
        emEmpBorrowingsDTO.setTitle( emEmpBorrowings.getTitle() );
        emEmpBorrowingsDTO.setDescription( emEmpBorrowings.getDescription() );
        emEmpBorrowingsDTO.setSerialNumber( emEmpBorrowings.getSerialNumber() );
        emEmpBorrowingsDTO.setDateFrom( emEmpBorrowings.getDateFrom() );
        emEmpBorrowingsDTO.setChargedBy( emEmpBorrowings.getChargedBy() );
        emEmpBorrowingsDTO.setDateTo( emEmpBorrowings.getDateTo() );
        emEmpBorrowingsDTO.setDischargedBy( emEmpBorrowings.getDischargedBy() );
        emEmpBorrowingsDTO.setDamage( emEmpBorrowings.getDamage() );
        emEmpBorrowingsDTO.setDamagedByEmployee( emEmpBorrowings.getDamagedByEmployee() );
        emEmpBorrowingsDTO.setCreatedBy( emEmpBorrowings.getCreatedBy() );
        emEmpBorrowingsDTO.setCreatedAt( emEmpBorrowings.getCreatedAt() );
        emEmpBorrowingsDTO.setUpdatedBy( emEmpBorrowings.getUpdatedBy() );
        emEmpBorrowingsDTO.setUpdatedAt( emEmpBorrowings.getUpdatedAt() );

        return emEmpBorrowingsDTO;
    }

    @Override
    public EmEmpBorrowings toEntity(EmEmpBorrowingsDTO emEmpBorrowingsDTO) {
        if ( emEmpBorrowingsDTO == null ) {
            return null;
        }

        EmEmpBorrowings emEmpBorrowings = new EmEmpBorrowings();

        emEmpBorrowings.setIdEmployee( emEmployeesMapper.fromId( emEmpBorrowingsDTO.getIdEmployeeId() ) );
        emEmpBorrowings.setIdBorrowing( emBorrowingTypesMapper.fromId( emEmpBorrowingsDTO.getIdBorrowingId() ) );
        emEmpBorrowings.setCreatedBy( emEmpBorrowingsDTO.getCreatedBy() );
        emEmpBorrowings.setCreatedAt( emEmpBorrowingsDTO.getCreatedAt() );
        emEmpBorrowings.setUpdatedBy( emEmpBorrowingsDTO.getUpdatedBy() );
        emEmpBorrowings.setUpdatedAt( emEmpBorrowingsDTO.getUpdatedAt() );
        emEmpBorrowings.setId( emEmpBorrowingsDTO.getId() );
        emEmpBorrowings.setTitle( emEmpBorrowingsDTO.getTitle() );
        emEmpBorrowings.setDescription( emEmpBorrowingsDTO.getDescription() );
        emEmpBorrowings.setSerialNumber( emEmpBorrowingsDTO.getSerialNumber() );
        emEmpBorrowings.setDateFrom( emEmpBorrowingsDTO.getDateFrom() );
        emEmpBorrowings.setChargedBy( emEmpBorrowingsDTO.getChargedBy() );
        emEmpBorrowings.setDateTo( emEmpBorrowingsDTO.getDateTo() );
        emEmpBorrowings.setDischargedBy( emEmpBorrowingsDTO.getDischargedBy() );
        emEmpBorrowings.setDamage( emEmpBorrowingsDTO.getDamage() );
        emEmpBorrowings.setDamagedByEmployee( emEmpBorrowingsDTO.getDamagedByEmployee() );

        return emEmpBorrowings;
    }

    private Long emEmpBorrowingsIdBorrowingId(EmEmpBorrowings emEmpBorrowings) {
        if ( emEmpBorrowings == null ) {
            return null;
        }
        EmBorrowingTypes idBorrowing = emEmpBorrowings.getIdBorrowing();
        if ( idBorrowing == null ) {
            return null;
        }
        Long id = idBorrowing.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String emEmpBorrowingsIdBorrowingName(EmEmpBorrowings emEmpBorrowings) {
        if ( emEmpBorrowings == null ) {
            return null;
        }
        EmBorrowingTypes idBorrowing = emEmpBorrowings.getIdBorrowing();
        if ( idBorrowing == null ) {
            return null;
        }
        String name = idBorrowing.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private Long emEmpBorrowingsIdEmployeeId(EmEmpBorrowings emEmpBorrowings) {
        if ( emEmpBorrowings == null ) {
            return null;
        }
        EmEmployees idEmployee = emEmpBorrowings.getIdEmployee();
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
