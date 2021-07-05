 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author María Castillo
 */
@Entity
@Table (name="venta")
public class Venta implements Serializable {

      private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Codigo;
    @Column (length = 10,unique = true)
    private Long CedulaCliente;
    private String nombreVendedor;
    private Date fecha;
   // private String formaPago;
//    @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.LAZY)
//    @JoinColumn(name = "idPersona",nullable = false,referencedColumnName = "idPersona")
//    private Persona persona;
    @OneToOne(cascade = CascadeType.REFRESH,fetch = FetchType.LAZY)
    @JoinColumn(name = "CodigoFactura",nullable = false,referencedColumnName = "CodigoFactura")
    private DetalleVentas detalleVenta;
//forma pago


//    @OneToOne(cascade = CascadeType.REFRESH,fetch = FetchType.LAZY)
//    @JoinColumn(name = "idFormaPago",nullable = false,referencedColumnName = "idFormaPago")
//    private FormaPago fPago;
//
//    public FormaPago getfPago() {
//        return fPago;
//    }
//
//    public void setfPago(FormaPago fPago) {
//        this.fPago = fPago;
//    }
    
        
//    }
  
//////

//////////////////////////////
    public DetalleVentas getDetalleVentas() {
        return detalleVenta;
    }

    public void setDetalleVentas(DetalleVentas detalleVenta) {
        this.detalleVenta = detalleVenta;
    }
//    
//    public Persona getPersona() {
//        return persona;
//    }
//
//    public void setPersona(Persona persona) {
//        this.persona = persona;
//    }
//    
    
    public Long getCodigo() {
        return Codigo;
    }

    public void setCodigo(Long Codigo) {
        this.Codigo = Codigo;
    }

    public Long getCedulaCliente() {
        return CedulaCliente;
    }

    public void setCedulaCliente(Long CedulaCliente) {
        this.CedulaCliente = CedulaCliente;
    }

    public String getNombreVendedor() {
        return nombreVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

//    public String getFormaPago() {
//        return formaPago;
//    }
//
//    public void setFormaPago(String formaPago) {
//        this.formaPago = formaPago;
//    }
    
    public Long getId() {
        return Codigo;
    }

    public void setId(Long id) {
        this.Codigo = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (Codigo != null ? Codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the Codigo fields are not set
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.Codigo == null && other.Codigo != null) || (this.Codigo != null && !this.Codigo.equals(other.Codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Venta1[ id=" + Codigo + " ]";
    }

    public Venta() {
    }
    
    
}
