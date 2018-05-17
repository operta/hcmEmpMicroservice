package com.infostudio.ba.service.dto;


import java.time.Instant;
import java.time.LocalDate;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the EmEmpResidences entity.
 */
public class EmEmpResidencesDTO implements Serializable {

    private Long id;

    private String address;

    private LocalDate dateFrom;

    private LocalDate datoTo;

    private String addressWork;

    private String createdBy;

    private Instant createdAt;

    private String updatedBy;

    private Instant updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDatoTo() {
        return datoTo;
    }

    public void setDatoTo(LocalDate datoTo) {
        this.datoTo = datoTo;
    }

    public String getAddressWork() {
        return addressWork;
    }

    public void setAddressWork(String addressWork) {
        this.addressWork = addressWork;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        EmEmpResidencesDTO emEmpResidencesDTO = (EmEmpResidencesDTO) o;
        if(emEmpResidencesDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), emEmpResidencesDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "EmEmpResidencesDTO{" +
            "id=" + getId() +
            ", address='" + getAddress() + "'" +
            ", dateFrom='" + getDateFrom() + "'" +
            ", datoTo='" + getDatoTo() + "'" +
            ", addressWork='" + getAddressWork() + "'" +
            ", createdBy='" + getCreatedBy() + "'" +
            ", createdAt='" + getCreatedAt() + "'" +
            ", updatedBy='" + getUpdatedBy() + "'" +
            ", updatedAt='" + getUpdatedAt() + "'" +
            "}";
    }
}
