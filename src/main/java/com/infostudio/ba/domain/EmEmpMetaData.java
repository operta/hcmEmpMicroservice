package com.infostudio.ba.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A EmEmpMetaData.
 */
@Entity
@Table(name = "em_emp_meta_data")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class EmEmpMetaData extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "jhi_value")
    private String value;

    @Column(name = "displayvalue")
    private String displayvalue;

    @Column(name = "ordering")
    private Double ordering;

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

    public EmEmpMetaData title(String title) {
        this.title = title;
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public EmEmpMetaData value(String value) {
        this.value = value;
        return this;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDisplayvalue() {
        return displayvalue;
    }

    public EmEmpMetaData displayvalue(String displayvalue) {
        this.displayvalue = displayvalue;
        return this;
    }

    public void setDisplayvalue(String displayvalue) {
        this.displayvalue = displayvalue;
    }

    public Double getOrdering() {
        return ordering;
    }

    public EmEmpMetaData ordering(Double ordering) {
        this.ordering = ordering;
        return this;
    }

    public void setOrdering(Double ordering) {
        this.ordering = ordering;
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
        EmEmpMetaData emEmpMetaData = (EmEmpMetaData) o;
        if (emEmpMetaData.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), emEmpMetaData.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "EmEmpMetaData{" +
            "id=" + getId() +
            ", title='" + getTitle() + "'" +
            ", value='" + getValue() + "'" +
            ", displayvalue='" + getDisplayvalue() + "'" +
            ", ordering=" + getOrdering() +
            "}";
    }
}
