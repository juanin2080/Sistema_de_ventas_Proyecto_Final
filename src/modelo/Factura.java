/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author María Castillo
 */
@Entity
@Table(name = "factura")
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long CodigoFactura;
    @Column(length = 10, unique = true)
    private Long CodigoProducto;
    private int Cantidad;
    private double iva;
    private double precio;
    @OneToOne(mappedBy = "factura", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Venta venta;

    public Long getCodigoFactura() {
        return CodigoFactura;
    }

    public void setCodigoFactura(Long CodigoFactura) {
        this.CodigoFactura = CodigoFactura;
    }

    public Long getCodigoProducto() {
        return CodigoProducto;
    }

    public void setCodigoProducto(Long CodigoProducto) {
        this.CodigoProducto = CodigoProducto;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (CodigoFactura != null ? CodigoFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the CodigoFactura fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.CodigoFactura == null && other.CodigoFactura != null) || (this.CodigoFactura != null && !this.CodigoFactura.equals(other.CodigoFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Detalle_Venta[ id=" + CodigoFactura + " ]";
    }

    public Factura() {
    }

}
