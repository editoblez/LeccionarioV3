/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author edito
 */
@Entity
@Table(name = "hora", catalog = "LeccionarioV3", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hora.findAll", query = "SELECT h FROM Hora h"),
    @NamedQuery(name = "Hora.findByIdHora", query = "SELECT h FROM Hora h WHERE h.idHora = :idHora"),
    @NamedQuery(name = "Hora.findByHoraInicio", query = "SELECT h FROM Hora h WHERE h.horaInicio = :horaInicio"),
    @NamedQuery(name = "Hora.findByHoraFin", query = "SELECT h FROM Hora h WHERE h.horaFin = :horaFin"),
    @NamedQuery(name = "Hora.findByActivo", query = "SELECT h FROM Hora h WHERE h.activo = :activo")})
public class Hora implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idHora", nullable = false)
    private Integer idHora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "horaInicio", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date horaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "horaFin", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date horaFin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo", nullable = false)
    private boolean activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hora")
    private Collection<LeccionarioHora> leccionarioHoraCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hora")
    private Collection<LHoraIncidenciaEstudiante> lHoraIncidenciaEstudianteCollection;

    public Hora() {
    }

    public Hora(Integer idHora) {
        this.idHora = idHora;
    }

    public Hora(Integer idHora, Date horaInicio, Date horaFin, boolean activo) {
        this.idHora = idHora;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.activo = activo;
    }

    public Integer getIdHora() {
        return idHora;
    }

    public void setIdHora(Integer idHora) {
        this.idHora = idHora;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @XmlTransient
    public Collection<LeccionarioHora> getLeccionarioHoraCollection() {
        return leccionarioHoraCollection;
    }

    public void setLeccionarioHoraCollection(Collection<LeccionarioHora> leccionarioHoraCollection) {
        this.leccionarioHoraCollection = leccionarioHoraCollection;
    }

    @XmlTransient
    public Collection<LHoraIncidenciaEstudiante> getLHoraIncidenciaEstudianteCollection() {
        return lHoraIncidenciaEstudianteCollection;
    }

    public void setLHoraIncidenciaEstudianteCollection(Collection<LHoraIncidenciaEstudiante> lHoraIncidenciaEstudianteCollection) {
        this.lHoraIncidenciaEstudianteCollection = lHoraIncidenciaEstudianteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHora != null ? idHora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hora)) {
            return false;
        }
        Hora other = (Hora) object;
        if ((this.idHora == null && other.idHora != null) || (this.idHora != null && !this.idHora.equals(other.idHora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Hora[ idHora=" + idHora + " ]";
    }
    
}
