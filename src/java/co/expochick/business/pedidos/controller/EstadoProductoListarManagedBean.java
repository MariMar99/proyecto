/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.business.pedidos.controller;

import co.expochick.backend.persistence.entity.EstadoProducto;
import co.expochick.backend.persistence.facades.EstadoProductoFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author alexandra
 */
@Named(value = "estadoProductoListarManagedBean")
@RequestScoped
public class EstadoProductoListarManagedBean implements Serializable {

    @EJB private EstadoProductoFacade estaProfc;
    private EstadoProducto estProducto;
    
    public EstadoProductoListarManagedBean() {
    }

    public EstadoProducto getEstProducto() {
        return estProducto;
    }

    public void setEstProducto(EstadoProducto estProducto) {
        this.estProducto = estProducto;
    }
    
    @PostConstruct
    public void init (){
        estProducto = new EstadoProducto();
    }
    
    public List <EstadoProducto> listarEstadoProducto(){
        return estaProfc.findAll();
    }
    
}
