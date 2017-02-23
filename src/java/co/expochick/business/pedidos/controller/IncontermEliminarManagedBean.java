/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.business.pedidos.controller;

import co.expochick.backend.persistence.entity.Inconterm;
import co.expochick.backend.persistence.facades.IncontermFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author alexandra
 */
@Named(value = "incontermEliminarManagedBean")
@RequestScoped
public class IncontermEliminarManagedBean implements Serializable {

    @EJB private IncontermFacade infc;
    private Inconterm inconterm;
    
    public IncontermEliminarManagedBean() {
    }

    public Inconterm getInconterm() {
        return inconterm;
    }

    public void setInconterm(Inconterm inconterm) {
        this.inconterm = inconterm;
    }
    
    @PostConstruct
    public void init(){
        inconterm = new Inconterm();
    }
    
    public void eliminarInconterm(Inconterm inconterm){
        try {
            infc.remove(inconterm);
        } catch (Exception e) {
            System.out.println("ERROR - ELIMINAR INCONTERM ! "+e);
        }
    }
    
}
