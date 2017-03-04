/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.business.pedidos.controller;

import co.expochick.backend.persistence.entity.Inconterm;
import co.expochick.backend.persistence.facades.IncontermFacade;
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
@Named(value = "incontermListarManagedBean")
@RequestScoped
public class IncontermListarManagedBean implements Serializable {

    @EJB private IncontermFacade infc;
    private Inconterm inconterm;
    
    public IncontermListarManagedBean() {
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
    
    public List<Inconterm> listaInconterms(){
        return infc.findAll();
    }
      
}
