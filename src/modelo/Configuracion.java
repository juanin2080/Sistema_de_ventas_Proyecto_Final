/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author USUARIO
 */
public class Configuracion {
    private Long idConfig;
    private String nombre;
    private int ruc;
    private String direccion;
    private String teléfono;
    private String lema;

    public Configuracion() {
    }

    public Configuracion(Long idConfig, String nombre, int ruc, String direccion, String teléfono, String lema) {
        this.idConfig = idConfig;
        this.nombre = nombre;
        this.ruc = ruc;
        this.direccion = direccion;
        this.teléfono = teléfono;
        this.lema = lema;
    }

    public Long getIdConfig() {
        return idConfig;
    }

    public void setIdConfig(Long idConfig) {
        this.idConfig = idConfig;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRuc() {
        return ruc;
    }

    public void setRuc(int ruc) {
        this.ruc = ruc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTeléfono() {
        return teléfono;
    }

    public void setTeléfono(String teléfono) {
        this.teléfono = teléfono;
    }

    public String getLema() {
        return lema;
    }

    public void setLema(String lema) {
        this.lema = lema;
    }

}
