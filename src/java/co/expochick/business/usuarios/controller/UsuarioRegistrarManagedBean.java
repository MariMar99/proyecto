/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.business.usuarios.controller;

import co.expochick.backend.persistence.entity.Usuario;
import co.expochick.backend.persistence.facades.UsuarioFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author alexandra
 */
@Named(value = "usuarioRegistrarManagedBean")
@RequestScoped
public class UsuarioRegistrarManagedBean implements Serializable {

    @EJB private UsuarioFacade usufc;
    private Usuario usuario;
            
    public UsuarioRegistrarManagedBean() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    @PostConstruct
    public void init(){
        usuario = new Usuario();
    }
    
    public void registrarUsuario(){
        try {
            usufc.create(usuario);
        } catch (Exception e) {
            System.out.println("ERROR - REGISTRAR USUARIO ! "+e);
        }
    }
    
}
