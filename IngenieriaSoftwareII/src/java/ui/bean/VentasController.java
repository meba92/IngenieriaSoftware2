package ui.bean;

import gestorVentas.entity.Ventas;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "ventasController")
@ViewScoped
public class VentasController extends AbstractController<Ventas> {

    @Inject
    private VendedoresController cedulaVendedorController;
    @Inject
    private ClientesController idClienteController;

    public VentasController() {
        // Inform the Abstract parent controller of the concrete Ventas Entity
        super(Ventas.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        cedulaVendedorController.setSelected(null);
        idClienteController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of DetalleVentas entities
     * that are retrieved from Ventas?cap_first and returns the navigation
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
     * Sets the "selected" attribute of the Vendedores controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCedulaVendedor(ActionEvent event) {
        if (this.getSelected() != null && cedulaVendedorController.getSelected() == null) {
            cedulaVendedorController.setSelected(this.getSelected().getCedulaVendedor());
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
}
