package ui.bean;

import gestorVentas.entity.Compras;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "comprasController")
@ViewScoped
public class ComprasController extends AbstractController<Compras> {

    @Inject
    private ClientesController idProveedorController;

    public ComprasController() {
        // Inform the Abstract parent controller of the concrete Compras Entity
        super(Compras.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idProveedorController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of DetalleCompras entities
     * that are retrieved from Compras?cap_first and returns the navigation
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
     * Sets the "selected" attribute of the Clientes controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdProveedor(ActionEvent event) {
        if (this.getSelected() != null && idProveedorController.getSelected() == null) {
            idProveedorController.setSelected(this.getSelected().getIdProveedor());
        }
    }
}
