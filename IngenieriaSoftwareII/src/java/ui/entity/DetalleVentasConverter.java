package ui.entity;

import gestorVentas.entity.DetalleVentas;
import gestorVentas.facade.DetalleVentasFacade;
import ui.bean.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@FacesConverter(value = "detalleVentasConverter")
public class DetalleVentasConverter implements Converter {

    @Inject
    private DetalleVentasFacade ejbFacade;

    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.ejbFacade.find(getKey(value));
    }

    gestorVentas.entity.DetalleVentasPK getKey(String value) {
        gestorVentas.entity.DetalleVentasPK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new gestorVentas.entity.DetalleVentasPK();
        key.setIdProducto(Integer.parseInt(values[0]));
        key.setIdVenta(Integer.parseInt(values[1]));
        return key;
    }

    String getStringKey(gestorVentas.entity.DetalleVentasPK value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value.getIdProducto());
        sb.append(SEPARATOR);
        sb.append(value.getIdVenta());
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof DetalleVentas) {
            DetalleVentas o = (DetalleVentas) object;
            return getStringKey(o.getDetalleVentasPK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), DetalleVentas.class.getName()});
            return null;
        }
    }

}
