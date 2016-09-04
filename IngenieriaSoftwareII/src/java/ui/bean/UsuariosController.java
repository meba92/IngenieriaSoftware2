package ui.bean;

import gestorVentas.entity.Usuarios;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "usuariosController")
@ViewScoped
public class UsuariosController extends AbstractController<Usuarios> {

    @Inject
    private VendedoresController idVendedorController;

    public UsuariosController() {
        // Inform the Abstract parent controller of the concrete Usuarios Entity
        super(Usuarios.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idVendedorController.setSelected(null);
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
}
