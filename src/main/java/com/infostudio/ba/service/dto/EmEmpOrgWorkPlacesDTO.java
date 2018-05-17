package com.infostudio.ba.service.dto;


import java.time.Instant;
import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A DTO for the EmEmpOrgWorkPlaces entity.
 */
public class EmEmpOrgWorkPlacesDTO implements Serializable {

    private Long id;

    @NotNull
    private LocalDate dateFrom;

    private LocalDate dateTo;

    private Integer workHistoryCoefficient;

    private String createdBy;

    private Instant createdAt;

    private String updatedBy;

    private Instant updatedAt;

    private Integer idOrgWorkPlace;

    private Long idEmployeeId;

    private Long idContractTypeId;

    private String idContractTypeName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public Integer getWorkHistoryCoefficient() {
        return workHistoryCoefficient;
    }

    public void setWorkHistoryCoefficient(Integer workHistoryCoefficient) {
        this.workHistoryCoefficient = workHistoryCoefficient;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getIdOrgWorkPlace() {
        return idOrgWorkPlace;
    }

    public void setIdOrgWorkPlace(Integer idOrgWorkPlace) {
        this.idOrgWorkPlace = idOrgWorkPlace;
    }

    public Long getIdEmployeeId() {
        return idEmployeeId;
    }

    public void setIdEmployeeId(Long emEmployeesId) {
        this.idEmployeeId = emEmployeesId;
    }

    public Long getIdContractTypeId() {
        return idContractTypeId;
    }

    public void setIdContractTypeId(Long emContractTypesId) {
        this.idContractTypeId = emContractTypesId;
    }

    public String getIdContractTypeName() {
        return idContractTypeName;
    }

    public void setIdContractTypeName(String emContractTypesName) {
        this.idContractTypeName = emContractTypesName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        EmEmpOrgWorkPlacesDTO emEmpOrgWorkPlacesDTO = (EmEmpOrgWorkPlacesDTO) o;
        if(emEmpOrgWorkPlacesDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), emEmpOrgWorkPlacesDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "EmEmpOrgWorkPlacesDTO{" +
            "id=" + getId() +
            ", dateFrom='" + getDateFrom() + "'" +
            ", dateTo='" + getDateTo() + "'" +
            ", workHistoryCoefficient=" + getWorkHistoryCoefficient() +
            ", createdBy='" + getCreatedBy() + "'" +
            ", createdAt='" + getCreatedAt() + "'" +
            ", updatedBy='" + getUpdatedBy() + "'" +
            ", updatedAt='" + getUpdatedAt() + "'" +
            ", idOrgWorkPlace=" + getIdOrgWorkPlace() +
            "}";
    }
}
