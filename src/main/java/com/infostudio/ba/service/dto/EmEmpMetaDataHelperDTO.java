package com.infostudio.ba.service.dto;

import java.util.Arrays;

public class EmEmpMetaDataHelperDTO {

    private Long[] detailsIds;

    private Long idEmployee;

    public Long[] getDetailsIds() {
        return detailsIds;
    }

    public void setDetailsIds(Long[] detailsIds) {
        this.detailsIds = detailsIds;
    }

    public Long getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Long idEmployee) {
        this.idEmployee = idEmployee;
    }

    @Override
    public String toString() {
        return "EmEmpMetaDataHelperDTO{" +
                "detailsIds=" + Arrays.toString(detailsIds) +
                ", idEmployee=" + idEmployee +
                '}';
    }
}
