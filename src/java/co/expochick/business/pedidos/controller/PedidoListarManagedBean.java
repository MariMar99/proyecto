/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.business.pedidos.controller;

import co.expochick.backend.persistence.entity.Pedido;
import co.expochick.backend.persistence.facades.PedidoFacade;
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
@Named(value = "pedidoListarManagedBean")
@RequestScoped
public class PedidoListarManagedBean implements Serializable {

    @EJB private PedidoFacade pedfc;
    private Pedido pedido;
    
    public PedidoListarManagedBean() {
    }

    public PedidoFacade getPedfc() {
        return pedfc;
    }

    public void setPedfc(PedidoFacade pedfc) {
        this.pedfc = pedfc;
    }
    
    @PostConstruct
    public void init(){
        pedido = new Pedido();
    }
    
    public List<Pedido> listarPedidos(){
        return pedfc.findAll();
    }
    
}
