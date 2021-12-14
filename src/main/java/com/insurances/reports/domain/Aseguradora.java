package com.insurances.reports.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="ASEGURADORAS")
public class Aseguradora {
    @Id
    @Column(name="aseguradora_id")
    private int id;
    @Column(name="nombre" ,length=255, nullable=false)
    private String nombre;
    @Column(name="participa_proyecto",nullable=true)
    private int participaProyecto;
    @Column(name="nombre_corto",nullable=true,columnDefinition="CHAR(20)")
    private String NombreCorto;
    @Column(name="proteccion",nullable=true,columnDefinition="CHAR(20)")
    private String proteccion;
    @Column(name="activo",nullable=false)
    private Boolean activo;


}
