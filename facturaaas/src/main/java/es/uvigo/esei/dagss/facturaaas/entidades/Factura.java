/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uvigo.esei.dagss.facturaaas.entidades;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author spire
 */

@Entity
@Table(name = "FACTURA")
public class Factura implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numFactura;
    
    @ManyToOne
    @JoinColumn(name="NIF_CLIENTE_ID")
    private Cliente cliente;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEmision;
    
    @OneToMany(mappedBy="factura", cascade=CascadeType.ALL)
    private Collection<LineaFactura> lineasFactura;
    
    @OneToMany(mappedBy="factura", cascade=CascadeType.ALL)
    private Collection<Pago> pago;

    @OneToOne
    private FormaPago formaPago;
    
    @Enumerated(EnumType.STRING)
    private EstadoFactura estado;
    
    private String ejercicio; //Ejercicio es un String?
    
    private String comentarios;

    public Factura(int numFactura, Cliente cliente, Date fechaEmision, Collection<LineaFactura> lineasFactura, Collection<Pago> pago, FormaPago formaPago, EstadoFactura estado, String ejercicio, String comentarios) {
        this.numFactura = numFactura;
        this.cliente = cliente;
        this.fechaEmision = fechaEmision;
        this.lineasFactura = lineasFactura;
        this.pago = pago;
        this.formaPago = formaPago;
        this.estado = estado;
        this.ejercicio = ejercicio;
        this.comentarios = comentarios;
    }

    public int getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(int numFactura) {
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
