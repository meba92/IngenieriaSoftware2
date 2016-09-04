/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestorVentas.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "localidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Localidad.findAll", query = "SELECT l FROM Localidad l"),
    @NamedQuery(name = "Localidad.findByIdLocalidad", query = "SELECT l FROM Localidad l WHERE l.idLocalidad = :idLocalidad"),
    @NamedQuery(name = "Localidad.findByNombre", query = "SELECT l FROM Localidad l WHERE l.nombre = :nombre"),
    @NamedQuery(name = "Localidad.findByDepartamento", query = "SELECT l FROM Localidad l WHERE l.departamento = :departamento"),
    @NamedQuery(name = "Localidad.findByLatitud", query = "SELECT l FROM Localidad l WHERE l.latitud = :latitud"),
    @NamedQuery(name = "Localidad.findByAltitud", query = "SELECT l FROM Localidad l WHERE l.altitud = :altitud")})
public class Localidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_localidad")
    @GeneratedValue(generator="LocalidadSeq")
    @SequenceGenerator(name="LocalidadSeq",sequenceName="id_localidad_seq",
    allocationSize=1)
    private Integer idLocalidad;
    @Size(max = 40)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 60)
    @Column(name = "departamento")
    private String departamento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "latitud")
    private Double latitud;
    @Column(name = "altitud")
    private Double altitud;
    @OneToMany(mappedBy = "idLocalidad")
    private Collection<Clientes> clientesCollection;
    @OneToMany(mappedBy = "idLocalidad")
    private Collection<Vendedores> vendedoresCollection;
    @OneToMany(mappedBy = "idLocalidad")
    private Collection<Proveedores> proveedoresCollection;

    public Localidad() {
    }

    public Localidad(Integer idLocalidad) {
        this.idLocalidad = idLocalidad;
    }

    public Integer getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(Integer idLocalidad) {
        this.idLocalidad = idLocalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getAltitud() {
        return altitud;
    }

    public void setAltitud(Double altitud) {
        this.altitud = altitud;
    }

    @XmlTransient
    public Collection<Clientes> getClientesCollection() {
        return clientesCollection;
    }

    public void setClientesCollection(Collection<Clientes> clientesCollection) {
        this.clientesCollection = clientesCollection;
    }

    @XmlTransient
    public Collection<Vendedores> getVendedoresCollection() {
        return vendedoresCollection;
    }

    public void setVendedoresCollection(Collection<Vendedores> vendedoresCollection) {
        this.vendedoresCollection = vendedoresCollection;
    }

    @XmlTransient
    public Collection<Proveedores> getProveedoresCollection() {
        return proveedoresCollection;
    }

    public void setProveedoresCollection(Collection<Proveedores> proveedoresCollection) {
        this.proveedoresCollection = proveedoresCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLocalidad != null ? idLocalidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Localidad)) {
            return false;
        }
        Localidad other = (Localidad) object;
        if ((this.idLocalidad == null && other.idLocalidad != null) || (this.idLocalidad != null && !this.idLocalidad.equals(other.idLocalidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gestorVentas.entity.Localidad[ idLocalidad=" + idLocalidad + " ]";
    }
    
}
