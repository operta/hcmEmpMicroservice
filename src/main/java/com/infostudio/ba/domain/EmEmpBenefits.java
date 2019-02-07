package com.infostudio.ba.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A EmEmpBenefits.
 */
@Entity
@Table(name = "em_emp_benefits")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class EmEmpBenefits extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "date_from")
    private LocalDate dateFrom;

    @Column(name = "date_to")
    private LocalDate dateTo;

    @Column(name = "amount")
    private Integer amount;

    @ManyToOne
    @JoinColumn(name = "id_employee")
    private EmEmployees emEmployees;

    @ManyToOne
    @JoinColumn(name = "id_benefit_type")
    private EmBenefitTypes emBenefitTypes;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public EmEmpBenefits date_from(LocalDate date_from) {
        this.dateFrom = date_from;
        return this;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public EmEmpBenefits date_to(LocalDate date_to) {
        this.dateTo = date_to;
        return this;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public Integer getAmount() {
        return amount;
    }

    public EmEmpBenefits amount(Integer amount) {
        this.amount = amount;
        return this;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public EmEmployees getEmEmployees() {
        return emEmployees;
    }

    public EmEmpBenefits emEmployees(EmEmployees emEmployees) {
        this.emEmployees = emEmployees;
        return this;
    }

    public void setEmEmployees(EmEmployees emEmployees) {
        this.emEmployees = emEmployees;
    }

    public EmBenefitTypes getEmBenefitTypes() {
        return emBenefitTypes;
    }

    public EmEmpBenefits emBenefitTypes(EmBenefitTypes emBenefitTypes) {
        this.emBenefitTypes = emBenefitTypes;
        return this;
    }

    public void setEmBenefitTypes(EmBenefitTypes emBenefitTypes) {
        this.emBenefitTypes = emBenefitTypes;
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
        EmEmpBenefits emEmpBenefits = (EmEmpBenefits) o;
        if (emEmpBenefits.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), emEmpBenefits.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "EmEmpBenefits{" +
            "id=" + getId() +
            ", dateFrom='" + getDateFrom() + "'" +
            ", dateTo='" + getDateTo() + "'" +
            ", amount=" + getAmount() +
            "}";
    }
}
