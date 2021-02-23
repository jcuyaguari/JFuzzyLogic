/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miprac;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juan
 */
@Entity
@Table(name = "p1producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "P1producto.findAll", query = "SELECT p FROM P1producto p")
    , @NamedQuery(name = "P1producto.findByProId", query = "SELECT p FROM P1producto p WHERE p.proId = :proId")
    , @NamedQuery(name = "P1producto.findByProNombre", query = "SELECT p FROM P1producto p WHERE p.proNombre = :proNombre")
    , @NamedQuery(name = "P1producto.findByProStock", query = "SELECT p FROM P1producto p WHERE p.proStock = :proStock")})
public class P1producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pro_id")
    private Integer proId;
    @Column(name = "pro_nombre")
    private String proNombre;
    @Column(name = "pro_stock")
    private Integer proStock;
    @JoinColumn(name = "prov_id", referencedColumnName = "prov_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private P1proveedores provId;

    public P1producto() {
    }

    public P1producto(Integer proId) {
        this.proId = proId;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getProNombre() {
        return proNombre;
    }

    public void setProNombre(String proNombre) {
        this.proNombre = proNombre;
    }

    public Integer getProStock() {
        return proStock;
    }

    public void setProStock(Integer proStock) {
        this.proStock = proStock;
    }

    public P1proveedores getProvId() {
        return provId;
    }

    public void setProvId(P1proveedores provId) {
        this.provId = provId;
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
        if (!(object instanceof P1producto)) {
            return false;
        }
        P1producto other = (P1producto) object;
        if ((this.proId == null && other.proId != null) || (this.proId != null && !this.proId.equals(other.proId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "miprac.P1producto[ proId=" + proId + " ]";
    }
    
}
