package ui.bean;

import gestorVentas.entity.DetallePedidos;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "detallePedidosController")
@ViewScoped
public class DetallePedidosController extends AbstractController<DetallePedidos> {

    @Inject
    private ProductosController productosController;
    @Inject
    private PedidosController pedidosController;

    public DetallePedidosController() {
        // Inform the Abstract parent controller of the concrete DetallePedidos Entity
        super(DetallePedidos.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getDetallePedidosPK().setIdPedido(this.getSelected().getPedidos().getIdPedido());
        this.getSelected().getDetallePedidosPK().setIdProducto(this.getSelected().getProductos().getIdProducto());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setDetallePedidosPK(new gestorVentas.entity.DetallePedidosPK());
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        productosController.setSelected(null);
        pedidosController.setSelected(null);
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
     * Sets the "selected" attribute of the Pedidos controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void preparePedidos(ActionEvent event) {
        if (this.getSelected() != null && pedidosController.getSelected() == null) {
            pedidosController.setSelected(this.getSelected().getPedidos());
        }
    }
}
