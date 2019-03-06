package com.infostudio.ba.service.dto;

import java.util.Arrays;

public class EmEmpMetaDataHelperDTO {

    private Long[] detailsIds;

    private Long employeeId;

    public Long[] getDetailsIds() {
        return detailsIds;
    }

    public void setDetailsIds(Long[] detailsIds) {
        this.detailsIds = detailsIds;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long idEmployee) {
        this.employeeId = idEmployee;
    }

    @Override
    public String toString() {
        return "EmEmpMetaDataHelperDTO{" +
                "detailsIds=" + Arrays.toString(detailsIds) +
                ", idEmployee=" + employeeId +
                '}';
    }
}
