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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author edito
 */
@Entity
@Table(name = "leccionario", catalog = "LeccionarioV3", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Leccionario.findAll", query = "SELECT l FROM Leccionario l"),
    @NamedQuery(name = "Leccionario.findByIdLeccionario", query = "SELECT l FROM Leccionario l WHERE l.idLeccionario = :idLeccionario"),
    @NamedQuery(name = "Leccionario.findByInicioLectivo", query = "SELECT l FROM Leccionario l WHERE l.inicioLectivo = :inicioLectivo"),
    @NamedQuery(name = "Leccionario.findByFinLectivo", query = "SELECT l FROM Leccionario l WHERE l.finLectivo = :finLectivo"),
    @NamedQuery(name = "Leccionario.findByActivo", query = "SELECT l FROM Leccionario l WHERE l.activo = :activo")})
public class Leccionario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idLeccionario", nullable = false)
    private Integer idLeccionario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "inicioLectivo", nullable = false)
    private int inicioLectivo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "finLectivo", nullable = false)
    private int finLectivo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo", nullable = false)
    private boolean activo;
    @JoinColumn(name = "idCurso", referencedColumnName = "idCurso", nullable = false)
    @ManyToOne(optional = false)
    private Curso idCurso;
    @JoinColumn(name = "idInstructor", referencedColumnName = "idInstructor", nullable = false)
    @ManyToOne(optional = false)
    private Instructor idInstructor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "leccionario")
    private Collection<LeccionarioHora> leccionarioHoraCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "leccionario")
    private Collection<LHoraIncidenciaEstudiante> lHoraIncidenciaEstudianteCollection;

    public Leccionario() {
    }

    public Leccionario(Integer idLeccionario) {
        this.idLeccionario = idLeccionario;
    }

    public Leccionario(Integer idLeccionario, int inicioLectivo, int finLectivo, boolean activo) {
        this.idLeccionario = idLeccionario;
        this.inicioLectivo = inicioLectivo;
        this.finLectivo = finLectivo;
        this.activo = activo;
    }

    public Integer getIdLeccionario() {
        return idLeccionario;
    }

    public void setIdLeccionario(Integer idLeccionario) {
        this.idLeccionario = idLeccionario;
    }

    public int getInicioLectivo() {
        return inicioLectivo;
    }

    public void setInicioLectivo(int inicioLectivo) {
        this.inicioLectivo = inicioLectivo;
    }

    public int getFinLectivo() {
        return finLectivo;
    }

    public void setFinLectivo(int finLectivo) {
        this.finLectivo = finLectivo;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Curso getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Curso idCurso) {
        this.idCurso = idCurso;
    }

    public Instructor getIdInstructor() {
        return idInstructor;
    }

    public void setIdInstructor(Instructor idInstructor) {
        this.idInstructor = idInstructor;
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
        hash += (idLeccionario != null ? idLeccionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Leccionario)) {
            return false;
        }
        Leccionario other = (Leccionario) object;
        if ((this.idLeccionario == null && other.idLeccionario != null) || (this.idLeccionario != null && !this.idLeccionario.equals(other.idLeccionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Leccionario[ idLeccionario=" + idLeccionario + " ]";
    }
    
}
