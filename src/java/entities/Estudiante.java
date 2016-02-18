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
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author edito
 */
@Entity
@Table(name = "estudiante", catalog = "LeccionarioV3", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudiante.findAll", query = "SELECT e FROM Estudiante e"),
    @NamedQuery(name = "Estudiante.findByIdEstudiante", query = "SELECT e FROM Estudiante e WHERE e.idEstudiante = :idEstudiante"),
    @NamedQuery(name = "Estudiante.findByIdCurso", query = "SELECT e FROM Estudiante e WHERE e.idCurso = :idCurso")})
public class Estudiante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idEstudiante", nullable = false)
    private Integer idEstudiante;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCurso", nullable = false)
    private int idCurso;
    @JoinColumn(name = "idEstudiante", referencedColumnName = "idPersona", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Persona persona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estudiante")
    private Collection<LHoraIncidenciaEstudiante> lHoraIncidenciaEstudianteCollection;

    public Estudiante() {
    }

    public Estudiante(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Estudiante(Integer idEstudiante, int idCurso) {
        this.idEstudiante = idEstudiante;
        this.idCurso = idCurso;
    }

    public Integer getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
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
        hash += (idEstudiante != null ? idEstudiante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiante)) {
            return false;
        }
        Estudiante other = (Estudiante) object;
        if ((this.idEstudiante == null && other.idEstudiante != null) || (this.idEstudiante != null && !this.idEstudiante.equals(other.idEstudiante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Estudiante[ idEstudiante=" + idEstudiante + " ]";
    }
    
}
