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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Meba
 */
@Entity
@Table(name = "vendedores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendedores.findAll", query = "SELECT v FROM Vendedores v"),
    @NamedQuery(name = "Vendedores.findByCedula", query = "SELECT v FROM Vendedores v WHERE v.cedula = :cedula"),
    @NamedQuery(name = "Vendedores.findByNombre", query = "SELECT v FROM Vendedores v WHERE v.nombre = :nombre"),
    @NamedQuery(name = "Vendedores.findByApellido", query = "SELECT v FROM Vendedores v WHERE v.apellido = :apellido"),
    @NamedQuery(name = "Vendedores.findByFechaIngreso", query = "SELECT v FROM Vendedores v WHERE v.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "Vendedores.findByFechaNacimiento", query = "SELECT v FROM Vendedores v WHERE v.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Vendedores.findByTelefono", query = "SELECT v FROM Vendedores v WHERE v.telefono = :telefono"),
    @NamedQuery(name = "Vendedores.findByDireccion", query = "SELECT v FROM Vendedores v WHERE v.direccion = :direccion"),
    @NamedQuery(name = "Vendedores.findBySexo", query = "SELECT v FROM Vendedores v WHERE v.sexo = :sexo")})
public class Vendedores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cedula")
    private Integer cedula;
    @Size(max = 40)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 40)
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Size(max = 15)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 60)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 1)
    @Column(name = "sexo")
    private String sexo;
    @OneToMany(mappedBy = "idVendedor")
    private Collection<Pedidos> pedidosCollection;
    @JoinColumn(name = "id_localidad", referencedColumnName = "id_localidad")
    @ManyToOne
    private Localidad idLocalidad;
    @OneToMany(mappedBy = "cedulaVendedor")
    private Collection<Ventas> ventasCollection;
    @OneToMany(mappedBy = "idVendedor")
    private Collection<Usuarios> usuariosCollection;

    public Vendedores() {
    }

    public Vendedores(Integer cedula) {
        this.cedula = cedula;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @XmlTransient
    public Collection<Pedidos> getPedidosCollection() {
        return pedidosCollection;
    }

    public void setPedidosCollection(Collection<Pedidos> pedidosCollection) {
        this.pedidosCollection = pedidosCollection;
    }

    public Localidad getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(Localidad idLocalidad) {
        this.idLocalidad = idLocalidad;
    }

    @XmlTransient
    public Collection<Ventas> getVentasCollection() {
        return ventasCollection;
    }

    public void setVentasCollection(Collection<Ventas> ventasCollection) {
        this.ventasCollection = ventasCollection;
    }

    @XmlTransient
    public Collection<Usuarios> getUsuariosCollection() {
        return usuariosCollection;
    }

    public void setUsuariosCollection(Collection<Usuarios> usuariosCollection) {
        this.usuariosCollection = usuariosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedula != null ? cedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendedores)) {
            return false;
        }
        Vendedores other = (Vendedores) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gestorVentas.entity.Vendedores[ cedula=" + cedula + " ]";
    }
    
}
