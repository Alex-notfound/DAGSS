/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uvigo.esei.dagss.facturaaas.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PAGO")
public class Pago implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "USUARIO_ID")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "FACTURA_NUM_FACTURA")
    private Factura factura;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "CLIENTE_NIF")
    private Cliente cliente;

    @Enumerated(EnumType.STRING)
    private EstadoPago estado;

    private double importe;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    public Pago() {
    }

    public Pago(int id, Usuario usuario, Factura factura, String nombre, Cliente cliente, EstadoPago estado, Long importe, Date fecha) {
        this.id = id;
        this.usuario = usuario;
        this.factura = factura;
        this.nombre = nombre;
        this.cliente = cliente;
        this.estado = estado;
        this.importe = importe;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public Factura getFactura() {
        return factura;
    }

    public String getNombre() {
        return nombre;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public EstadoPago getEstado() {
        return estado;
    }

    public double getImporte() {
        return importe;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setEstado(EstadoPago estado) {
        this.estado = estado;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
