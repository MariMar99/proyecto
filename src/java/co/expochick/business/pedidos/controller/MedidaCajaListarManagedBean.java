/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.business.pedidos.controller;

import co.expochick.backend.persistence.entity.MedidaCaja;
import co.expochick.backend.persistence.facades.MedidaCajaFacade;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author alexandra
 */
@Named(value = "medidaCajaRegistrarManagedBean")
@RequestScoped
public class MedidaCajaListarManagedBean {

    @EJB private MedidaCajaFacade medCfc;
    private MedidaCaja medCaja;
    
    public MedidaCajaListarManagedBean() {
    }

    public MedidaCaja getMedCaja() {
        return medCaja;
    }

    public void setMedCaja(MedidaCaja medCaja) {
        this.medCaja = medCaja;
    }
    
    @PostConstruct
    public void init(){
        medCaja = new MedidaCaja();
    }

    public List<MedidaCaja> listarMedidasCajas(){
        return medCfc.findAll();
    }
    
}
