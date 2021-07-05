/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author María Castillo
 */
@Entity
@Table (name="formaPagos")
public class FormaPago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private Long idFormaPago;
    @GeneratedValue(strategy = GenerationType.AUTO)
    private double valor;
    private double tipo;
///////////////////

//    
    
//    @OneToOne(mappedBy= "formaPagos", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    private Venta ventas;
//
//    public Venta getVentas() {
//        return ventas;
//    }
//
//    public void setVentas(Venta ventas) {
//        this.ventas = ventas;
//    }
//    



   
    
//////////////    
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getTipo() {
        return tipo;
    }

    public void setTipo(double tipo) {
        this.tipo = tipo;
    }



    public Long getIdFormaPago() {
        return idFormaPago;
    }

    public void setIdFormaPago(Long idFormaPago) {
        this.idFormaPago = idFormaPago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFormaPago != null ? idFormaPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the idFormaPago fields are not set
        if (!(object instanceof FormaPago)) {
            return false;
        }
        FormaPago other = (FormaPago) object;
        if ((this.idFormaPago == null && other.idFormaPago != null) || (this.idFormaPago != null && !this.idFormaPago.equals(other.idFormaPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.FormaPago[ id=" + idFormaPago + " ]";
    }
    
}
