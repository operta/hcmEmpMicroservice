package com.infostudio.ba.service.mapper;

import com.infostudio.ba.domain.*;
import com.infostudio.ba.service.dto.EmEmpBankAccountsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity EmEmpBankAccounts and its DTO EmEmpBankAccountsDTO.
 */
@Mapper(componentModel = "spring", uses = {EmEmployeesMapper.class})
public interface EmEmpBankAccountsMapper extends EntityMapper<EmEmpBankAccountsDTO, EmEmpBankAccounts> {

    @Mapping(source = "idEmployee.id", target = "idEmployeeId")
    EmEmpBankAccountsDTO toDto(EmEmpBankAccounts emEmpBankAccounts);

    @Mapping(source = "idEmployeeId", target = "idEmployee")
    EmEmpBankAccounts toEntity(EmEmpBankAccountsDTO emEmpBankAccountsDTO);

    default EmEmpBankAccounts fromId(Long id) {
        if (id == null) {
            return null;
        }
        EmEmpBankAccounts emEmpBankAccounts = new EmEmpBankAccounts();
        emEmpBankAccounts.setId(id);
        return emEmpBankAccounts;
    }
}
