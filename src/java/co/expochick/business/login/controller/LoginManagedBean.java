/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.business.login.controller;

import co.expochick.backend.persistence.entity.Permiso;
import co.expochick.backend.persistence.entity.Rol;
import co.expochick.backend.persistence.entity.Usuario;
import co.expochick.backend.persistence.facades.UsuarioFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author alexandra
 */
@Named(value = "loginManagedBean")
@SessionScoped
public class LoginManagedBean implements Serializable {

    @EJB
    private UsuarioFacade usufc;
    private Usuario usuario;
    private Rol rol;
    private Permiso permiso;

    public LoginManagedBean() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Permiso getPermiso() {
        return permiso;
    }

    public void setPermiso(Permiso permiso) {
        this.permiso = permiso;
    }

    @PostConstruct
    public void init() {
        usuario = new Usuario();
        rol = new Rol();
    }

    public String ingresarSesion() {
        try {
            usuario = usufc.ingreso(usuario);
            if (usuario != null) {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", usuario);
                return "/EvaluacionEmail/faces/paginas/inicio.xhtml?faces-redirect=true";

            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario y/o Contraseña Incorrectos"));
                return "";
            }
        } catch (Exception e) {
            System.out.println("NO INGRESO AL SISTEMA");
            return "";
        }
    }

}
