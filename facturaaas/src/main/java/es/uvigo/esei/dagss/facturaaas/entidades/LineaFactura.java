/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uvigo.esei.dagss.facturaaas.entidades;

import java.util.Collection;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author spire
 */

/*
    número de línea (generado por el sistema, no editable)
    concepto
    cantidad (por defecto 1)
    precio unitario
    procentaje de descuento
    tipo de IVA (inicializado con el tipo de IVA por defecto del usuario actual, seleccionable de una lista desplegable)
    importe total (calculado, no editable)
*/
public class LineaFactura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numLinea;
    
    private String concepto;
    
    private int cantidad;
    
    private Long precio;
    
    private Long descuento;
    
    @OneToMany
    private Collection<TipoIVA> iva;
    
    @JoinColumn(name = "NUM_FACTURA")
    private Factura factura;
    
//    private Long total;

    public LineaFactura(int numLinea, String concepto, int cantidad, Long precio, Long descuento, Collection<TipoIVA> iva, Factura factura) {
        this.numLinea = numLinea;
        this.concepto = concepto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descuento = descuento;
        this.iva = iva;
        this.factura = factura;
    }

    public int getNumLinea() {
        return numLinea;
    }

    public void setNumLinea(int numLinea) {
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

    public Collection<TipoIVA> getIva() {
        return iva;
    }

    public void setIva(Collection<TipoIVA> iva) {
        this.iva = iva;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }
    
    

}
