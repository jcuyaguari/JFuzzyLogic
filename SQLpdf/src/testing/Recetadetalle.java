/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

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
@Table(name = "recetadetalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recetadetalle.findAll", query = "SELECT r FROM Recetadetalle r")
    , @NamedQuery(name = "Recetadetalle.findById", query = "SELECT r FROM Recetadetalle r WHERE r.id = :id")
    , @NamedQuery(name = "Recetadetalle.findByCantidad", query = "SELECT r FROM Recetadetalle r WHERE r.cantidad = :cantidad")
    , @NamedQuery(name = "Recetadetalle.findByPrecio", query = "SELECT r FROM Recetadetalle r WHERE r.precio = :precio")})
public class Recetadetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private double cantidad;
    @Basic(optional = false)
    @Column(name = "precio")
    private double precio;
    @JoinColumn(name = "id_receta", referencedColumnName = "id_receta")
    @ManyToOne(fetch = FetchType.EAGER)
    private Receta idReceta;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    @ManyToOne(fetch = FetchType.EAGER)
    private Productos idProducto;

    public Recetadetalle() {
    }

    public Recetadetalle(Integer id) {
        this.id = id;
    }

    public Recetadetalle(Integer id, double cantidad, double precio) {
        this.id = id;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Receta getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(Receta idReceta) {
        this.idReceta = idReceta;
    }

    public Productos getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Productos idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recetadetalle)) {
            return false;
        }
        Recetadetalle other = (Recetadetalle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "testing.Recetadetalle[ id=" + id + " ]";
    }
    
}
