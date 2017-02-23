/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.backend.persistence.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author alexandra
 */
@Entity
@Table(name = "ciudades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ciudad.findAll", query = "SELECT c FROM Ciudad c")
    , @NamedQuery(name = "Ciudad.findByIdCiudad", query = "SELECT c FROM Ciudad c WHERE c.idCiudad = :idCiudad")
    , @NamedQuery(name = "Ciudad.findByNombreCiudad", query = "SELECT c FROM Ciudad c WHERE c.nombreCiudad = :nombreCiudad")})
public class Ciudad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCiudad")
    private Integer idCiudad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nombreCiudad")
    private String nombreCiudad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCiudadDestino", fetch = FetchType.EAGER)
    private Collection<Antinarcoticos> antinarcoticosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCiudad", fetch = FetchType.EAGER)
    private Collection<Cliente> clienteCollection;
    @JoinColumn(name = "idPais", referencedColumnName = "idPais")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Pais idPais;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCiudad", fetch = FetchType.EAGER)
    private Collection<Trazabilidad> trazabilidadCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCiudad", fetch = FetchType.EAGER)
    private Collection<EmpresaTransporte> empresaTransporteCollection;

    public Ciudad() {
    }

    public Ciudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
    }

    public Ciudad(Integer idCiudad, String nombreCiudad) {
        this.idCiudad = idCiudad;
        this.nombreCiudad = nombreCiudad;
    }

    public Integer getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    @XmlTransient
    public Collection<Antinarcoticos> getAntinarcoticosCollection() {
        return antinarcoticosCollection;
    }

    public void setAntinarcoticosCollection(Collection<Antinarcoticos> antinarcoticosCollection) {
        this.antinarcoticosCollection = antinarcoticosCollection;
    }

    @XmlTransient
    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
    }

    public Pais getIdPais() {
        return idPais;
    }

    public void setIdPais(Pais idPais) {
        this.idPais = idPais;
    }

    @XmlTransient
    public Collection<Trazabilidad> getTrazabilidadCollection() {
        return trazabilidadCollection;
    }

    public void setTrazabilidadCollection(Collection<Trazabilidad> trazabilidadCollection) {
        this.trazabilidadCollection = trazabilidadCollection;
    }

    @XmlTransient
    public Collection<EmpresaTransporte> getEmpresaTransporteCollection() {
        return empresaTransporteCollection;
    }

    public void setEmpresaTransporteCollection(Collection<EmpresaTransporte> empresaTransporteCollection) {
        this.empresaTransporteCollection = empresaTransporteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCiudad != null ? idCiudad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciudad)) {
            return false;
        }
        Ciudad other = (Ciudad) object;
        if ((this.idCiudad == null && other.idCiudad != null) || (this.idCiudad != null && !this.idCiudad.equals(other.idCiudad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.expochick.backend.persistence.entity.Ciudad[ idCiudad=" + idCiudad + " ]";
    }
    
}
