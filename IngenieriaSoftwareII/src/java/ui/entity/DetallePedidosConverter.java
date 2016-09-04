package ui.entity;

import gestorVentas.entity.DetallePedidos;
import gestorVentas.facade.DetallePedidosFacade;
import ui.bean.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@FacesConverter(value = "detallePedidosConverter")
public class DetallePedidosConverter implements Converter {

    @Inject
    private DetallePedidosFacade ejbFacade;

    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.ejbFacade.find(getKey(value));
    }

    gestorVentas.entity.DetallePedidosPK getKey(String value) {
        gestorVentas.entity.DetallePedidosPK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new gestorVentas.entity.DetallePedidosPK();
        key.setIdPedido(Integer.parseInt(values[0]));
        key.setIdProducto(Integer.parseInt(values[1]));
        return key;
    }

    String getStringKey(gestorVentas.entity.DetallePedidosPK value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value.getIdPedido());
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
        if (object instanceof DetallePedidos) {
            DetallePedidos o = (DetallePedidos) object;
            return getStringKey(o.getDetallePedidosPK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), DetallePedidos.class.getName()});
            return null;
        }
    }

}
