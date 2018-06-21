package com.infostudio.ba.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A EmEmpAccomplishments.
 */
@Entity
@Table(name = "em_emp_accomplishments")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class EmEmpAccomplishments implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "organization")
    private String organization;

    @Column(name = "location")
    private String location;

    @Column(name = "association")
    private String association;

    @Column(name = "ongoing")
    private String ongoing;

    @Column(name = "link")
    private String link;

    @Column(name = "date_from")
    private LocalDate dateFrom;

    @Column(name = "date_to")
    private LocalDate dateTo;

    @Column(name = "occupation")
    private String occupation;

    @Column(name = "proficiency")
    private String proficiency;

    @Column(name = "licence_number")
    private String licenceNumber;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "id_accomplishment_type")
    private Integer idAccomplishmentType;

    @OneToOne
    @JoinColumn(name = "id_employee")
    private EmEmployees idEmployee;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public EmEmpAccomplishments title(String title) {
        this.title = title;
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public EmEmpAccomplishments description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrganization() {
        return organization;
    }

    public EmEmpAccomplishments organization(String organization) {
        this.organization = organization;
        return this;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getLocation() {
        return location;
    }

    public EmEmpAccomplishments location(String location) {
        this.location = location;
        return this;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAssociation() {
        return association;
    }

    public EmEmpAccomplishments association(String association) {
        this.association = association;
        return this;
    }

    public void setAssociation(String association) {
        this.association = association;
    }

    public String getOngoing() {
        return ongoing;
    }

    public EmEmpAccomplishments ongoing(String ongoing) {
        this.ongoing = ongoing;
        return this;
    }

    public void setOngoing(String ongoing) {
        this.ongoing = ongoing;
    }

    public String getLink() {
        return link;
    }

    public EmEmpAccomplishments link(String link) {
        this.link = link;
        return this;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public EmEmpAccomplishments dateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
        return this;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public EmEmpAccomplishments dateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
        return this;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public String getOccupation() {
        return occupation;
    }

    public EmEmpAccomplishments occupation(String occupation) {
        this.occupation = occupation;
        return this;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getProficiency() {
        return proficiency;
    }

    public EmEmpAccomplishments proficiency(String proficiency) {
        this.proficiency = proficiency;
        return this;
    }

    public void setProficiency(String proficiency) {
        this.proficiency = proficiency;
    }

    public String getLicenceNumber() {
        return licenceNumber;
    }

    public EmEmpAccomplishments licenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
        return this;
    }

    public void setLicenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    public Integer getRating() {
        return rating;
    }

    public EmEmpAccomplishments rating(Integer rating) {
        this.rating = rating;
        return this;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getIdAccomplishmentType() {
        return idAccomplishmentType;
    }

    public EmEmpAccomplishments idAccomplishmentType(Integer idAccomplishmentType) {
        this.idAccomplishmentType = idAccomplishmentType;
        return this;
    }

    public void setIdAccomplishmentType(Integer idAccomplishmentType) {
        this.idAccomplishmentType = idAccomplishmentType;
    }

    public EmEmployees getIdEmployee() {
        return idEmployee;
    }

    public EmEmpAccomplishments idEmployee(EmEmployees emEmployees) {
        this.idEmployee = emEmployees;
        return this;
    }

    public void setIdEmployee(EmEmployees emEmployees) {
        this.idEmployee = emEmployees;
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
        EmEmpAccomplishments emEmpAccomplishments = (EmEmpAccomplishments) o;
        if (emEmpAccomplishments.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), emEmpAccomplishments.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "EmEmpAccomplishments{" +
            "id=" + getId() +
            ", title='" + getTitle() + "'" +
            ", description='" + getDescription() + "'" +
            ", organization='" + getOrganization() + "'" +
            ", location='" + getLocation() + "'" +
            ", association='" + getAssociation() + "'" +
            ", ongoing='" + getOngoing() + "'" +
            ", link='" + getLink() + "'" +
            ", dateFrom='" + getDateFrom() + "'" +
            ", dateTo='" + getDateTo() + "'" +
            ", occupation='" + getOccupation() + "'" +
            ", proficiency='" + getProficiency() + "'" +
            ", licenceNumber='" + getLicenceNumber() + "'" +
            ", rating=" + getRating() +
            ", idAccomplishmentType=" + getIdAccomplishmentType() +
            "}";
    }
}
