/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uvigo.esei.dagss.facturaaas.entidades;

import java.util.Date;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author spire
 */
public class Pago {
    
    @ManyToOne
    @JoinColumn(name = "NUM_FACTURA")
    private int numFactura;
    
    
    private String nombre;
    
    @ManyToOne
    @JoinColumn(name = "NIF_CLIENTE_ID")
    private Cliente cliente;
    
    private EstadoPago estado;
    
    private Long importe;
    
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
}
