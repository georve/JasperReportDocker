package com.insurances.reports.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Getter
@Setter
@Entity
@Table(name="CRR_RECLAMANTES")
public class CrrReclamantes {

    @EmbeddedId
    private CrrReclamantesPK reclamantesPK;

    @Column(name="tiporeclamante",columnDefinition="CHAR(2)")
    private String tipoReclamante;

    @Column(name="fecha_reclamo",nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaReclamo;

    @Column(name="monto",precision = 10, scale = 2)
    private Double monto;

    @Column(name="foto")
    private String foto;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="observacion")
    private String observacion;

    @Column(name="estadoreclamo",columnDefinition="CHAR(2)")
    private String estadoreclamo;

    @Column(name="subrogacion",columnDefinition="CHAR(1)")
    private String subrogacion;

    @Column(name="idaseguradorasub")
    private int idaseguradorasub;

    @Column(name="tipoPago",columnDefinition="CHAR(2)")
    private String tipoPago;

    @Column(name="taller",columnDefinition="CHAR(30)")
    private String taller;

    @Column(name="provincia",columnDefinition="CHAR(2)")
    private String provincia;

    @Column(name="inicial",columnDefinition="CHAR(2)")
    private String inicial;

    @Column(name="tomo",columnDefinition="CHAR(6)")
    private String tomo;

    @Column(name="folio",columnDefinition="CHAR(6)")
    private String folio;

    @Column(name="asiento",columnDefinition="CHAR(6)")
    private String asiento;

    @Column(name="cedularuccorrida",columnDefinition="CHAR(20)")
    private String cedularuccorrida;

    @Column(name="tipoPersona",columnDefinition="CHAR(1)")
    private String tipoPersona;

    @Column(name="primerNombre",columnDefinition="CHAR(40)")
    private String primerNombre;

    @Column(name="segundoNombre",columnDefinition="CHAR(40)")
    private String segundoNombre;

    @Column(name="primerApellido",columnDefinition="CHAR(40)")
    private String primerApellido;

    @Column(name="segundoApellido",columnDefinition="CHAR(40)")
    private String segundoApellido;

    @Column(name="apellidocasada",columnDefinition="CHAR(40)")
    private String apellidocasada;

    @Column(name="codCliente",columnDefinition="CHAR(3)")
    private String codCliente;

    @Column(name="numplaca",length = 20)
    private String numplaca;

    @Column(name="numchasis",length = 30)
    private String numchasis;

    @Column(name="nummotor",length = 30)
    private String nummotor;

    @Column(name="vin",length = 30)
    private String vin;

    @Column(name="cupo",length = 30)
    private String cupo;

    @Column(name="marca",length = 30)
    private String marca;

    @Column(name="modelo",length = 30)
    private String modelo;

    @Column(name="anno")
    private int anno;

    @Column(name="color",length = 30)
    private String color;

    @Column(name="estilo",length = 30)
    private String estilo;

    @Column(name="hipoteca",columnDefinition="CHAR(1)")
    private String hipoteca;

    @Column(name="agenciahipoteca",length = 50)
    private String agenciahipoteca;

    @Column(name="perdidatotal",columnDefinition="CHAR(1)")
    private String perdidatotal;

    @Column(name="estadoauto",columnDefinition="CHAR(2)")
    private String estadoauto;

    @Column(name="provinciaconductor",columnDefinition="CHAR(2)")
    private String provinciaConductor;

    @Column(name="inicialconductor",columnDefinition="CHAR(2)")
    private String inicialConductor;

    @Column(name="tomoconductor",columnDefinition="CHAR(6)")
    private String tomoConductor;

    @Column(name="folioConductor",columnDefinition="CHAR(6)")
    private String folioConductor;

    @Column(name="cedulacorridacondutor",columnDefinition="CHAR(20)")
    private String cedulacorridacondutor;

    @Column(name="primerNombreConductor",columnDefinition="CHAR(40)")
    private String primerNombreConductor;

    @Column(name="segundoNombreConductor",columnDefinition="CHAR(40)")
    private String segundoNombreConductor;

    @Column(name="primerApellidoConductor",columnDefinition="CHAR(40)")
    private String primerApellidoConductor;

    @Column(name="segundoApellidoConductor",columnDefinition="CHAR(40)")
    private String segundoApellidoConductor;

    @Column(name="apellidocasadoConductor",columnDefinition="CHAR(40)")
    private String apellidocasadoConductor;

    @Column(name="fechaCarga")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCarga;



}
