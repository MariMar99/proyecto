/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.business.usuarios.controller;

import co.expochick.backend.persistence.entity.Telefono;
import co.expochick.backend.persistence.facades.TelefonoFacade;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author alexandra
 */
@Named(value = "telefonoEliminarManagedBean")
@RequestScoped
public class TelefonoEliminarManagedBean {

    @EJB private TelefonoFacade telfc;
    private Telefono tel;
    
    public TelefonoEliminarManagedBean() {
    }

    public Telefono getTel() {
        return tel;
    }

    public void setTel(Telefono tel) {
        this.tel = tel;
    }
    
    @PostConstruct
    public void init(){
        tel = new Telefono();
    }

    public void eliminarTel(){
        try {
            telfc.remove(tel);
        } catch (Exception e) {
            System.out.println("ERROR - ELIMINAR TELEFONO ! "+e);
        }
    }
}
