package ui.bean;

import gestorVentas.entity.Vendedores;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "vendedoresController")
@ViewScoped
public class VendedoresController extends AbstractController<Vendedores> {

    @Inject
    private LocalidadController idLocalidadController;

    public VendedoresController() {
        // Inform the Abstract parent controller of the concrete Vendedores Entity
        super(Vendedores.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idLocalidadController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Pedidos entities that are
     * retrieved from Vendedores?cap_first and returns the navigation outcome.
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
     * Sets the "items" attribute with a collection of Ventas entities that are
     * retrieved from Vendedores?cap_first and returns the navigation outcome.
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
     * Sets the "items" attribute with a collection of Usuarios entities that
     * are retrieved from Vendedores?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Usuarios page
     */
    public String navigateUsuariosCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Usuarios_items", this.getSelected().getUsuariosCollection());
        }
        return "/entity/usuarios/index";
    }

}
