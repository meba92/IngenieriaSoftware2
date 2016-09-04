/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestorVentas.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Meba
 */
@Entity
@Table(name = "proveedores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proveedores.findAll", query = "SELECT p FROM Proveedores p"),
    @NamedQuery(name = "Proveedores.findByIdProveedor", query = "SELECT p FROM Proveedores p WHERE p.idProveedor = :idProveedor"),
    @NamedQuery(name = "Proveedores.findByNombre", query = "SELECT p FROM Proveedores p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Proveedores.findByDireccion", query = "SELECT p FROM Proveedores p WHERE p.direccion = :direccion"),
    @NamedQuery(name = "Proveedores.findByRuc", query = "SELECT p FROM Proveedores p WHERE p.ruc = :ruc"),
    @NamedQuery(name = "Proveedores.findByTelefono", query = "SELECT p FROM Proveedores p WHERE p.telefono = :telefono"),
    @NamedQuery(name = "Proveedores.findByEmail", query = "SELECT p FROM Proveedores p WHERE p.email = :email")})
public class Proveedores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_proveedor")
    @GeneratedValue(generator="ProveedorSeq")
    @SequenceGenerator(name="ProvedorSeq",sequenceName="id_proveedor_seq",
    allocationSize=1)
    private Integer idProveedor;
    @Size(max = 40)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 200)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 12)
    @Column(name = "ruc")
    private String ruc;
    @Size(max = 15)
    @Column(name = "telefono")
    private String telefono;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 40)
    @Column(name = "email")
    private String email;
    @JoinColumn(name = "id_localidad", referencedColumnName = "id_localidad")
    @ManyToOne
    private Localidad idLocalidad;

    public Proveedores() {
    }

    public Proveedores(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Localidad getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(Localidad idLocalidad) {
        this.idLocalidad = idLocalidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProveedor != null ? idProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedores)) {
            return false;
        }
        Proveedores other = (Proveedores) object;
        if ((this.idProveedor == null && other.idProveedor != null) || (this.idProveedor != null && !this.idProveedor.equals(other.idProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gestorVentas.entity.Proveedores[ idProveedor=" + idProveedor + " ]";
    }
    
}
