package ui.bean;

import gestorVentas.entity.Proveedores;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "proveedoresController")
@ViewScoped
public class ProveedoresController extends AbstractController<Proveedores> {

    @Inject
    private LocalidadController idLocalidadController;

    public ProveedoresController() {
        // Inform the Abstract parent controller of the concrete Proveedores Entity
        super(Proveedores.class);
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
}
