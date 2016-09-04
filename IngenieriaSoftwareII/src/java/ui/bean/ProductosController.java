package ui.bean;

import gestorVentas.entity.Productos;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "productosController")
@ViewScoped
public class ProductosController extends AbstractController<Productos> {

    public ProductosController() {
        // Inform the Abstract parent controller of the concrete Productos Entity
        super(Productos.class);
    }

    /**
     * Sets the "items" attribute with a collection of DetalleVentas entities
     * that are retrieved from Productos?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for DetalleVentas page
     */
    public String navigateDetalleVentasCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("DetalleVentas_items", this.getSelected().getDetalleVentasCollection());
        }
        return "/entity/detalleVentas/index";
    }

    /**
     * Sets the "items" attribute with a collection of DetalleCompras entities
     * that are retrieved from Productos?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for DetalleCompras page
     */
    public String navigateDetalleComprasCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("DetalleCompras_items", this.getSelected().getDetalleComprasCollection());
        }
        return "/entity/detalleCompras/index";
    }

    /**
     * Sets the "items" attribute with a collection of DetallePedidos entities
     * that are retrieved from Productos?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for DetallePedidos page
     */
    public String navigateDetallePedidosCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("DetallePedidos_items", this.getSelected().getDetallePedidosCollection());
        }
        return "/entity/detallePedidos/index";
    }

}
