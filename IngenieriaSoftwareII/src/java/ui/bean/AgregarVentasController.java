/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.bean;

/**
 *
 * @author Emi
 */
import gestorVentas.entity.Clientes;
import gestorVentas.entity.DetalleVentas;
import gestorVentas.entity.Productos;
import gestorVentas.entity.Vendedores;
import gestorVentas.entity.Ventas;
import gestorVentas.facade.ClientesFacade;
import gestorVentas.facade.DetalleVentasFacade;
import gestorVentas.facade.ProductosFacade;
import gestorVentas.facade.VendedoresFacade;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;


@Named("agregarVentasController")
@SessionScoped

public class AgregarVentasController implements Serializable {
    private String nroFactura;
    private String fechaVenta;
    private List<Clientes> clientesList = new ArrayList<Clientes>(); //comboClientes
    private List<Vendedores> vendedoresList = new ArrayList<Vendedores>(); //comboVendedores
    private List<Productos> productosList = new ArrayList<Productos>(); //comboProductos
    private List<DetalleVentas> listaDetalle = new ArrayList<DetalleVentas>(); //DataTable Detalle Ventas
    private Productos producto = new Productos();
    private Ventas venta = new Ventas();
    private Clientes idCliente;
    private Vendedores cedulaVendedor;
    private int cantidad;
    private int totalFactura;
    @EJB
    private ClientesFacade clientesFacade = new ClientesFacade();
    @EJB
    private VendedoresFacade vendedoresFacade = new VendedoresFacade();
    @EJB
    private ProductosFacade productosFacade = new ProductosFacade();
    @EJB
    private DetalleVentasFacade detVentasFacade = new DetalleVentasFacade();

    public int getTotalFactura() {
        return totalFactura;
    }

    public void setTotalFactura(int totalFactura) {
        this.totalFactura = totalFactura;
    }

    public Ventas getVenta() {
        return venta;
    }

    public void setVenta(Ventas venta) {
        this.venta = venta;
    }


    public List<DetalleVentas> getListaDetalle() {
        return listaDetalle;
    }

    public void setListaDetalle(List<DetalleVentas> listaDetalle) {
        this.listaDetalle = listaDetalle;
    }
    
    public void eliminarProducto(DetalleVentas item){
        listaDetalle.remove(item);
        this.totalFactura -= item.getProductos().getPrecio() * item.getCantidad();
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public List<Productos> getProductosList() {
        return productosList;
    }

    public void setProductosList(List<Productos> productosList) {
        this.productosList = productosList;
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }

    public Clientes getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Clientes idCliente) {
        this.idCliente = idCliente;
    }

    public Vendedores getCedulaVendedor() {
        return cedulaVendedor;
    }

    public void setCedulaVendedor(Vendedores cedulaVendedor) {
        this.cedulaVendedor = cedulaVendedor;
    }
    
    public String getNroFactura() {
        return nroFactura;
    }

    public void setNroFactura(String nroFactura) {
        this.nroFactura = nroFactura;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }
    public List<Clientes> getClientesList() {
        return clientesList;
    }

    public void setClientesList(List<Clientes> clientesList) {
        this.clientesList = clientesList;
    }

    public List<Vendedores> getVendedoresList() {
        return vendedoresList;
    }

    public void setVendedoresList(List<Vendedores> vendedoresList) {
        this.vendedoresList = vendedoresList;
    }
    
    private Connection con = null;
    
    @PostConstruct
    void initialiseSession() {
        con = DataConnect.getConnection();
        this.cargarVista();
    }

    public void cargarVista() {
        this.clientesList = clientesFacade.findAll();
        this.vendedoresList = vendedoresFacade.findAll();
        this.productosList = productosFacade.findAll();
        this.listaDetalle = detVentasFacade.findAll();
        int nuevaSeq = obtenerNroVenta();
        if (nuevaSeq < 10) {
            this.nroFactura = "0000-0000-000" + String.valueOf(nuevaSeq);
        } else if (nuevaSeq < 100) {
            this.nroFactura = "0000-0000-0" + String.valueOf(nuevaSeq);
        } else {
            this.nroFactura = String.valueOf(nuevaSeq);
        }
        
        Date date = Calendar.getInstance().getTime();
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String today = formatter.format(date);
        this.fechaVenta = today;    
    }

    public int obtenerNroVenta() {
        int ultimoValor = 0;
        try {
            PreparedStatement ps
                    = con.prepareStatement("SELECT last_value FROM id_venta_seq");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BigDecimal uv = rs.getBigDecimal("last_value");
                ultimoValor = uv.toBigInteger().intValue();
            }
        } catch (SQLException ex) {
            
        }
        return ultimoValor;
    } 
    
    public void agregarProducto() {
        DetalleVentas det = new DetalleVentas();
        det.setCantidad(cantidad);
        det.setProductos(producto);
        this.listaDetalle.add(det);
        this.totalFactura += det.getProductos().getPrecio() * det.getCantidad();
    }
    
    public int totalFactura(){
        int montoTotal=0;
        for (DetalleVentas listaDetalle1 : listaDetalle) {
            int monto = listaDetalle1.getPrecio() * listaDetalle1.getCantidad();
            montoTotal = montoTotal+ monto;
        }
        return montoTotal;
    }
    
    public void registrar(){
        
    }
      
    public void cancelar(){
        cargarVista();
        this.totalFactura = 0;
        this.cantidad=0;
    }
    
    public void onRowEdit(RowEditEvent event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                FacesMessage.SEVERITY_INFO,"Informacion","Cantidad editada"));
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                FacesMessage.SEVERITY_INFO,"Informacion","Guardada sin cambios"));
    }
    
    
}
