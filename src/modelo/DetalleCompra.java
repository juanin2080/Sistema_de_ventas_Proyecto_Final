/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "DetalleCompra")
public class DetalleCompra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDCompra;
    private int cantidad;
    private double precioUnitario;
    private double precioTotal;

    @OneToMany(mappedBy = "DetalleCompra", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Producto> listaProducto = new ArrayList<Producto>();

    public List<Producto> getListaProducto() {
        return listaProducto;
    }

    public void setListaProducto(List<Producto> listaProducto) {
        this.listaProducto = listaProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Long getIdDCompra() {
        return idDCompra;
    }

    public void setIdDCompra(Long idDCompra) {
        this.idDCompra = idDCompra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDCompra != null ? idDCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the idDCompra fields are not set
        if (!(object instanceof DetalleCompra)) {
            return false;
        }
        DetalleCompra other = (DetalleCompra) object;
        if ((this.idDCompra == null && other.idDCompra != null) || (this.idDCompra != null && !this.idDCompra.equals(other.idDCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.DetalleCompra[ id=" + idDCompra + " ]";
    }

}
