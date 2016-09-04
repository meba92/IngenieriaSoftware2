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
@Table(name = "detalle_compras")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleCompras.findAll", query = "SELECT d FROM DetalleCompras d"),
    @NamedQuery(name = "DetalleCompras.findByIdCompra", query = "SELECT d FROM DetalleCompras d WHERE d.detalleComprasPK.idCompra = :idCompra"),
    @NamedQuery(name = "DetalleCompras.findByIdProducto", query = "SELECT d FROM DetalleCompras d WHERE d.detalleComprasPK.idProducto = :idProducto"),
    @NamedQuery(name = "DetalleCompras.findByCantidad", query = "SELECT d FROM DetalleCompras d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "DetalleCompras.findByPrecioCompra", query = "SELECT d FROM DetalleCompras d WHERE d.precioCompra = :precioCompra")})
public class DetalleCompras implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetalleComprasPK detalleComprasPK;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "precio_compra")
    private Integer precioCompra;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Productos productos;
    @JoinColumn(name = "id_compra", referencedColumnName = "id_compra", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Compras compras;

    public DetalleCompras() {
    }

    public DetalleCompras(DetalleComprasPK detalleComprasPK) {
        this.detalleComprasPK = detalleComprasPK;
    }

    public DetalleCompras(int idCompra, int idProducto) {
        this.detalleComprasPK = new DetalleComprasPK(idCompra, idProducto);
    }

    public DetalleComprasPK getDetalleComprasPK() {
        return detalleComprasPK;
    }

    public void setDetalleComprasPK(DetalleComprasPK detalleComprasPK) {
        this.detalleComprasPK = detalleComprasPK;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(Integer precioCompra) {
        this.precioCompra = precioCompra;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    public Compras getCompras() {
        return compras;
    }

    public void setCompras(Compras compras) {
        this.compras = compras;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detalleComprasPK != null ? detalleComprasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleCompras)) {
            return false;
        }
        DetalleCompras other = (DetalleCompras) object;
        if ((this.detalleComprasPK == null && other.detalleComprasPK != null) || (this.detalleComprasPK != null && !this.detalleComprasPK.equals(other.detalleComprasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gestorVentas.entity.DetalleCompras[ detalleComprasPK=" + detalleComprasPK + " ]";
    }
    
}
