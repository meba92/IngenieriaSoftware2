package ui.bean;

import gestorVentas.entity.Pedidos;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "pedidosController")
@ViewScoped
public class PedidosController extends AbstractController<Pedidos> {

    @Inject
    private VendedoresController idVendedorController;
    @Inject
    private ClientesController idClienteController;

    public PedidosController() {
        // Inform the Abstract parent controller of the concrete Pedidos Entity
        super(Pedidos.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idVendedorController.setSelected(null);
        idClienteController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Vendedores controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdVendedor(ActionEvent event) {
        if (this.getSelected() != null && idVendedorController.getSelected() == null) {
            idVendedorController.setSelected(this.getSelected().getIdVendedor());
        }
    }

    /**
     * Sets the "selected" attribute of the Clientes controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdCliente(ActionEvent event) {
        if (this.getSelected() != null && idClienteController.getSelected() == null) {
            idClienteController.setSelected(this.getSelected().getIdCliente());
        }
    }

    /**
     * Sets the "items" attribute with a collection of DetallePedidos entities
     * that are retrieved from Pedidos?cap_first and returns the navigation
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
