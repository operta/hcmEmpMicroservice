package com.infostudio.ba.service.dto;


import java.time.Instant;
import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A DTO for the EmEmpIdentifications entity.
 */
public class EmEmpIdentificationsDTO implements Serializable {

    private Long id;

    @NotNull
    private String identificationNumber;

    private String jurisdiction;

    private LocalDate validThrough;

    private String createdBy;

    private Instant createdAt;

    private String updatedBy;

    private Instant updatedAt;

    private Integer idIdentification;

    private Integer idRegion;

    private Long idEmployeeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    public LocalDate getValidThrough() {
        return validThrough;
    }

    public void setValidThrough(LocalDate validThrough) {
        this.validThrough = validThrough;
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

    public Integer getIdIdentification() {
        return idIdentification;
    }

    public void setIdIdentification(Integer idIdentification) {
        this.idIdentification = idIdentification;
    }

    public Integer getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(Integer idRegion) {
        this.idRegion = idRegion;
    }

    public Long getIdEmployeeId() {
        return idEmployeeId;
    }

    public void setIdEmployeeId(Long emEmployeesId) {
        this.idEmployeeId = emEmployeesId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        EmEmpIdentificationsDTO emEmpIdentificationsDTO = (EmEmpIdentificationsDTO) o;
        if(emEmpIdentificationsDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), emEmpIdentificationsDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "EmEmpIdentificationsDTO{" +
            "id=" + getId() +
            ", identificationNumber='" + getIdentificationNumber() + "'" +
            ", jurisdiction='" + getJurisdiction() + "'" +
            ", validThrough='" + getValidThrough() + "'" +
            ", createdBy='" + getCreatedBy() + "'" +
            ", createdAt='" + getCreatedAt() + "'" +
            ", updatedBy='" + getUpdatedBy() + "'" +
            ", updatedAt='" + getUpdatedAt() + "'" +
            ", idIdentification=" + getIdIdentification() +
            ", idRegion=" + getIdRegion() +
            "}";
    }
}
