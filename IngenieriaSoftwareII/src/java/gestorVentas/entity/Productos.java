/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestorVentas.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Meba
 */
@Entity
@Table(name = "productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productos.findAll", query = "SELECT p FROM Productos p"),
    @NamedQuery(name = "Productos.findByIdProducto", query = "SELECT p FROM Productos p WHERE p.idProducto = :idProducto"),
    @NamedQuery(name = "Productos.findByNombre", query = "SELECT p FROM Productos p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Productos.findByUnidadMedida", query = "SELECT p FROM Productos p WHERE p.unidadMedida = :unidadMedida"),
    @NamedQuery(name = "Productos.findByPrecio", query = "SELECT p FROM Productos p WHERE p.precio = :precio"),
    @NamedQuery(name = "Productos.findByCosto", query = "SELECT p FROM Productos p WHERE p.costo = :costo"),
    @NamedQuery(name = "Productos.findByPorcIva", query = "SELECT p FROM Productos p WHERE p.porcIva = :porcIva"),
    @NamedQuery(name = "Productos.findByStockActual", query = "SELECT p FROM Productos p WHERE p.stockActual = :stockActual"),
    @NamedQuery(name = "Productos.findByStockMinimo", query = "SELECT p FROM Productos p WHERE p.stockMinimo = :stockMinimo")})
public class Productos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_producto")
    @GeneratedValue(generator="ProductoSeq")
    @SequenceGenerator(name="ProductoSeq",sequenceName="id_producto_seq",
    allocationSize=1)
    private Integer idProducto;
    @Size(max = 40)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 10)
    @Column(name = "unidad_medida")
    private String unidadMedida;
    @Column(name = "precio")
    private Integer precio;
    @Column(name = "costo")
    private Integer costo;
    @Column(name = "porc_iva")
    private Integer porcIva;
    @Column(name = "stock_actual")
    private Integer stockActual;
    @Column(name = "stock_minimo")
    private Integer stockMinimo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productos")
    private Collection<DetalleVentas> detalleVentasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productos")
    private Collection<DetalleCompras> detalleComprasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productos")
    private Collection<DetallePedidos> detallePedidosCollection;

    @Override
    public String toString(){
        return "Productos("+"Codigo="+ idProducto +')';
    }
    
    public Productos() {
    }
    
    public Productos(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    public Integer getPorcIva() {
        return porcIva;
    }

    public void setPorcIva(Integer porcIva) {
        this.porcIva = porcIva;
    }

    public Integer getStockActual() {
        return stockActual;
    }

    public void setStockActual(Integer stockActual) {
        this.stockActual = stockActual;
    }

    public Integer getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(Integer stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    @XmlTransient
    public Collection<DetalleVentas> getDetalleVentasCollection() {
        return detalleVentasCollection;
    }

    public void setDetalleVentasCollection(Collection<DetalleVentas> detalleVentasCollection) {
        this.detalleVentasCollection = detalleVentasCollection;
    }

    @XmlTransient
    public Collection<DetalleCompras> getDetalleComprasCollection() {
        return detalleComprasCollection;
    }

    public void setDetalleComprasCollection(Collection<DetalleCompras> detalleComprasCollection) {
        this.detalleComprasCollection = detalleComprasCollection;
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
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productos)) {
            return false;
        }
        Productos other = (Productos) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }
    
}
