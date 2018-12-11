package com.infostudio.ba.service.dto;


import java.time.LocalDate;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the EmEmpTax entity.
 */
public class EmEmpTaxDTO implements Serializable {

    private Long id;

    private Double taxReductionCoefficient;

    private Double baseTaxReductionAmount;

    private Double optionalTaxReductionAmount;

    private LocalDate dateFrom;

    private LocalDate dateTo;

    private Integer idEmployee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTaxReductionCoefficient() {
        return taxReductionCoefficient;
    }

    public void setTaxReductionCoefficient(Double taxReductionCoefficient) {
        this.taxReductionCoefficient = taxReductionCoefficient;
    }

    public Double getBaseTaxReductionAmount() {
        return baseTaxReductionAmount;
    }

    public void setBaseTaxReductionAmount(Double baseTaxReductionAmount) {
        this.baseTaxReductionAmount = baseTaxReductionAmount;
    }

    public Double getOptionalTaxReductionAmount() {
        return optionalTaxReductionAmount;
    }

    public void setOptionalTaxReductionAmount(Double optionalTaxReductionAmount) {
        this.optionalTaxReductionAmount = optionalTaxReductionAmount;
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

    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        EmEmpTaxDTO emEmpTaxDTO = (EmEmpTaxDTO) o;
        if(emEmpTaxDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), emEmpTaxDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "EmEmpTaxDTO{" +
            "id=" + getId() +
            ", taxReductionCoefficient=" + getTaxReductionCoefficient() +
            ", baseTaxReductionAmount=" + getBaseTaxReductionAmount() +
            ", optionalTaxReductionAmount=" + getOptionalTaxReductionAmount() +
            ", dateFrom='" + getDateFrom() + "'" +
            ", dateTo='" + getDateTo() + "'" +
            ", idEmployee=" + getIdEmployee() +
            "}";
    }
}
