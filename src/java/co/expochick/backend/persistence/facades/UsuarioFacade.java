/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.backend.persistence.facades;

import co.expochick.backend.persistence.entity.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author alexandra
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "ProyectoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    //Ingresar - Iniciar Sesión
    public Usuario ingreso(Usuario us) {
        TypedQuery<Usuario> qe = em.createQuery("FROM Usuario us WHERE us.email = ?1 and us.clave = ?2", Usuario.class);
        qe.setParameter(1, us.getEmail());
        qe.setParameter(2, us.getClave());
        if (!qe.getResultList().isEmpty()) {
            return qe.getResultList().get(0);
        }else{
            return null;
        }
    }
    
}
