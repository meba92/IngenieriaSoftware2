/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestorVentas.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Meba
 */
@Entity
@Table(name = "pedidos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedidos.findAll", query = "SELECT p FROM Pedidos p"),
    @NamedQuery(name = "Pedidos.findByIdPedido", query = "SELECT p FROM Pedidos p WHERE p.idPedido = :idPedido"),
    @NamedQuery(name = "Pedidos.findByFechaPedido", query = "SELECT p FROM Pedidos p WHERE p.fechaPedido = :fechaPedido"),
    @NamedQuery(name = "Pedidos.findByFechaEntrega", query = "SELECT p FROM Pedidos p WHERE p.fechaEntrega = :fechaEntrega")})
public class Pedidos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_pedido")
    @GeneratedValue(generator="PedidoSeq")
    @SequenceGenerator(name="PedidoSeq",sequenceName="id_pedidos_seq",
    allocationSize=1)
    private Integer idPedido;
    @Column(name = "fecha_pedido")
    @Temporal(TemporalType.DATE)
    private Date fechaPedido;
    @Column(name = "fecha_entrega")
    @Temporal(TemporalType.DATE)
    private Date fechaEntrega;
    @JoinColumn(name = "id_vendedor", referencedColumnName = "cedula")
    @ManyToOne
    private Vendedores idVendedor;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne
    private Clientes idCliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedidos")
    private Collection<DetallePedidos> detallePedidosCollection;

    public Pedidos() {
    }

    public Pedidos(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Vendedores getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Vendedores idVendedor) {
        this.idVendedor = idVendedor;
    }

    public Clientes getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Clientes idCliente) {
        this.idCliente = idCliente;
    }

    @XmlTransient
    public Collection<DetallePedidos> getDetallePedidosCollection() {
        return detallePedidosCollection;
    }

    public void setDetallePedidosCollection(Collection<DetallePedidos> detallePedidosCollection) {
        this.detallePedidosCollection = detallePedidosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPedido != null ? idPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedidos)) {
            return false;
        }
        Pedidos other = (Pedidos) object;
        if ((this.idPedido == null && other.idPedido != null) || (this.idPedido != null && !this.idPedido.equals(other.idPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gestorVentas.entity.Pedidos[ idPedido=" + idPedido + " ]";
    }
    
}
