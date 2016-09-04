package ui.entity;

import gestorVentas.entity.DetalleCompras;
import gestorVentas.facade.DetalleComprasFacade;
import ui.bean.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@FacesConverter(value = "detalleComprasConverter")
public class DetalleComprasConverter implements Converter {

    @Inject
    private DetalleComprasFacade ejbFacade;

    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.ejbFacade.find(getKey(value));
    }

    gestorVentas.entity.DetalleComprasPK getKey(String value) {
        gestorVentas.entity.DetalleComprasPK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new gestorVentas.entity.DetalleComprasPK();
        key.setIdCompra(Integer.parseInt(values[0]));
        key.setIdProducto(Integer.parseInt(values[1]));
        return key;
    }

    String getStringKey(gestorVentas.entity.DetalleComprasPK value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value.getIdCompra());
        sb.append(SEPARATOR);
        sb.append(value.getIdProducto());
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof DetalleCompras) {
            DetalleCompras o = (DetalleCompras) object;
            return getStringKey(o.getDetalleComprasPK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), DetalleCompras.class.getName()});
            return null;
        }
    }

}
