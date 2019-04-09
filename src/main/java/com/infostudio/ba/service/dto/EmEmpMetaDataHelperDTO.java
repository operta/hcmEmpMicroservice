package com.infostudio.ba.service.dto;


import com.infostudio.ba.domain.Detail;

public class EmEmpMetaDataHelperDTO {

    private Detail[] details;

    private Long idEmployee;

    public Detail[] getDetails() {
        return details;
    }

    public void setDetails(Detail[] details) {
        this.details = details;
    }

    public Long getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Long idEmployee) {
        this.idEmployee = idEmployee;
    }
}
