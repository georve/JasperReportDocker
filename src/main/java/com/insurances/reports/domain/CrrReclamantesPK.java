package com.insurances.reports.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class CrrReclamantesPK implements Serializable {

    @Column(name="codaseguradora")
    private int codAseguradora;

    @Column(name="numeroreclamo",columnDefinition="CHAR(20)")
    private String numeroReclamo;

    @Column(name="numeroreclamante")
    private int numeroReclamante;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CrrReclamantesPK)) return false;
        CrrReclamantesPK that = (CrrReclamantesPK) o;
        return codAseguradora == that.codAseguradora && numeroReclamante == that.numeroReclamante && numeroReclamo.equals(that.numeroReclamo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codAseguradora, numeroReclamo, numeroReclamante);
    }
}
