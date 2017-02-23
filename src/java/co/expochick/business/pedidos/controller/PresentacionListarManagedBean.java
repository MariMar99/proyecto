/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.business.pedidos.controller;

import co.expochick.backend.persistence.entity.Presentacion;
import co.expochick.backend.persistence.facades.PresentacionFacade;
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
@Named(value = "presentacionListarManagedBean")
@RequestScoped
public class PresentacionListarManagedBean implements Serializable {

    @EJB private PresentacionFacade prfc;
    private Presentacion presentacion;

    public PresentacionListarManagedBean() {
    }

    public Presentacion getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(Presentacion presentacion) {
        this.presentacion = presentacion;
    }

    @PostConstruct
    public void init() {
        presentacion = new Presentacion();
    }

    public List<Presentacion> listarPresentacion() {
        return this.prfc.findAll();
    }

}
