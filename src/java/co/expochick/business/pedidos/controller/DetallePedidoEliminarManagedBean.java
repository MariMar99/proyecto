/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.business.pedidos.controller;

import co.expochick.backend.persistence.entity.DetallePedido;
import co.expochick.backend.persistence.facades.DetallePedidoFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author alexandra
 */
@Named(value = "detallePedidoEliminarManagedBean")
@RequestScoped
public class DetallePedidoEliminarManagedBean implements Serializable {

    @EJB private DetallePedidoFacade dtpfc;
    private DetallePedido detPedido;
    
    public DetallePedidoEliminarManagedBean() {
    }

    public DetallePedido getDetPedido() {
        return detPedido;
    }

    public void setDetPedido(DetallePedido detPedido) {
        this.detPedido = detPedido;
    }
    
    @PostConstruct
    public void init(){
        detPedido = new DetallePedido();
    }
    
    public void eliminarDetallePedido(){
        try {
            dtpfc.remove(detPedido);
        } catch (Exception e) {
            System.out.println("ERROR - ELIMINAR DETALLE PEDIDO ! "+ e);
        }
    }
    
    
}
