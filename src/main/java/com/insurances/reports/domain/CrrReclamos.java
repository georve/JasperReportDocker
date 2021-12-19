package com.insurances.reports.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name="CRR_RECLAMOS")
public class CrrReclamos implements Serializable {

    @EmbeddedId
    private CrrReclamosPK reclamosPK;

    @Column(name="fecharegistro",nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name="usuarioregistro",columnDefinition="CHAR(30)")
    private String usuarioRegistro;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaReclamo;

    @Column(name ="usuarioreclamo",columnDefinition="CHAR(30)")
    private String usuarioReclamo;

    @Column(name="fechasiniestro",nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private  Date fechaSiniestro;

    @Column(name="tipodesiniestro")
    private int tipoDeSiniestro;

    @Column(name="descripcion",length = 255)
    private String descripcion;

    @Column(name="numparte",length = 20)
    private String numparte;

    @Column(name="numresolucion",length = 20)
    private String numResolucion;

    @Column(name="numdenuncia",length = 20)
    private String numDenuncia;

    @Column(name="numoficio",length = 20)
    private String numOficio;

    @Column(name="numbrecorredor",length = 100)
    private String numbreCorredor;

    @Column(name="estadosiniestro",columnDefinition="CHAR(2)")
    private String estadoSiniestro;

    @Column(name="ubicacionsiniestro",length = 255)
    private String ubicacionSiniestro;

    @Column(name="numeroplacapolicia",columnDefinition="CHAR(30)")
    private String numeroPlacaPolicia;

    @Column(name="foto",length = 100)
    private String foto;

    @Column(name="coaseguro",columnDefinition="CHAR(1)")
    private String coaseguro;

}
