/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
 * @author USUARIO
 */
@Entity
@Table(name = "Compra")
public class Compra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompra;
    private String nroCompra;
    private Date fecha;
    private boolean iva;
    private double subtotal;
    private double total;
    private String formaPago;
    private Long external_IDProveedor;

    @OneToMany(mappedBy = "Compra", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DetalleCompra> listaDCompra = new ArrayList<DetalleCompra>();

    public Long getExternal_IDProveedor() {
        return external_IDProveedor;
    }

    public void setExternal_IDProveedor(Long external_IDProveedor) {
        this.external_IDProveedor = external_IDProveedor;
    }

    public List<DetalleCompra> getListaDCompra() {
        return listaDCompra;
    }

    public void setListaDCompra(List<DetalleCompra> listaDCompra) {
        this.listaDCompra = listaDCompra;
    }

    public String getNroCompra() {
        return nroCompra;
    }

    public void setNroCompra(String nroCompra) {
        this.nroCompra = nroCompra;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean isIva() {
        return iva;
    }

    public void setIva(boolean iva) {
        this.iva = iva;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Long getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Long idCompra) {
        this.idCompra = idCompra;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompra != null ? idCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the idCompra fields are not set
        if (!(object instanceof Compra)) {
            return false;
        }
        Compra other = (Compra) object;
        if ((this.idCompra == null && other.idCompra != null) || (this.idCompra != null && !this.idCompra.equals(other.idCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Compra[ id=" + idCompra + " ]";
    }

}
