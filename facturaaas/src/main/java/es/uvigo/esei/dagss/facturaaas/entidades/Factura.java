/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uvigo.esei.dagss.facturaaas.entidades;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "FACTURA")
public class Factura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numFactura;

    private String ejercicio; //Ejercicio es un String?

    @ManyToOne
    @JoinColumn(name = "USUARIO_ID")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "CLIENTE_ID")
    private Cliente cliente;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEmision;

    @ManyToOne
    private FormaPago formaPago;

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL)
    private Collection<LineaFactura> lineasFactura;

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL)
    private Collection<Pago> pago;

    @Enumerated(EnumType.STRING)
    private EstadoFactura estado;

    private String comentarios;

    public Factura() {
        this.fechaEmision = Calendar.getInstance().getTime();
    }

    public Factura(Long numFactura, String ejercicio, Usuario usuario, Cliente cliente, Date fechaEmision, FormaPago formaPago, Collection<LineaFactura> lineasFactura, Collection<Pago> pago, EstadoFactura estado, String comentarios) {
        this.numFactura = numFactura;
        this.ejercicio = ejercicio;
        this.usuario = usuario;
        this.cliente = cliente;
        this.fechaEmision = fechaEmision;
        this.formaPago = formaPago;
        this.lineasFactura = lineasFactura;
        this.pago = pago;
        this.estado = estado;
        this.comentarios = comentarios;
    }

    public Long getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(Long numFactura) {
        this.numFactura = numFactura;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Collection<LineaFactura> getLineasFactura() {
        return lineasFactura;
    }

    public void setLineasFactura(Collection<LineaFactura> lineasFactura) {
        this.lineasFactura = lineasFactura;
    }

    public Collection<Pago> getPago() {
        return pago;
    }

    public void setPago(Collection<Pago> pago) {
        this.pago = pago;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public EstadoFactura getEstado() {
        return estado;
    }

    public void setEstado(EstadoFactura estado) {
        this.estado = estado;
    }

    public String getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(String ejercicio) {
        this.ejercicio = ejercicio;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

}
