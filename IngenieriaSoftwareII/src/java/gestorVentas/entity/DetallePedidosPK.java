/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestorVentas.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Meba
 */
@Embeddable
public class DetallePedidosPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_pedido")
    private int idPedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_producto")
    private int idProducto;

    public DetallePedidosPK() {
    }

    public DetallePedidosPK(int idPedido, int idProducto) {
        this.idPedido = idPedido;
        this.idProducto = idProducto;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPedido;
        hash += (int) idProducto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallePedidosPK)) {
            return false;
        }
        DetallePedidosPK other = (DetallePedidosPK) object;
        if (this.idPedido != other.idPedido) {
            return false;
        }
        if (this.idProducto != other.idProducto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gestorVentas.entity.DetallePedidosPK[ idPedido=" + idPedido + ", idProducto=" + idProducto + " ]";
    }
    
}
