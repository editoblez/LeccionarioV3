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
public class LeccionarioHoraPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "idLeccionario", nullable = false)
    private int idLeccionario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idHora", nullable = false)
    private int idHora;

    public LeccionarioHoraPK() {
    }

    public LeccionarioHoraPK(int idLeccionario, int idHora) {
        this.idLeccionario = idLeccionario;
        this.idHora = idHora;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idLeccionario;
        hash += (int) idHora;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LeccionarioHoraPK)) {
            return false;
        }
        LeccionarioHoraPK other = (LeccionarioHoraPK) object;
        if (this.idLeccionario != other.idLeccionario) {
            return false;
        }
        if (this.idHora != other.idHora) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.LeccionarioHoraPK[ idLeccionario=" + idLeccionario + ", idHora=" + idHora + " ]";
    }
    
}
