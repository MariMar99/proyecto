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
@Table(name = "estadosproductos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoProducto.findAll", query = "SELECT e FROM EstadoProducto e")
    , @NamedQuery(name = "EstadoProducto.findByIdEstadoProducto", query = "SELECT e FROM EstadoProducto e WHERE e.idEstadoProducto = :idEstadoProducto")
    , @NamedQuery(name = "EstadoProducto.findByNombreEstadoProducto", query = "SELECT e FROM EstadoProducto e WHERE e.nombreEstadoProducto = :nombreEstadoProducto")})
public class EstadoProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEstadoProducto")
    private Integer idEstadoProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombreEstadoProducto")
    private String nombreEstadoProducto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoProducto", fetch = FetchType.EAGER)
    private Collection<Producto> productoCollection;

    public EstadoProducto() {
    }

    public EstadoProducto(Integer idEstadoProducto) {
        this.idEstadoProducto = idEstadoProducto;
    }

    public EstadoProducto(Integer idEstadoProducto, String nombreEstadoProducto) {
        this.idEstadoProducto = idEstadoProducto;
        this.nombreEstadoProducto = nombreEstadoProducto;
    }

    public Integer getIdEstadoProducto() {
        return idEstadoProducto;
    }

    public void setIdEstadoProducto(Integer idEstadoProducto) {
        this.idEstadoProducto = idEstadoProducto;
    }

    public String getNombreEstadoProducto() {
        return nombreEstadoProducto;
    }

    public void setNombreEstadoProducto(String nombreEstadoProducto) {
        this.nombreEstadoProducto = nombreEstadoProducto;
    }

    @XmlTransient
    public Collection<Producto> getProductoCollection() {
        return productoCollection;
    }

    public void setProductoCollection(Collection<Producto> productoCollection) {
        this.productoCollection = productoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoProducto != null ? idEstadoProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoProducto)) {
            return false;
        }
        EstadoProducto other = (EstadoProducto) object;
        if ((this.idEstadoProducto == null && other.idEstadoProducto != null) || (this.idEstadoProducto != null && !this.idEstadoProducto.equals(other.idEstadoProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.expochick.backend.persistence.entity.EstadoProducto[ idEstadoProducto=" + idEstadoProducto + " ]";
    }
    
}
