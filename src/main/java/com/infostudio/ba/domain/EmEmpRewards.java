package com.infostudio.ba.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A EmEmpRewards.
 */
@Entity
@Table(name = "em_emp_rewards")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class EmEmpRewards extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "date_reward")
    private LocalDate dateReward;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "rewarded_by")
    private String rewardedBy;

    @OneToOne
    @JoinColumn(name = "id_employee")
    private EmEmployees idEmployee;

    @OneToOne
    @JoinColumn(name = "id_reward")
    private EmRewardTypes idReward;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public EmEmpRewards description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateReward() {
        return dateReward;
    }

    public EmEmpRewards dateReward(LocalDate dateReward) {
        this.dateReward = dateReward;
        return this;
    }

    public void setDateReward(LocalDate dateReward) {
        this.dateReward = dateReward;
    }

    public Integer getAmount() {
        return amount;
    }

    public EmEmpRewards amount(Integer amount) {
        this.amount = amount;
        return this;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getRewardedBy() {
        return rewardedBy;
    }

    public EmEmpRewards rewardedBy(String rewardedBy) {
        this.rewardedBy = rewardedBy;
        return this;
    }

    public void setRewardedBy(String rewardedBy) {
        this.rewardedBy = rewardedBy;
    }

    public EmEmployees getIdEmployee() {
        return idEmployee;
    }

    public EmEmpRewards idEmployee(EmEmployees emEmployees) {
        this.idEmployee = emEmployees;
        return this;
    }

    public void setIdEmployee(EmEmployees emEmployees) {
        this.idEmployee = emEmployees;
    }

    public EmRewardTypes getIdReward() {
        return idReward;
    }

    public EmEmpRewards idReward(EmRewardTypes emRewardTypes) {
        this.idReward = emRewardTypes;
        return this;
    }

    public void setIdReward(EmRewardTypes emRewardTypes) {
        this.idReward = emRewardTypes;
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
        EmEmpRewards emEmpRewards = (EmEmpRewards) o;
        if (emEmpRewards.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), emEmpRewards.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "EmEmpRewards{" +
            "id=" + getId() +
            ", description='" + getDescription() + "'" +
            ", dateReward='" + getDateReward() + "'" +
            ", amount=" + getAmount() +
            ", rewardedBy='" + getRewardedBy() + "'" +
            "}";
    }
}
