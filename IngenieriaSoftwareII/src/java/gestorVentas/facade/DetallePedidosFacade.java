/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestorVentas.facade;

import gestorVentas.entity.DetallePedidos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Meba
 */
@Stateless
public class DetallePedidosFacade extends AbstractFacade<DetallePedidos> {
    @PersistenceContext(unitName = "GestorVentasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetallePedidosFacade() {
        super(DetallePedidos.class);
    }
    
}
