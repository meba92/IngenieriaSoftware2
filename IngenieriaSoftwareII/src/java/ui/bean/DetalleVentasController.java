package ui.bean;

import gestorVentas.entity.DetalleVentas;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "detalleVentasController")
@ViewScoped
public class DetalleVentasController extends AbstractController<DetalleVentas> {

    @Inject
    private VentasController ventasController;
    @Inject
    private ProductosController productosController;

    public DetalleVentasController() {
        // Inform the Abstract parent controller of the concrete DetalleVentas Entity
        super(DetalleVentas.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getDetalleVentasPK().setIdProducto(this.getSelected().getProductos().getIdProducto());
        this.getSelected().getDetalleVentasPK().setIdVenta(this.getSelected().getVentas().getIdVenta());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setDetalleVentasPK(new gestorVentas.entity.DetalleVentasPK());
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        ventasController.setSelected(null);
        productosController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Ventas controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareVentas(ActionEvent event) {
        if (this.getSelected() != null && ventasController.getSelected() == null) {
            ventasController.setSelected(this.getSelected().getVentas());
        }
    }

    /**
     * Sets the "selected" attribute of the Productos controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareProductos(ActionEvent event) {
        if (this.getSelected() != null && productosController.getSelected() == null) {
            productosController.setSelected(this.getSelected().getProductos());
        }
    }
}
