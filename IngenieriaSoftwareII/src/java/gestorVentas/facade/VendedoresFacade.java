/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestorVentas.facade;

import gestorVentas.entity.Vendedores;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Meba
 */
@Stateless
public class VendedoresFacade extends AbstractFacade<Vendedores> {
    @PersistenceContext(unitName = "GestorVentasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VendedoresFacade() {
        super(Vendedores.class);
    }
    
}
