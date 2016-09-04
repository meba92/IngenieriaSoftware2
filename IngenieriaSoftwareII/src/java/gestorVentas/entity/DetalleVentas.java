/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestorVentas.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Meba
 */
@Entity
@Table(name = "detalle_ventas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleVentas.findAll", query = "SELECT d FROM DetalleVentas d"),
    @NamedQuery(name = "DetalleVentas.findByIdProducto", query = "SELECT d FROM DetalleVentas d WHERE d.detalleVentasPK.idProducto = :idProducto"),
    @NamedQuery(name = "DetalleVentas.findByIdVenta", query = "SELECT d FROM DetalleVentas d WHERE d.detalleVentasPK.idVenta = :idVenta"),
    @NamedQuery(name = "DetalleVentas.findByCantidad", query = "SELECT d FROM DetalleVentas d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "DetalleVentas.findByPrecio", query = "SELECT d FROM DetalleVentas d WHERE d.precio = :precio")})
public class DetalleVentas implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetalleVentasPK detalleVentasPK;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "precio")
    private Integer precio;
    @JoinColumn(name = "id_venta", referencedColumnName = "id_venta", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ventas ventas;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Productos productos;

    public DetalleVentas() {
    }

    public DetalleVentas(DetalleVentasPK detalleVentasPK) {
        this.detalleVentasPK = detalleVentasPK;
    }

    public DetalleVentas(int idProducto, int idVenta) {
        this.detalleVentasPK = new DetalleVentasPK(idProducto, idVenta);
    }

    public DetalleVentasPK getDetalleVentasPK() {
        return detalleVentasPK;
    }

    public void setDetalleVentasPK(DetalleVentasPK detalleVentasPK) {
        this.detalleVentasPK = detalleVentasPK;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Ventas getVentas() {
        return ventas;
    }

    public void setVentas(Ventas ventas) {
        this.ventas = ventas;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detalleVentasPK != null ? detalleVentasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleVentas)) {
            return false;
        }
        DetalleVentas other = (DetalleVentas) object;
        if ((this.detalleVentasPK == null && other.detalleVentasPK != null) || (this.detalleVentasPK != null && !this.detalleVentasPK.equals(other.detalleVentasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gestorVentas.entity.DetalleVentas[ detalleVentasPK=" + detalleVentasPK + " ]";
    }
    
}
