/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author juan
 */
@Entity
@Table(name = "producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
    , @NamedQuery(name = "Producto.findByProId", query = "SELECT p FROM Producto p WHERE p.proId = :proId")
    , @NamedQuery(name = "Producto.findByProCodigo", query = "SELECT p FROM Producto p WHERE p.proCodigo = :proCodigo")
    , @NamedQuery(name = "Producto.findByProNombre", query = "SELECT p FROM Producto p WHERE p.proNombre = :proNombre")
    , @NamedQuery(name = "Producto.findByProPrecio", query = "SELECT p FROM Producto p WHERE p.proPrecio = :proPrecio")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pro_id")
    private Integer proId;
    @Column(name = "pro_codigo")
    private String proCodigo;
    @Column(name = "pro_nombre")
    private String proNombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pro_precio")
    private Double proPrecio;
    @OneToMany(mappedBy = "proIdfk", fetch = FetchType.EAGER)
    private List<Detalle> detalleList;

    public Producto() {
    }

    public Producto(Integer proId) {
        this.proId = proId;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getProCodigo() {
        return proCodigo;
    }

    public void setProCodigo(String proCodigo) {
        this.proCodigo = proCodigo;
    }

    public String getProNombre() {
        return proNombre;
    }

    public void setProNombre(String proNombre) {
        this.proNombre = proNombre;
    }

    public Double getProPrecio() {
        return proPrecio;
    }

    public void setProPrecio(Double proPrecio) {
        this.proPrecio = proPrecio;
    }

    @XmlTransient
    public List<Detalle> getDetalleList() {
        return detalleList;
    }

    public void setDetalleList(List<Detalle> detalleList) {
        this.detalleList = detalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proId != null ? proId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.proId == null && other.proId != null) || (this.proId != null && !this.proId.equals(other.proId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "examen.Producto[ proId=" + proId + " ]";
    }
    
}
