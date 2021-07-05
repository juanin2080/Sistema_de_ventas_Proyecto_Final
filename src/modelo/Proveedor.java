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
@Table(name = "proveedor")
public class Proveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_Proveedor;
    
    private int ruc;
    private String empresa;
    
    @OneToMany (mappedBy = "proveedor",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List <Producto>listaProductos = new ArrayList<Producto>();

    public int getRuc() {
        return ruc;
    }

    public void setRuc(int ruc) {
        this.ruc = ruc;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    
    
    
    public Long getId_Proveedor() {
        return id_Proveedor;
    }

    public void setId_Proveedor(Long id_Proveedor) {
        this.id_Proveedor = id_Proveedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_Proveedor != null ? id_Proveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id_Proveedor fields are not set
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
        if ((this.id_Proveedor == null && other.id_Proveedor != null) || (this.id_Proveedor != null && !this.id_Proveedor.equals(other.id_Proveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Proveedor[ id=" + id_Proveedor + " ]";
    }
    
}
