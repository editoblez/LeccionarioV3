/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author edito
 */
@Embeddable
public class LHoraIncidenciaEstudiantePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "idLeccionario", nullable = false)
    private int idLeccionario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idHora", nullable = false)
    private int idHora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idEstudiante", nullable = false)
    private int idEstudiante;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idIncidencia", nullable = false)
    private int idIncidencia;

    public LHoraIncidenciaEstudiantePK() {
    }

    public LHoraIncidenciaEstudiantePK(int idLeccionario, int idHora, int idEstudiante, int idIncidencia) {
        this.idLeccionario = idLeccionario;
        this.idHora = idHora;
        this.idEstudiante = idEstudiante;
        this.idIncidencia = idIncidencia;
    }

    public int getIdLeccionario() {
        return idLeccionario;
    }

    public void setIdLeccionario(int idLeccionario) {
        this.idLeccionario = idLeccionario;
    }

    public int getIdHora() {
        return idHora;
    }

    public void setIdHora(int idHora) {
        this.idHora = idHora;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public int getIdIncidencia() {
        return idIncidencia;
    }

    public void setIdIncidencia(int idIncidencia) {
        this.idIncidencia = idIncidencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idLeccionario;
        hash += (int) idHora;
        hash += (int) idEstudiante;
        hash += (int) idIncidencia;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LHoraIncidenciaEstudiantePK)) {
            return false;
        }
        LHoraIncidenciaEstudiantePK other = (LHoraIncidenciaEstudiantePK) object;
        if (this.idLeccionario != other.idLeccionario) {
            return false;
        }
        if (this.idHora != other.idHora) {
            return false;
        }
        if (this.idEstudiante != other.idEstudiante) {
            return false;
        }
        if (this.idIncidencia != other.idIncidencia) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.LHoraIncidenciaEstudiantePK[ idLeccionario=" + idLeccionario + ", idHora=" + idHora + ", idEstudiante=" + idEstudiante + ", idIncidencia=" + idIncidencia + " ]";
    }
    
}
