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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Juan Armijos, Cristian Capa, Maria Castillo, Kelly Preciado
 */
@Entity
@Table(name = "DetalleFactura")
public class DetalleFactura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalleFactura;
    private String nombreProducto;
    private double precioUnitario;
    @OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "idFactura", nullable = false, referencedColumnName = "idFactura")
    private Factura factura;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "idProducto", nullable = false, referencedColumnName = "idProducto")
    private Producto producto;

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Long getIdDetalleFactura() {
        return idDetalleFactura;
    }

    public void setIdDetalleFactura(Long idDetalleFactura) {
        this.idDetalleFactura = idDetalleFactura;
    }

//    public int getCantidad() {
//        return cantidad;
//    }
//
//    public void setCantidad(int cantidad) {
//        this.cantidad = cantidad;
//    }
    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

//    public double getPrecioTotal() {
//        return precioTotal;
//    }
//
//    public void setPrecioTotal(double precioTotal) {
//        this.precioTotal = precioTotal;
//    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleFactura != null ? idDetalleFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the idDetalleFactura fields are not set
        if (!(object instanceof DetalleFactura)) {
            return false;
        }
        DetalleFactura other = (DetalleFactura) object;
        if ((this.idDetalleFactura == null && other.idDetalleFactura != null) || (this.idDetalleFactura != null && !this.idDetalleFactura.equals(other.idDetalleFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.DetalleFacturas[ id=" + idDetalleFactura + " ]";
    }

}
