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
@Table(name = "detalle_pedidos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetallePedidos.findAll", query = "SELECT d FROM DetallePedidos d"),
    @NamedQuery(name = "DetallePedidos.findByIdPedido", query = "SELECT d FROM DetallePedidos d WHERE d.detallePedidosPK.idPedido = :idPedido"),
    @NamedQuery(name = "DetallePedidos.findByIdProducto", query = "SELECT d FROM DetallePedidos d WHERE d.detallePedidosPK.idProducto = :idProducto"),
    @NamedQuery(name = "DetallePedidos.findByCantidad", query = "SELECT d FROM DetallePedidos d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "DetallePedidos.findByPrecio", query = "SELECT d FROM DetallePedidos d WHERE d.precio = :precio"),
    @NamedQuery(name = "DetallePedidos.findByDescuento", query = "SELECT d FROM DetallePedidos d WHERE d.descuento = :descuento")})
public class DetallePedidos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetallePedidosPK detallePedidosPK;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "precio")
    private Integer precio;
    @Column(name = "descuento")
    private Integer descuento;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Productos productos;
    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pedidos pedidos;

    public DetallePedidos() {
    }

    public DetallePedidos(DetallePedidosPK detallePedidosPK) {
        this.detallePedidosPK = detallePedidosPK;
    }

    public DetallePedidos(int idPedido, int idProducto) {
        this.detallePedidosPK = new DetallePedidosPK(idPedido, idProducto);
    }

    public DetallePedidosPK getDetallePedidosPK() {
        return detallePedidosPK;
    }

    public void setDetallePedidosPK(DetallePedidosPK detallePedidosPK) {
        this.detallePedidosPK = detallePedidosPK;
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

    public Integer getDescuento() {
        return descuento;
    }

    public void setDescuento(Integer descuento) {
        this.descuento = descuento;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    public Pedidos getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedidos pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detallePedidosPK != null ? detallePedidosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallePedidos)) {
            return false;
        }
        DetallePedidos other = (DetallePedidos) object;
        if ((this.detallePedidosPK == null && other.detallePedidosPK != null) || (this.detallePedidosPK != null && !this.detallePedidosPK.equals(other.detallePedidosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gestorVentas.entity.DetallePedidos[ detallePedidosPK=" + detallePedidosPK + " ]";
    }
    
}
