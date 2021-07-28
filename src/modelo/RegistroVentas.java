/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "registroVentas")
public class RegistroVentas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRVentas;
    private String valor;
    private Date fecha;
    private String cliente;
    @OneToOne(mappedBy = "registroVentas", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Venta venta;
    
    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    
    public Long getIdRVentas() {
        return idRVentas;
    }

    public void setIdRVentas(Long idRVentas) {
        this.idRVentas = idRVentas;
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
        hash += (idRVentas != null ? idRVentas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the idRVentas fields are not set
        if (!(object instanceof RegistroVentas)) {
            return false;
        }
        RegistroVentas other = (RegistroVentas) object;
        if ((this.idRVentas == null && other.idRVentas != null) || (this.idRVentas != null && !this.idRVentas.equals(other.idRVentas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.RegistroVentas[ id=" + idRVentas + " ]";
    }
    
}
