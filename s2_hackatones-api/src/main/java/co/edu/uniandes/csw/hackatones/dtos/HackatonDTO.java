/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.hackatones.dtos;

import co.edu.uniandes.csw.hackatones.adapters.DateAdapter;
import co.edu.uniandes.csw.hackatones.entities.HackatonEntity;
import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 *
 * @author jc.higuera
 */
public class HackatonDTO implements Serializable {

    private String reglas;
    
    private String restricciones;
    
    private Integer limiteParticipantes;

    private Long id;

    private String nombre;

    private String tipo;

    private String tema;

    private String especificacion;

    private Integer nivel;

    private String imagen;

    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date fechaInicio;

    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date fechaFin;

    private String premio;

    private Boolean finalizada;
    
    private Boolean iniciada;
    
    private Integer tamanoEquipos;

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

    /**
     * Constructor por defecto
     */
    public HackatonDTO() {

    }

    /**
     * Constructor a partir de la entidad
     *
     * @param entidad La entidad de la hackaton
     */
    public HackatonDTO(HackatonEntity entidad) {
        if(entidad != null){
        this.id = entidad.getId();
        this.limiteParticipantes = entidad.getLimiteParticipantes();
        this.nombre = entidad.getNombre();
        this.tipo = entidad.getTipo();
        this.tema = entidad.getTema();
        this.especificacion = entidad.getEspecificacion();
        this.nivel = entidad.getNivel();
        this.imagen = entidad.getImagen();
        this.fechaInicio = entidad.getFechaInicio();
        this.fechaFin = entidad.getFechaFin();
        this.premio = entidad.getPremio();
        this.finalizada = entidad.getFinalizada();
        this.tamanoEquipos = entidad.getTamanoEquipos();
        this.iniciada = entidad.getIniciada();
        this.reglas = entidad.getReglas();
        this.restricciones = entidad.getRestricciones();
        
        if (entidad.getLugar() != null) {
            this.lugar = new LugarDTO(entidad.getLugar());
        } else {
            this.lugar = null;
        }
        if (entidad.getEquipoGanador() != null) {
            this.equipoGanador = new EquipoDTO(entidad.getEquipoGanador());
        } else {
            this.equipoGanador = null;
        }
        }
    }

    /**
     * Método para transformar el DTO a una entidad.
     *
     * @return La entidad de la hackaton asociada.
     */
    public HackatonEntity toEntity() {
        HackatonEntity hackaton = new HackatonEntity();
        hackaton.setId(this.id);
        hackaton.setLimiteParticipantes(this.limiteParticipantes);
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
        hackaton.setTamanoEquipos(getTamanoEquipos());
        hackaton.setIniciada(getIniciada());
        hackaton.setReglas(getReglas());
        hackaton.setRestricciones(getRestricciones());
        if (this.lugar != null) {
            hackaton.setLugar(this.lugar.toEntity());
        }
        if(this.equipoGanador!= null){
            hackaton.setEquipoGanador(this.equipoGanador.toEntity());
        }
        return hackaton;
    }

    /**
     * @param limiteParticipantes the limiteParticipantes to set
     */
    public void setLimiteParticipantes(Integer limiteParticipantes) {
        this.limiteParticipantes = limiteParticipantes;
    }
    
    /**
     * @return the limiteParticipantes
     */
    public Integer getLimiteParticipantes() {
        return limiteParticipantes;
    }

   

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

   

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
     /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }
    

    /**
     * @param tema the tema to set
     */
    public void setTema(String tema) {
        this.tema = tema;
    }
    
    /**
     * @return the tema
     */
    public String getTema() {
        return tema;
    }
    

    /**
     * @param especificacion the especificacion to set
     */
    public void setEspecificacion(String especificacion) {
        this.especificacion = especificacion;
    }
    
     /**
     * @return the especificacion
     */
    public String getEspecificacion() {
        return especificacion;
    }

    

    /**
     * @param nivel the nivel to set
     */
    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }
    
    /**
     * @return the nivel
     */
    public Integer getNivel() {
        return nivel;
    }
    


    /**
     * @param imagen the imagen to set
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    /**
     * @return the imagen
     */
    public String getImagen() {
        return imagen;
    }

   
    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

     /**
     * @return the fechaInicio
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }


    /**
     * @param fechaFin the fechaFin to set
     */
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

        /**
     * @return the fechaFin
     */
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     * @param premio the premio to set
     */
    public void setPremio(String premio) {
        this.premio = premio;
    }

    
    /**
     * @return the premio
     */
    public String getPremio() {
        return premio;
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
     * @return the finalizada
     */
    public Boolean getFinalizada() {
        return finalizada;
    }
    
   

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    
     /**
     * @return the id
     */
    public Long getId() {
        return id;
    }
    
   

    /**
     * @param equipoGanador the equipoGanador to set
     */
    public void setEquipoGanador(EquipoDTO equipoGanador) {
        this.equipoGanador = equipoGanador;
    }

     /**
     * @return the equipoGanador
     */
    public EquipoDTO getEquipoGanador() {
        return equipoGanador;
    }
    
    

    /**
     * @param lugar the lugar to set
     */
    public void setLugar(LugarDTO lugar) {
        this.lugar = lugar;
    }
    
    /**
     * @return the lugar
     */
    public LugarDTO getLugar() {
        return lugar;
    }
    
    

    /**
     * @param tamanoEquipos the tamanoEquipos to set
     */
    public void setTamanoEquipos(Integer tamanoEquipos) {
        this.tamanoEquipos = tamanoEquipos;
    }
    
    /**
     * @return the tamanoEquipos
     */
    public Integer getTamanoEquipos() {
        return tamanoEquipos;
    }
    
    

    /**
     * @param reglas the reglas to set
     */
    public void setReglas(String reglas) {
        this.reglas = reglas;
    }
    
    /**
     * @return the reglas
     */
    public String getReglas() {
        return reglas;
    }
    
    

    /**
     * @param restricciones the restricciones to set
     */
    public void setRestricciones(String restricciones) {
        this.restricciones = restricciones;
    }
    
    /**
     * @return the restricciones
     */
    public String getRestricciones() {
        return restricciones;
    }

    /**
     * @return the iniciada
     */
    public Boolean getIniciada() {
        return iniciada;
    }

    /**
     * @param iniciada the iniciada to set
     */
    public void setIniciada(Boolean iniciada) {
        this.iniciada = iniciada;
    }
}
