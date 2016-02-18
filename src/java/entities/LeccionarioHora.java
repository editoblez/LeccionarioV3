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
@Table(name = "leccionarioHora", catalog = "LeccionarioV3", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LeccionarioHora.findAll", query = "SELECT l FROM LeccionarioHora l"),
    @NamedQuery(name = "LeccionarioHora.findByIdLeccionario", query = "SELECT l FROM LeccionarioHora l WHERE l.leccionarioHoraPK.idLeccionario = :idLeccionario"),
    @NamedQuery(name = "LeccionarioHora.findByIdHora", query = "SELECT l FROM LeccionarioHora l WHERE l.leccionarioHoraPK.idHora = :idHora")})
public class LeccionarioHora implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LeccionarioHoraPK leccionarioHoraPK;
    @JoinColumn(name = "idHora", referencedColumnName = "idHora", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Hora hora;
    @JoinColumn(name = "idLeccionario", referencedColumnName = "idLeccionario", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Leccionario leccionario;
    @JoinColumn(name = "idProfesor", referencedColumnName = "idProfesor", nullable = false)
    @ManyToOne(optional = false)
    private Profesor idProfesor;
    @JoinColumn(name = "idTema", referencedColumnName = "idTema", nullable = false)
    @ManyToOne(optional = false)
    private Tema idTema;

    public LeccionarioHora() {
    }

    public LeccionarioHora(LeccionarioHoraPK leccionarioHoraPK) {
        this.leccionarioHoraPK = leccionarioHoraPK;
    }

    public LeccionarioHora(int idLeccionario, int idHora) {
        this.leccionarioHoraPK = new LeccionarioHoraPK(idLeccionario, idHora);
    }

    public LeccionarioHoraPK getLeccionarioHoraPK() {
        return leccionarioHoraPK;
    }

    public void setLeccionarioHoraPK(LeccionarioHoraPK leccionarioHoraPK) {
        this.leccionarioHoraPK = leccionarioHoraPK;
    }

    public Hora getHora() {
        return hora;
    }

    public void setHora(Hora hora) {
        this.hora = hora;
    }

    public Leccionario getLeccionario() {
        return leccionario;
    }

    public void setLeccionario(Leccionario leccionario) {
        this.leccionario = leccionario;
    }

    public Profesor getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Profesor idProfesor) {
        this.idProfesor = idProfesor;
    }

    public Tema getIdTema() {
        return idTema;
    }

    public void setIdTema(Tema idTema) {
        this.idTema = idTema;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (leccionarioHoraPK != null ? leccionarioHoraPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LeccionarioHora)) {
            return false;
        }
        LeccionarioHora other = (LeccionarioHora) object;
        if ((this.leccionarioHoraPK == null && other.leccionarioHoraPK != null) || (this.leccionarioHoraPK != null && !this.leccionarioHoraPK.equals(other.leccionarioHoraPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.LeccionarioHora[ leccionarioHoraPK=" + leccionarioHoraPK + " ]";
    }
    
}
