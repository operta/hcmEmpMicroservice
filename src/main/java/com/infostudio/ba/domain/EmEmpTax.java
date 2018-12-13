package com.infostudio.ba.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A EmEmpTax.
 */
@Entity
@Table(name = "em_emp_tax")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class EmEmpTax extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "tax_reduction_coefficient")
    private Double taxReductionCoefficient;

    @Column(name = "base_tax_reduction_amount")
    private Double baseTaxReductionAmount;

    @Column(name = "optional_tax_reduction_amount")
    private Double optionalTaxReductionAmount;

    @Column(name = "date_from")
    private LocalDate dateFrom;

    @Column(name = "date_to")
    private LocalDate dateTo;

    @Column(name = "id_employee")
    private Integer idEmployee;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTaxReductionCoefficient() {
        return taxReductionCoefficient;
    }

    public EmEmpTax taxReductionCoefficient(Double taxReductionCoefficient) {
        this.taxReductionCoefficient = taxReductionCoefficient;
        return this;
    }

    public void setTaxReductionCoefficient(Double taxReductionCoefficient) {
        this.taxReductionCoefficient = taxReductionCoefficient;
    }

    public Double getBaseTaxReductionAmount() {
        return baseTaxReductionAmount;
    }

    public EmEmpTax baseTaxReductionAmount(Double baseTaxReductionAmount) {
        this.baseTaxReductionAmount = baseTaxReductionAmount;
        return this;
    }

    public void setBaseTaxReductionAmount(Double baseTaxReductionAmount) {
        this.baseTaxReductionAmount = baseTaxReductionAmount;
    }

    public Double getOptionalTaxReductionAmount() {
        return optionalTaxReductionAmount;
    }

    public EmEmpTax optionalTaxReductionAmount(Double optionalTaxReductionAmount) {
        this.optionalTaxReductionAmount = optionalTaxReductionAmount;
        return this;
    }

    public void setOptionalTaxReductionAmount(Double optionalTaxReductionAmount) {
        this.optionalTaxReductionAmount = optionalTaxReductionAmount;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public EmEmpTax dateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
        return this;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public EmEmpTax dateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
        return this;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public Integer getIdEmployee() {
        return idEmployee;
    }

    public EmEmpTax idEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
        return this;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EmEmpTax emEmpTax = (EmEmpTax) o;
        if (emEmpTax.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), emEmpTax.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "EmEmpTax{" +
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
