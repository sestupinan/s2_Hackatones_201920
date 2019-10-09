/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.hackatones.dtos;

import co.edu.uniandes.csw.hackatones.entities.HackatonEntity;
import co.edu.uniandes.csw.hackatones.podam.DateStrategy;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import uk.co.jemos.podam.common.PodamStrategyValue;

/**
 *
 * @author jc.higuera
 */
public class HackatonDTO implements Serializable {

    private int limite_participantes;

    private Long id;

    private String nombre;

    @Enumerated(EnumType.ORDINAL)
    private HackatonEntity.EnumTipo tipo;

    private String tema;

    private String especificacion;

    private Integer nivel;

    private String imagen;

    @Temporal(TemporalType.DATE)
    @PodamStrategyValue(DateStrategy.class)
    private Date fechaInicio;

    @Temporal(TemporalType.DATE)
    @PodamStrategyValue(DateStrategy.class)
    private Date fechaFin;

    private HackatonEntity.EnumPremio premio;

    private Boolean finalizada;

    /*
    * Relación a un equipo
    * dado que esta tiene cardinalidad 1.
     */
    private EquipoDTO equipoGanador;

    /*
    * Relación a un lugar
    * dado que esta tiene cardinalidad 1.
     */
    private LugarDTO lugar;

    public HackatonDTO() {

    }

    public HackatonDTO(HackatonEntity entidad) {
        this.id = entidad.getId();
        this.limite_participantes = entidad.getLimite_participantes();
        this.nombre = entidad.getNombre();
        this.tipo = entidad.getTipoEnum();
        this.tema = entidad.getTema();
        this.especificacion = entidad.getEspecificacion();
        this.nivel = entidad.getNivel();
        this.imagen = entidad.getImagen();
        this.fechaInicio = entidad.getFechaInicio();
        this.fechaFin = entidad.getFechaFin();
        this.premio = entidad.getPremioEnum();
        this.finalizada = entidad.getFinalizada();
        if (entidad.getLugar() != null) {
            this.lugar = new LugarDTO(entidad.getLugar());
        } else {
            this.lugar = null;
        }
//        if (entidad.getEquipoGanador() != null) {
//            this.equipoGanador = new EquipoDTO(entidad.getEquipoGanador());
//        } else {
//            this.equipoGanador = null;
//        }
    }

    public HackatonEntity toEntity() {
        HackatonEntity hackaton = new HackatonEntity();
        hackaton.setId(this.id);
        hackaton.setLimite_participantes(this.limite_participantes);
        hackaton.setNombre(this.nombre);
        hackaton.setTipo(this.tipo);
        hackaton.setTema(this.tema);
        hackaton.setEspecificacion(this.especificacion);
        hackaton.setNivel(this.nivel);
        hackaton.setImagen(this.imagen);
        hackaton.setFechaInicio(this.fechaInicio);
        hackaton.setFechaFin(this.fechaFin);
        hackaton.setPremio(this.premio);
        hackaton.setFinalizada(this.finalizada);
        if (this.lugar != null) {
            hackaton.setLugar(this.lugar.toEntity());
        }
        return hackaton;
    }

    /**
     * @return the limite_participantes
     */
    public int getLimite_participantes() {
        return limite_participantes;
    }

    /**
     * @param limite_participantes the limite_participantes to set
     */
    public void setLimite_participantes(int limite_participantes) {
        this.limite_participantes = limite_participantes;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the tipo
     */
    public HackatonEntity.EnumTipo getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(HackatonEntity.EnumTipo tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the tema
     */
    public String getTema() {
        return tema;
    }

    /**
     * @param tema the tema to set
     */
    public void setTema(String tema) {
        this.tema = tema;
    }

    /**
     * @return the especificacion
     */
    public String getEspecificacion() {
        return especificacion;
    }

    /**
     * @param especificacion the especificacion to set
     */
    public void setEspecificacion(String especificacion) {
        this.especificacion = especificacion;
    }

    /**
     * @return the nivel
     */
    public Integer getNivel() {
        return nivel;
    }

    /**
     * @param nivel the nivel to set
     */
    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    /**
     * @return the imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /**
     * @return the fechaInicio
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the fechaFin
     */
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     * @param fechaFin the fechaFin to set
     */
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * @return the premio
     */
    public HackatonEntity.EnumPremio getPremio() {
        return premio;
    }

    /**
     * @param premio the premio to set
     */
    public void setPremio(HackatonEntity.EnumPremio premio) {
        this.premio = premio;
    }

    /**
     * @return the finalizada
     */
    public Boolean getFinalizada() {
        return finalizada;
    }

    /**
     * @param finalizada the finalizada to set
     */
    public void setFinalizada(Boolean finalizada) {
        this.finalizada = finalizada;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the equipoGanador
     */
    public EquipoDTO getEquipoGanador() {
        return equipoGanador;
    }

    /**
     * @param equipoGanador the equipoGanador to set
     */
    public void setEquipoGanador(EquipoDTO equipoGanador) {
        this.equipoGanador = equipoGanador;
    }

    /**
     * @return the lugar
     */
    public LugarDTO getLugar() {
        return lugar;
    }

    /**
     * @param lugar the lugar to set
     */
    public void setLugar(LugarDTO lugar) {
        this.lugar = lugar;
    }

}
