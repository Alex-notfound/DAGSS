/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uvigo.esei.dagss.facturaaas.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
    número de línea (generado por el sistema, no editable)
    concepto
    cantidad (por defecto 1)
    precio unitario
    procentaje de descuento
    tipo de IVA (inicializado con el tipo de IVA por defecto del usuario actual, seleccionable de una lista desplegable)
    importe total (calculado, no editable)
 */
@Entity
@Table(name = "LINEA_FACTURA")
public class LineaFactura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numLinea;
    private String concepto;
    private int cantidad;
    private Long precio;
    private Long descuento;

    @ManyToOne
    private TipoIVA tipoIva;

    @ManyToOne
    @JoinColumn(name = "FACTURA_NUMFACTURA")
    private Factura factura;

//    private Long total;
    public LineaFactura() {
        this.cantidad = 1;
    }

    public LineaFactura(Long numLinea, String concepto, int cantidad, Long precio, Long descuento, TipoIVA tipoIva, Factura factura) {
        this.numLinea = numLinea;
        this.concepto = concepto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descuento = descuento;
        this.tipoIva = tipoIva;
        this.factura = factura;
    }

    public Long getNumLinea() {
        return numLinea;
    }

    public void setNumLinea(Long numLinea) {
        this.numLinea = numLinea;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public Long getDescuento() {
        return descuento;
    }

    public void setDescuento(Long descuento) {
        this.descuento = descuento;
    }

    public TipoIVA getIva() {
        return tipoIva;
    }

    public void setIva(TipoIVA tipoIva) {
        this.tipoIva = tipoIva;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }
    
    public long getTotal(){
        return 0;
    }

}
