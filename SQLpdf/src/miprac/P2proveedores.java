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
@Table(name = "p2proveedores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "P2proveedores.findAll", query = "SELECT p FROM P2proveedores p")
    , @NamedQuery(name = "P2proveedores.findByProvId", query = "SELECT p FROM P2proveedores p WHERE p.provId = :provId")
    , @NamedQuery(name = "P2proveedores.findByProvNombre", query = "SELECT p FROM P2proveedores p WHERE p.provNombre = :provNombre")})
public class P2proveedores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "prov_id")
    private Integer provId;
    @Column(name = "prov_nombre")
    private String provNombre;
    @OneToMany(mappedBy = "provId", fetch = FetchType.EAGER)
    private List<P2producto> p2productoList;

    public P2proveedores() {
    }

    public P2proveedores(Integer provId) {
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
    public List<P2producto> getP2productoList() {
        return p2productoList;
    }

    public void setP2productoList(List<P2producto> p2productoList) {
        this.p2productoList = p2productoList;
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
        if (!(object instanceof P2proveedores)) {
            return false;
        }
        P2proveedores other = (P2proveedores) object;
        if ((this.provId == null && other.provId != null) || (this.provId != null && !this.provId.equals(other.provId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "miprac.P2proveedores[ provId=" + provId + " ]";
    }
    
}
