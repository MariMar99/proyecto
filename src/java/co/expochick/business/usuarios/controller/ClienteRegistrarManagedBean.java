/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.business.usuarios.controller;

import co.expochick.backend.persistence.entity.Cliente;
import co.expochick.backend.persistence.entity.Usuario;
import co.expochick.backend.persistence.facades.ClienteFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author alexandra
 */
@Named(value = "clienteRegistrarManagedBean")
@RequestScoped
public class ClienteRegistrarManagedBean implements Serializable {

    @EJB private ClienteFacade clifc;
    private Cliente cliente;
    
    public ClienteRegistrarManagedBean() {
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
    
    public void RegistrarCliente(){
        try {
            clifc.create(cliente);
        } catch (Exception e) {
            System.out.println("ERROR - REGISTRAR CLIENTE ! "+e);
        }
    }
    
}
