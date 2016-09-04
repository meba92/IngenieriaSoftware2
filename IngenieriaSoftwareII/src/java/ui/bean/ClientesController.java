package ui.bean;

import gestorVentas.entity.Clientes;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "clientesController")
@ViewScoped
public class ClientesController extends AbstractController<Clientes> {

    @Inject
    private LocalidadController idLocalidadController;

    public ClientesController() {
        // Inform the Abstract parent controller of the concrete Clientes Entity
        super(Clientes.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idLocalidadController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Localidad controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdLocalidad(ActionEvent event) {
        if (this.getSelected() != null && idLocalidadController.getSelected() == null) {
            idLocalidadController.setSelected(this.getSelected().getIdLocalidad());
        }
    }

    /**
     * Sets the "items" attribute with a collection of Pedidos entities that are
     * retrieved from Clientes?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Pedidos page
     */
    public String navigatePedidosCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Pedidos_items", this.getSelected().getPedidosCollection());
        }
        return "/entity/pedidos/index";
    }

    /**
     * Sets the "items" attribute with a collection of Ventas entities that are
     * retrieved from Clientes?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Ventas page
     */
    public String navigateVentasCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Ventas_items", this.getSelected().getVentasCollection());
        }
        return "/entity/ventas/index";
    }

    /**
     * Sets the "items" attribute with a collection of Compras entities that are
     * retrieved from Clientes?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Compras page
     */
    public String navigateComprasCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Compras_items", this.getSelected().getComprasCollection());
        }
        return "/entity/compras/index";
    }

}
