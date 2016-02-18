/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author edito
 */
@Entity
@Table(name = "incidencia", catalog = "LeccionarioV3", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Incidencia.findAll", query = "SELECT i FROM Incidencia i"),
    @NamedQuery(name = "Incidencia.findByIdIncidencia", query = "SELECT i FROM Incidencia i WHERE i.idIncidencia = :idIncidencia"),
    @NamedQuery(name = "Incidencia.findByDescripcion", query = "SELECT i FROM Incidencia i WHERE i.descripcion = :descripcion"),
    @NamedQuery(name = "Incidencia.findByActiva", query = "SELECT i FROM Incidencia i WHERE i.activa = :activa")})
public class Incidencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idIncidencia", nullable = false)
    private Integer idIncidencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descripcion", nullable = false, length = 50)
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activa", nullable = false)
    private boolean activa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "incidencia")
    private Collection<LHoraIncidenciaEstudiante> lHoraIncidenciaEstudianteCollection;

    public Incidencia() {
    }

    public Incidencia(Integer idIncidencia) {
        this.idIncidencia = idIncidencia;
    }

    public Incidencia(Integer idIncidencia, String descripcion, boolean activa) {
        this.idIncidencia = idIncidencia;
        this.descripcion = descripcion;
        this.activa = activa;
    }

    public Integer getIdIncidencia() {
        return idIncidencia;
    }

    public void setIdIncidencia(Integer idIncidencia) {
        this.idIncidencia = idIncidencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean getActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
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
        hash += (idIncidencia != null ? idIncidencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Incidencia)) {
            return false;
        }
        Incidencia other = (Incidencia) object;
        if ((this.idIncidencia == null && other.idIncidencia != null) || (this.idIncidencia != null && !this.idIncidencia.equals(other.idIncidencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Incidencia[ idIncidencia=" + idIncidencia + " ]";
    }
    
}
