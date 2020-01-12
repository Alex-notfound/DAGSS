/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uvigo.esei.dagss.facturaaas.controladores.usuario;

import es.uvigo.esei.dagss.facturaaas.controladores.AutenticacionController;
import es.uvigo.esei.dagss.facturaaas.daos.FacturaDAO;
import es.uvigo.esei.dagss.facturaaas.daos.LineaFacturaDAO;
import es.uvigo.esei.dagss.facturaaas.entidades.Cliente;
import es.uvigo.esei.dagss.facturaaas.entidades.EstadoFactura;
import es.uvigo.esei.dagss.facturaaas.entidades.Factura;
import es.uvigo.esei.dagss.facturaaas.entidades.LineaFactura;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "facturasController")
@ViewScoped
public class FacturasController implements Serializable {
    private List<Factura> facturas;
    private Factura facturaActual;
    private LineaFactura lineaFacturaActual;
    private List<LineaFactura> lineasFactura;
    private boolean esNuevo;
    private List<Cliente> clientesFacturas;
    private Cliente clienteFiltrado;
    
    @Inject
    private FacturaDAO daoFactura;
    
    @Inject
    private LineaFacturaDAO daoLineaFactura;
    
    @Inject
    private AutenticacionController authController;
    
    public List<Factura> getFacturas(){
        return facturas;
    }
    
    public void setFactura(List<Factura> facturas){
        this.facturas = facturas;
    }

    public Factura getFacturaActual() {
        return facturaActual;
    }

    public void setFacturaActual(Factura facturaActual) {
        this.facturaActual = facturaActual;
    }

    public LineaFactura getLineaFacturaActual() {
        return lineaFacturaActual;
    }

    public void setLineaFacturaActual(LineaFactura lineaFacturaActual) {
        this.lineaFacturaActual = lineaFacturaActual;
    }

    public List<LineaFactura> getLineasFactura() {
        return lineasFactura;
    }

    public void setLineasFactura(List<LineaFactura> lineasFactura) {
        this.lineasFactura = lineasFactura;
    }
    
    public boolean isEsNuevo() {
        return esNuevo;
    }

    public void setEsNuevo(boolean esNuevo) {
        this.esNuevo = esNuevo;
    }

    public List<Cliente> getClientesFacturas() {
        return clientesFacturas;
    }

    public void setClientesFacturas(List<Cliente> clienteFiltrado) {
        this.clientesFacturas = clienteFiltrado;
    }
    
    public Cliente getClienteFiltrado() {
        return clienteFiltrado;
    }

    public void setClienteFiltrado(Cliente clienteFiltrado) {
        this.clienteFiltrado = clienteFiltrado;
    }
    
    public EstadoFactura[] getEstadosFactura(){
        return EstadoFactura.values();
    }
    
    @PostConstruct
    public void cargaInicial(){
        this.facturas = refrescarListaFacturas();
        this.clientesFacturas = obtenerClientes();
        this.facturaActual = null;
        this.lineaFacturaActual = null;
        this.lineasFactura = null;
        this.esNuevo = false;
    }
    
    public void doBuscarPorCliente(){
        this.facturas = daoFactura.buscarPorCliente(clienteFiltrado);
    }
    
    public void doNuevo(){
        this.esNuevo = true;
        this.facturaActual = new Factura();
        this.lineaFacturaActual = new LineaFactura();
        this.facturaActual.setUsuario(authController.getUsuarioLogueado());
        this.lineasFactura = refrescarListaLineasFacturas();
    }
    
    public void doEditar(Factura factura){
        this.esNuevo = false;
        this.facturaActual = factura;
        this.lineaFacturaActual = new LineaFactura();
        this.lineasFactura = refrescarListaLineasFacturas();
    }
    
    public void doGuardarLineaVenta(){
        this.daoLineaFactura.crear(lineaFacturaActual);
        //this.lineaFacturaActual = new LineaFactura();
    }
    
    public void doEditarLineaVenta(LineaFactura linea){
        this.lineaFacturaActual = linea;
    }
    
    public void doGuardarEditado(){
        if(this.esNuevo){
            daoFactura.crear(facturaActual);
        }else{
            daoFactura.actualizar(facturaActual);
        }
        
        this.facturas = refrescarListaFacturas();
        //this.clientesFacturas = obtenerClientes();
        this.facturaActual = null;
        this.lineaFacturaActual = null;
        this.esNuevo = false;
    }
    
    public void doCancelarEditado(){
        this.facturaActual = null;
        this.lineaFacturaActual = null;
        this.esNuevo = false;
    }

    private List<Factura> refrescarListaFacturas() {
        return daoFactura.buscarPorUsuario(authController.getUsuarioLogueado());
    }
    
    private List<LineaFactura> refrescarListaLineasFacturas() {
        return daoLineaFactura.buscarPorFactura(this.facturaActual);
    }

    private List<Cliente> obtenerClientes(){
        List<Cliente> listaClientes = new ArrayList<>();
        for(Factura f : this.facturas){
            if(!listaClientes.contains(f.getCliente())){
                listaClientes.add(f.getCliente());
            }
        }
        
        return listaClientes;
    }
    
}
