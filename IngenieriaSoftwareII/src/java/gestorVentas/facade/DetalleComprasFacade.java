/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestorVentas.facade;

import gestorVentas.entity.DetalleCompras;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Meba
 */
@Stateless
public class DetalleComprasFacade extends AbstractFacade<DetalleCompras> {
    @PersistenceContext(unitName = "GestorVentasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleComprasFacade() {
        super(DetalleCompras.class);
    }
    
}
