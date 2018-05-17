package com.infostudio.ba.service.dto;


import java.time.Instant;
import java.time.LocalDate;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A DTO for the EmEmpRewards entity.
 */
public class EmEmpRewardsDTO implements Serializable {

    private Long id;

    private String description;

    private LocalDate dateReward;

    private Integer amount;

    private String rewardedBy;

    private String createdBy;

    private Instant createdAt;

    private String updatedBy;

    private Instant updatedAt;

    private Long idEmployeeId;

    private Long idRewardId;

    private String idRewardName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateReward() {
        return dateReward;
    }

    public void setDateReward(LocalDate dateReward) {
        this.dateReward = dateReward;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getRewardedBy() {
        return rewardedBy;
    }

    public void setRewardedBy(String rewardedBy) {
        this.rewardedBy = rewardedBy;
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

    public Long getIdEmployeeId() {
        return idEmployeeId;
    }

    public void setIdEmployeeId(Long emEmployeesId) {
        this.idEmployeeId = emEmployeesId;
    }

    public Long getIdRewardId() {
        return idRewardId;
    }

    public void setIdRewardId(Long emRewardTypesId) {
        this.idRewardId = emRewardTypesId;
    }

    public String getIdRewardName() {
        return idRewardName;
    }

    public void setIdRewardName(String emRewardTypesName) {
        this.idRewardName = emRewardTypesName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        EmEmpRewardsDTO emEmpRewardsDTO = (EmEmpRewardsDTO) o;
        if(emEmpRewardsDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), emEmpRewardsDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "EmEmpRewardsDTO{" +
            "id=" + getId() +
            ", description='" + getDescription() + "'" +
            ", dateReward='" + getDateReward() + "'" +
            ", amount=" + getAmount() +
            ", rewardedBy='" + getRewardedBy() + "'" +
            ", createdBy='" + getCreatedBy() + "'" +
            ", createdAt='" + getCreatedAt() + "'" +
            ", updatedBy='" + getUpdatedBy() + "'" +
            ", updatedAt='" + getUpdatedAt() + "'" +
            "}";
    }
}
