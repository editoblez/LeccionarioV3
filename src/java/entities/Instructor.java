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
@Table(name = "instructor", catalog = "LeccionarioV3", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Instructor.findAll", query = "SELECT i FROM Instructor i"),
    @NamedQuery(name = "Instructor.findByIdInstructor", query = "SELECT i FROM Instructor i WHERE i.idInstructor = :idInstructor")})
public class Instructor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idInstructor", nullable = false)
    private Integer idInstructor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInstructor")
    private Collection<Leccionario> leccionarioCollection;
    @JoinColumn(name = "idInstructor", referencedColumnName = "idPersona", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Persona persona;

    public Instructor() {
    }

    public Instructor(Integer idInstructor) {
        this.idInstructor = idInstructor;
    }

    public Integer getIdInstructor() {
        return idInstructor;
    }

    public void setIdInstructor(Integer idInstructor) {
        this.idInstructor = idInstructor;
    }

    @XmlTransient
    public Collection<Leccionario> getLeccionarioCollection() {
        return leccionarioCollection;
    }

    public void setLeccionarioCollection(Collection<Leccionario> leccionarioCollection) {
        this.leccionarioCollection = leccionarioCollection;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInstructor != null ? idInstructor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instructor)) {
            return false;
        }
        Instructor other = (Instructor) object;
        if ((this.idInstructor == null && other.idInstructor != null) || (this.idInstructor != null && !this.idInstructor.equals(other.idInstructor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Instructor[ idInstructor=" + idInstructor + " ]";
    }
    
}
