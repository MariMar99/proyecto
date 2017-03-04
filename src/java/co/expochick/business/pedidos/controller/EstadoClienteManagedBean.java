/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.business.pedidos.controller;

import co.expochick.backend.persistence.entity.EstadoCliente;
import co.expochick.backend.persistence.facades.EstadoClienteFacade;
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
@Named(value = "estadoClienteManagedBean")
@RequestScoped
public class EstadoClienteManagedBean implements Serializable {

    @EJB private EstadoClienteFacade estadoClifc;
    private EstadoCliente estadoCli;
    
    public EstadoClienteManagedBean() {
    }

    public EstadoCliente getEstadoCli() {
        return estadoCli;
    }

    public void setEstadoCli(EstadoCliente estadoCli) {
        this.estadoCli = estadoCli;
    }
    
    @PostConstruct
    public void init(){
        estadoCli = new EstadoCliente();
    }
    
    public List<EstadoCliente> listarEstadoCliente(){
        return estadoClifc.findAll();    }
    
}
