/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.business.usuarios.controller;

import co.expochick.backend.persistence.entity.Cliente;
import co.expochick.backend.persistence.facades.ClienteFacade;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author alexandra
 */
@Named(value = "clienteModificarManagedBean")
@RequestScoped
public class ClienteModificarManagedBean {

    @EJB private ClienteFacade clifc;
    private Cliente cliente;
    
    public ClienteModificarManagedBean() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    @PostConstruct
    public void init(){
        cliente = new Cliente();
    }
    
    public void modificarCliente(){
        try {
            clifc.edit(cliente);
        } catch (Exception e) {
            System.out.println("ERROR - MODIFICAR CLIENTE ! "+e);
        }
    }
    
}
