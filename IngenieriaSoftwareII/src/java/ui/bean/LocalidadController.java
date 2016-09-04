package ui.bean;

import gestorVentas.entity.Localidad;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "localidadController")
@ViewScoped
public class LocalidadController extends AbstractController<Localidad> {

    public LocalidadController() {
        // Inform the Abstract parent controller of the concrete Localidad Entity
        super(Localidad.class);
    }

    /**
     * Sets the "items" attribute with a collection of Clientes entities that
     * are retrieved from Localidad?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Clientes page
     */
    public String navigateClientesCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Clientes_items", this.getSelected().getClientesCollection());
        }
        return "/entity/clientes/index";
    }

    /**
     * Sets the "items" attribute with a collection of Vendedores entities that
     * are retrieved from Localidad?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Vendedores page
     */
    public String navigateVendedoresCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Vendedores_items", this.getSelected().getVendedoresCollection());
        }
        return "/entity/vendedores/index";
    }

    /**
     * Sets the "items" attribute with a collection of Proveedores entities that
     * are retrieved from Localidad?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Proveedores page
     */
    public String navigateProveedoresCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Proveedores_items", this.getSelected().getProveedoresCollection());
        }
        return "/entity/proveedores/index";
    }

}
