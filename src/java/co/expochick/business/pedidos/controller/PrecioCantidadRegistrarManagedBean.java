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
@Named(value = "precioCantidadRegistrarManagedBean")
@RequestScoped
public class PrecioCantidadRegistrarManagedBean implements Serializable {

    @EJB private PrecioCantidadFacade prefc;
    private PrecioCantidad precioxCant;
    
    public PrecioCantidadRegistrarManagedBean() {
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
    
    public void registrarPrecioCant(){
        try {
            prefc.create(precioxCant);
        } catch (Exception e) {
            System.out.println("ERROR - REGISTRAR PRECIO CANTIDAD ! "+e);
        }
    }
    
    public String registrar(){
        return "";
    }
    
}
