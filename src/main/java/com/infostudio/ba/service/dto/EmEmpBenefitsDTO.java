package com.infostudio.ba.service.dto;


import java.time.Instant;
import java.time.LocalDate;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the EmEmpBenefits entity.
 */
public class EmEmpBenefitsDTO implements Serializable {

    private Long id;

    private LocalDate dateFrom;

    private LocalDate dateTo;

    private Integer amount;

    private Long emEmployeesId;

    private Long emBenefitTypesId;

    private Instant createdAt;

    private Instant updatedAt;

    private String createdBy;

    private String updatedBy;

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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Long getEmEmployeesId() {
        return emEmployeesId;
    }

    public void setEmEmployeesId(Long emEmployeesId) {
        this.emEmployeesId = emEmployeesId;
    }

    public Long getEmBenefitTypesId() {
        return emBenefitTypesId;
    }

    public void setEmBenefitTypesId(Long emBenefitTypesId) {
        this.emBenefitTypesId = emBenefitTypesId;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        EmEmpBenefitsDTO emEmpBenefitsDTO = (EmEmpBenefitsDTO) o;
        if(emEmpBenefitsDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), emEmpBenefitsDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "EmEmpBenefitsDTO{" +
                "id=" + id +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                ", amount=" + amount +
                ", emEmployeesId=" + emEmployeesId +
                ", emBenefitTypesId=" + emBenefitTypesId +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                '}';
    }
}
