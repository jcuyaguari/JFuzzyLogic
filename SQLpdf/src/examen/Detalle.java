/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

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
@Table(name = "detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detalle.findAll", query = "SELECT d FROM Detalle d")
    , @NamedQuery(name = "Detalle.findByDetId", query = "SELECT d FROM Detalle d WHERE d.detId = :detId")
    , @NamedQuery(name = "Detalle.findByDetCantidad", query = "SELECT d FROM Detalle d WHERE d.detCantidad = :detCantidad")})
public class Detalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "det_id")
    private Integer detId;
    @Column(name = "det_cantidad")
    private Integer detCantidad;
    @JoinColumn(name = "ca_idfk", referencedColumnName = "ca_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Carro caIdfk;
    @JoinColumn(name = "pro_idfk", referencedColumnName = "pro_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Producto proIdfk;

    public Detalle() {
    }

    public Detalle(Integer detId) {
        this.detId = detId;
    }

    public Integer getDetId() {
        return detId;
    }

    public void setDetId(Integer detId) {
        this.detId = detId;
    }

    public Integer getDetCantidad() {
        return detCantidad;
    }

    public void setDetCantidad(Integer detCantidad) {
        this.detCantidad = detCantidad;
    }

    public Carro getCaIdfk() {
        return caIdfk;
    }

    public void setCaIdfk(Carro caIdfk) {
        this.caIdfk = caIdfk;
    }

    public Producto getProIdfk() {
        return proIdfk;
    }

    public void setProIdfk(Producto proIdfk) {
        this.proIdfk = proIdfk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detId != null ? detId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detalle)) {
            return false;
        }
        Detalle other = (Detalle) object;
        if ((this.detId == null && other.detId != null) || (this.detId != null && !this.detId.equals(other.detId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "examen.Detalle[ detId=" + detId + " ]";
    }
    
}
