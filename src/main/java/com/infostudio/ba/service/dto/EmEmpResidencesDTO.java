package com.infostudio.ba.service.dto;


import com.infostudio.ba.domain.EmEmployees;

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

    private LocalDate dateTo;

    private String addressWork;

    private String createdBy;

    private Instant createdAt;

    private String updatedBy;

    private Instant updatedAt;

    private EmEmployees idEmployee;

    private Integer idCountry;

    private Integer idRegion;

    private Integer idCity;

    private Integer idCountryWork;

    private Integer idRegionWork;

    private Integer idCityWork;

    public Integer getIdCountryWork() {
        return idCountryWork;
    }

    public void setIdCountryWork(Integer idCountryWork) {
        this.idCountryWork = idCountryWork;
    }

    public Integer getIdRegionWork() {
        return idRegionWork;
    }

    public void setIdRegionWork(Integer idRegionWork) {
        this.idRegionWork = idRegionWork;
    }

    public Integer getIdCityWork() {
        return idCityWork;
    }

    public void setIdCityWork(Integer idCityWork) {
        this.idCityWork = idCityWork;
    }

    public Long getId() {
        return id;
    }

    public EmEmployees getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(EmEmployees idEmployee) {
        this.idEmployee = idEmployee;
    }

    public Integer getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(Integer idCountry) {
        this.idCountry = idCountry;
    }

    public Integer getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(Integer idRegion) {
        this.idRegion = idRegion;
    }

    public Integer getIdCity() {
        return idCity;
    }

    public void setIdCity(Integer idCity) {
        this.idCity = idCity;
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

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
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
            ", dateTo='" + getDateTo() + "'" +
            ", addressWork='" + getAddressWork() + "'" +
            ", createdBy='" + getCreatedBy() + "'" +
            ", createdAt='" + getCreatedAt() + "'" +
            ", updatedBy='" + getUpdatedBy() + "'" +
            ", updatedAt='" + getUpdatedAt() + "'" +
            "}";
    }
}
