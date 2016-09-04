package ui.bean;

import gestorVentas.entity.DetalleCompras;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "detalleComprasController")
@ViewScoped
public class DetalleComprasController extends AbstractController<DetalleCompras> {

    @Inject
    private ProductosController productosController;
    @Inject
    private ComprasController comprasController;

    public DetalleComprasController() {
        // Inform the Abstract parent controller of the concrete DetalleCompras Entity
        super(DetalleCompras.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getDetalleComprasPK().setIdCompra(this.getSelected().getCompras().getIdCompra());
        this.getSelected().getDetalleComprasPK().setIdProducto(this.getSelected().getProductos().getIdProducto());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setDetalleComprasPK(new gestorVentas.entity.DetalleComprasPK());
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        productosController.setSelected(null);
        comprasController.setSelected(null);
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

    /**
     * Sets the "selected" attribute of the Compras controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCompras(ActionEvent event) {
        if (this.getSelected() != null && comprasController.getSelected() == null) {
            comprasController.setSelected(this.getSelected().getCompras());
        }
    }
}
