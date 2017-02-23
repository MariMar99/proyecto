/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.business.pedidos.controller;

import co.expochick.backend.persistence.entity.EstadoPedido;
import co.expochick.backend.persistence.facades.EstadoPedidoFacade;
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
@Named(value = "estadoPedidoListarManagedBean")
@RequestScoped
public class EstadoPedidoListarManagedBean implements Serializable {

    @EJB private EstadoPedidoFacade espfc;
    private EstadoPedido estadoPedido;
    
    public EstadoPedidoListarManagedBean() {
    }

    public EstadoPedidoFacade getEspfc() {
        return espfc;
    }

    public void setEspfc(EstadoPedidoFacade espfc) {
        this.espfc = espfc;
    }
    
    @PostConstruct
    public void init(){
        estadoPedido = new EstadoPedido();
    }
    
    public List<EstadoPedido> listarEstadoPedidos(){
        return espfc.findAll();
    }
    
}
