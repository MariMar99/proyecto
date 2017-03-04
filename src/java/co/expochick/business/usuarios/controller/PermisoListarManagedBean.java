/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.business.usuarios.controller;

import co.expochick.backend.persistence.entity.Permiso;
import co.expochick.backend.persistence.facades.PermisoFacade;
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
@Named(value = "permisoListarManagedBean")
@RequestScoped
public class PermisoListarManagedBean implements Serializable {

    @EJB private PermisoFacade perfc;
    private Permiso permiso;
    
    public PermisoListarManagedBean() {
    }

    public PermisoFacade getPerfc() {
        return perfc;
    }

    public void setPerfc(PermisoFacade perfc) {
        this.perfc = perfc;
    }
    
    @PostConstruct
    public void init(){
        permiso = new Permiso();
    }
    
    public List<Permiso> listarPermisos(){
        return perfc.findAll();
    }
    
}
