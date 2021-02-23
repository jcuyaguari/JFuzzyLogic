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
@Table(name = "carro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carro.findAll", query = "SELECT c FROM Carro c")
    , @NamedQuery(name = "Carro.findByCaId", query = "SELECT c FROM Carro c WHERE c.caId = :caId")
    , @NamedQuery(name = "Carro.findByCaCodigo", query = "SELECT c FROM Carro c WHERE c.caCodigo = :caCodigo")
    , @NamedQuery(name = "Carro.findByCaNumero", query = "SELECT c FROM Carro c WHERE c.caNumero = :caNumero")
    , @NamedQuery(name = "Carro.findByCaFecha", query = "SELECT c FROM Carro c WHERE c.caFecha = :caFecha")
    , @NamedQuery(name = "Carro.findByCaTotal", query = "SELECT c FROM Carro c WHERE c.caTotal = :caTotal")})
public class Carro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ca_id")
    private Integer caId;
    @Column(name = "ca_codigo")
    private String caCodigo;
    @Column(name = "ca_numero")
    private Integer caNumero;
    @Column(name = "ca_fecha")
    private String caFecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ca_total")
    private Double caTotal;
    @OneToMany(mappedBy = "caIdfk", fetch = FetchType.EAGER)
    private List<Detalle> detalleList;

    public Carro() {
    }

    public Carro(Integer caId) {
        this.caId = caId;
    }

    public Integer getCaId() {
        return caId;
    }

    public void setCaId(Integer caId) {
        this.caId = caId;
    }

    public String getCaCodigo() {
        return caCodigo;
    }

    public void setCaCodigo(String caCodigo) {
        this.caCodigo = caCodigo;
    }

    public Integer getCaNumero() {
        return caNumero;
    }

    public void setCaNumero(Integer caNumero) {
        this.caNumero = caNumero;
    }

    public String getCaFecha() {
        return caFecha;
    }

    public void setCaFecha(String caFecha) {
        this.caFecha = caFecha;
    }

    public Double getCaTotal() {
        return caTotal;
    }

    public void setCaTotal(Double caTotal) {
        this.caTotal = caTotal;
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
        hash += (caId != null ? caId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carro)) {
            return false;
        }
        Carro other = (Carro) object;
        if ((this.caId == null && other.caId != null) || (this.caId != null && !this.caId.equals(other.caId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "examen.Carro[ caId=" + caId + " ]";
    }
    
}
