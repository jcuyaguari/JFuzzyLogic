/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miprac;

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
@Table(name = "p1proveedores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "P1proveedores.findAll", query = "SELECT p FROM P1proveedores p")
    , @NamedQuery(name = "P1proveedores.findByProvId", query = "SELECT p FROM P1proveedores p WHERE p.provId = :provId")
    , @NamedQuery(name = "P1proveedores.findByProvNombre", query = "SELECT p FROM P1proveedores p WHERE p.provNombre = :provNombre")})
public class P1proveedores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "prov_id")
    private Integer provId;
    @Column(name = "prov_nombre")
    private String provNombre;
    @OneToMany(mappedBy = "provId", fetch = FetchType.EAGER)
    private List<P1producto> p1productoList;

    public P1proveedores() {
    }

    public P1proveedores(Integer provId) {
        this.provId = provId;
    }

    public Integer getProvId() {
        return provId;
    }

    public void setProvId(Integer provId) {
        this.provId = provId;
    }

    public String getProvNombre() {
        return provNombre;
    }

    public void setProvNombre(String provNombre) {
        this.provNombre = provNombre;
    }

    @XmlTransient
    public List<P1producto> getP1productoList() {
        return p1productoList;
    }

    public void setP1productoList(List<P1producto> p1productoList) {
        this.p1productoList = p1productoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (provId != null ? provId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof P1proveedores)) {
            return false;
        }
        P1proveedores other = (P1proveedores) object;
        if ((this.provId == null && other.provId != null) || (this.provId != null && !this.provId.equals(other.provId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "miprac.P1proveedores[ provId=" + provId + " ]";
    }
    
}
