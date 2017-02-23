/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.business.pedidos.controller;

import co.expochick.backend.persistence.entity.PrecioCantidad;
import co.expochick.backend.persistence.facades.PrecioCantidadFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author alexandra
 */
@Named(value = "precioCantidadModificarManagedBean")
@RequestScoped
public class PrecioCantidadModificarManagedBean implements Serializable {

     @EJB private PrecioCantidadFacade prefc;
    private PrecioCantidad precioxCant;
    
    public PrecioCantidadModificarManagedBean() {
    }

    public PrecioCantidad getPrecioxCant() {
        return precioxCant;
    }

    public void setPrecioxCant(PrecioCantidad precioxCant) {
        this.precioxCant = precioxCant;
    }
    
    @PostConstruct
    public void init (){
        precioxCant = new PrecioCantidad();
    }
    
    public void modificarPrecioCant(){
        try {
            prefc.edit(precioxCant);
        } catch (Exception e) {
            System.out.println("ERROR - MODIFICAR PRECIO CANTIDAD ! "+e);
        }
    }
    
}
