/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.business.usuarios.controller;

import co.expochick.backend.persistence.entity.Rol;
import co.expochick.backend.persistence.facades.RolFacade;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author alexandra
 */
@Named(value = "rolListarManagedBean")
@RequestScoped
public class RolListarManagedBean {

    @EJB private RolFacade rolfc;
    private Rol rol;
    
    public RolListarManagedBean() {
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    @PostConstruct
    public void init(){
        rol = new Rol();
    }
    
    public List<Rol> listarRoles(){
        return rolfc.findAll();
    }
            
}
