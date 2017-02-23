/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.business.pedidos.controller;

import co.expochick.backend.persistence.entity.Pallet;
import co.expochick.backend.persistence.facades.PalletFacade;
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
@Named(value = "palletListarManagedBean")
@RequestScoped
public class PalletListarManagedBean implements Serializable {

    @EJB private PalletFacade pllfc;
    private Pallet pallet;
    
    public PalletListarManagedBean() {
    }

    public Pallet getPallet() {
        return pallet;
    }

    public void setPallet(Pallet pallet) {
        this.pallet = pallet;
    }
    
    @PostConstruct
    public void init(){
        pallet = new Pallet();
    }
    
    public List<Pallet> listarPallets(){
        return pllfc.findAll();
    }
    
}
