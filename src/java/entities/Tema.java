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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author edito
 */
@Entity
@Table(name = "tema", catalog = "LeccionarioV3", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tema.findAll", query = "SELECT t FROM Tema t"),
    @NamedQuery(name = "Tema.findByIdTema", query = "SELECT t FROM Tema t WHERE t.idTema = :idTema"),
    @NamedQuery(name = "Tema.findByNombreTema", query = "SELECT t FROM Tema t WHERE t.nombreTema = :nombreTema"),
    @NamedQuery(name = "Tema.findByActivo", query = "SELECT t FROM Tema t WHERE t.activo = :activo")})
public class Tema implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idTema", nullable = false)
    private Integer idTema;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombreTema", nullable = false, length = 50)
    private String nombreTema;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo", nullable = false)
    private boolean activo;
    @JoinColumn(name = "idMateria", referencedColumnName = "idMateria", nullable = false)
    @ManyToOne(optional = false)
    private Materia idMateria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTema")
    private Collection<LeccionarioHora> leccionarioHoraCollection;

    public Tema() {
    }

    public Tema(Integer idTema) {
        this.idTema = idTema;
    }

    public Tema(Integer idTema, String nombreTema, boolean activo) {
        this.idTema = idTema;
        this.nombreTema = nombreTema;
        this.activo = activo;
    }

    public Integer getIdTema() {
        return idTema;
    }

    public void setIdTema(Integer idTema) {
        this.idTema = idTema;
    }

    public String getNombreTema() {
        return nombreTema;
    }

    public void setNombreTema(String nombreTema) {
        this.nombreTema = nombreTema;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Materia getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Materia idMateria) {
        this.idMateria = idMateria;
    }

    @XmlTransient
    public Collection<LeccionarioHora> getLeccionarioHoraCollection() {
        return leccionarioHoraCollection;
    }

    public void setLeccionarioHoraCollection(Collection<LeccionarioHora> leccionarioHoraCollection) {
        this.leccionarioHoraCollection = leccionarioHoraCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTema != null ? idTema.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tema)) {
            return false;
        }
        Tema other = (Tema) object;
        if ((this.idTema == null && other.idTema != null) || (this.idTema != null && !this.idTema.equals(other.idTema))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Tema[ idTema=" + idTema + " ]";
    }
    
}
