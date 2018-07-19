package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.EmEmpBankAccounts;
import com.infostudio.ba.domain.EmEmployees;
import com.infostudio.ba.service.dto.EmEmpBankAccountsDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-07-19T16:28:02+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
)
@Component
public class EmEmpBankAccountsMapperImpl implements EmEmpBankAccountsMapper {

    @Autowired
    private EmEmployeesMapper emEmployeesMapper;

    @Override
    public List<EmEmpBankAccounts> toEntity(List<EmEmpBankAccountsDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<EmEmpBankAccounts> list = new ArrayList<EmEmpBankAccounts>( dtoList.size() );
        for ( EmEmpBankAccountsDTO emEmpBankAccountsDTO : dtoList ) {
            list.add( toEntity( emEmpBankAccountsDTO ) );
        }

        return list;
    }

    @Override
    public List<EmEmpBankAccountsDTO> toDto(List<EmEmpBankAccounts> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<EmEmpBankAccountsDTO> list = new ArrayList<EmEmpBankAccountsDTO>( entityList.size() );
        for ( EmEmpBankAccounts emEmpBankAccounts : entityList ) {
            list.add( toDto( emEmpBankAccounts ) );
        }

        return list;
    }

    @Override
    public EmEmpBankAccountsDTO toDto(EmEmpBankAccounts emEmpBankAccounts) {
        if ( emEmpBankAccounts == null ) {
            return null;
        }

        EmEmpBankAccountsDTO emEmpBankAccountsDTO = new EmEmpBankAccountsDTO();

        Long id = emEmpBankAccountsIdEmployeeId( emEmpBankAccounts );
        if ( id != null ) {
            emEmpBankAccountsDTO.setIdEmployeeId( id );
        }
        emEmpBankAccountsDTO.setId( emEmpBankAccounts.getId() );
        emEmpBankAccountsDTO.setAccountNumber( emEmpBankAccounts.getAccountNumber() );
        emEmpBankAccountsDTO.setStatus( emEmpBankAccounts.getStatus() );
        emEmpBankAccountsDTO.setIdBank( emEmpBankAccounts.getIdBank() );

        return emEmpBankAccountsDTO;
    }

    @Override
    public EmEmpBankAccounts toEntity(EmEmpBankAccountsDTO emEmpBankAccountsDTO) {
        if ( emEmpBankAccountsDTO == null ) {
            return null;
        }

        EmEmpBankAccounts emEmpBankAccounts = new EmEmpBankAccounts();

        emEmpBankAccounts.setIdEmployee( emEmployeesMapper.fromId( emEmpBankAccountsDTO.getIdEmployeeId() ) );
        emEmpBankAccounts.setId( emEmpBankAccountsDTO.getId() );
        emEmpBankAccounts.setAccountNumber( emEmpBankAccountsDTO.getAccountNumber() );
        emEmpBankAccounts.setStatus( emEmpBankAccountsDTO.getStatus() );
        emEmpBankAccounts.setIdBank( emEmpBankAccountsDTO.getIdBank() );

        return emEmpBankAccounts;
    }

    private Long emEmpBankAccountsIdEmployeeId(EmEmpBankAccounts emEmpBankAccounts) {
        if ( emEmpBankAccounts == null ) {
            return null;
        }
        EmEmployees idEmployee = emEmpBankAccounts.getIdEmployee();
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
