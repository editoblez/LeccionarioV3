/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author edito
 */
@Entity
@Table(name = "lHoraIncidenciaEstudiante", catalog = "LeccionarioV3", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LHoraIncidenciaEstudiante.findAll", query = "SELECT l FROM LHoraIncidenciaEstudiante l"),
    @NamedQuery(name = "LHoraIncidenciaEstudiante.findByIdLeccionario", query = "SELECT l FROM LHoraIncidenciaEstudiante l WHERE l.lHoraIncidenciaEstudiantePK.idLeccionario = :idLeccionario"),
    @NamedQuery(name = "LHoraIncidenciaEstudiante.findByIdHora", query = "SELECT l FROM LHoraIncidenciaEstudiante l WHERE l.lHoraIncidenciaEstudiantePK.idHora = :idHora"),
    @NamedQuery(name = "LHoraIncidenciaEstudiante.findByIdEstudiante", query = "SELECT l FROM LHoraIncidenciaEstudiante l WHERE l.lHoraIncidenciaEstudiantePK.idEstudiante = :idEstudiante"),
    @NamedQuery(name = "LHoraIncidenciaEstudiante.findByIdIncidencia", query = "SELECT l FROM LHoraIncidenciaEstudiante l WHERE l.lHoraIncidenciaEstudiantePK.idIncidencia = :idIncidencia")})
public class LHoraIncidenciaEstudiante implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LHoraIncidenciaEstudiantePK lHoraIncidenciaEstudiantePK;
    @JoinColumn(name = "idEstudiante", referencedColumnName = "idEstudiante", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Estudiante estudiante;
    @JoinColumn(name = "idHora", referencedColumnName = "idHora", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Hora hora;
    @JoinColumn(name = "idIncidencia", referencedColumnName = "idIncidencia", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Incidencia incidencia;
    @JoinColumn(name = "idLeccionario", referencedColumnName = "idLeccionario", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Leccionario leccionario;

    public LHoraIncidenciaEstudiante() {
    }

    public LHoraIncidenciaEstudiante(LHoraIncidenciaEstudiantePK lHoraIncidenciaEstudiantePK) {
        this.lHoraIncidenciaEstudiantePK = lHoraIncidenciaEstudiantePK;
    }

    public LHoraIncidenciaEstudiante(int idLeccionario, int idHora, int idEstudiante, int idIncidencia) {
        this.lHoraIncidenciaEstudiantePK = new LHoraIncidenciaEstudiantePK(idLeccionario, idHora, idEstudiante, idIncidencia);
    }

    public LHoraIncidenciaEstudiantePK getLHoraIncidenciaEstudiantePK() {
        return lHoraIncidenciaEstudiantePK;
    }

    public void setLHoraIncidenciaEstudiantePK(LHoraIncidenciaEstudiantePK lHoraIncidenciaEstudiantePK) {
        this.lHoraIncidenciaEstudiantePK = lHoraIncidenciaEstudiantePK;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Hora getHora() {
        return hora;
    }

    public void setHora(Hora hora) {
        this.hora = hora;
    }

    public Incidencia getIncidencia() {
        return incidencia;
    }

    public void setIncidencia(Incidencia incidencia) {
        this.incidencia = incidencia;
    }

    public Leccionario getLeccionario() {
        return leccionario;
    }

    public void setLeccionario(Leccionario leccionario) {
        this.leccionario = leccionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lHoraIncidenciaEstudiantePK != null ? lHoraIncidenciaEstudiantePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LHoraIncidenciaEstudiante)) {
            return false;
        }
        LHoraIncidenciaEstudiante other = (LHoraIncidenciaEstudiante) object;
        if ((this.lHoraIncidenciaEstudiantePK == null && other.lHoraIncidenciaEstudiantePK != null) || (this.lHoraIncidenciaEstudiantePK != null && !this.lHoraIncidenciaEstudiantePK.equals(other.lHoraIncidenciaEstudiantePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.LHoraIncidenciaEstudiante[ lHoraIncidenciaEstudiantePK=" + lHoraIncidenciaEstudiantePK + " ]";
    }
    
}
