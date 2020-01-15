/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uvigo.esei.dagss.facturaaas.controladores.usuario;

import es.uvigo.esei.dagss.facturaaas.controladores.AutenticacionController;
import es.uvigo.esei.dagss.facturaaas.daos.DatosFacturacionDAO;
import es.uvigo.esei.dagss.facturaaas.daos.FacturaDAO;
import es.uvigo.esei.dagss.facturaaas.daos.FormaPagoDAO;
import es.uvigo.esei.dagss.facturaaas.daos.LineaFacturaDAO;
import es.uvigo.esei.dagss.facturaaas.daos.PagoDAO;
import es.uvigo.esei.dagss.facturaaas.daos.TipoIVADAO;
import es.uvigo.esei.dagss.facturaaas.entidades.Cliente;
import es.uvigo.esei.dagss.facturaaas.entidades.DatosFacturacion;
import es.uvigo.esei.dagss.facturaaas.entidades.EstadoFactura;
import es.uvigo.esei.dagss.facturaaas.entidades.EstadoPago;
import es.uvigo.esei.dagss.facturaaas.entidades.Factura;
import es.uvigo.esei.dagss.facturaaas.entidades.FormaPago;
import es.uvigo.esei.dagss.facturaaas.entidades.LineaFactura;
import es.uvigo.esei.dagss.facturaaas.entidades.Pago;
import es.uvigo.esei.dagss.facturaaas.entidades.TipoIVA;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "facturasController")
@ViewScoped
public class FacturasController implements Serializable {

    private List<Factura> facturas;
    private Factura facturaActual;
    private LineaFactura lineaFacturaActual;
    private List<LineaFactura> lineasEliminadas;
    private boolean esNuevo;
    private List<Cliente> clientesFacturas;
    private Cliente clienteFiltrado;
    private DatosFacturacion datosFacturacionUsuario;

    @Inject
    private FacturaDAO daoFactura;

    @Inject
    private LineaFacturaDAO daoLineaFactura;

    @Inject
    private PagoDAO daoPago;

    @Inject
    private DatosFacturacionDAO daoDatosFacturacion;

    @Inject
    private AutenticacionController authController;

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFactura(List<Factura> facturas) {
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

    public EstadoFactura[] getEstadosFactura() {
        return EstadoFactura.values();
    }

    @PostConstruct
    public void cargaInicial() {
        this.facturas = refrescarListaFacturas();
        this.clientesFacturas = obtenerClientes();
        this.facturaActual = null;
        this.esNuevo = false;
        this.lineasEliminadas = new ArrayList<>();

        this.datosFacturacionUsuario = daoDatosFacturacion.buscarConPropietario(authController.getUsuarioLogueado());
    }

    public void doBuscarPorCliente() {
        if (this.clienteFiltrado != null) {
            this.facturas = daoFactura.buscarPorCliente(clienteFiltrado, authController.getUsuarioLogueado());
        } else {
            this.facturas = this.refrescarListaFacturas();
        }
    }

    public void doNuevo() {
        this.esNuevo = true;
        this.facturaActual = new Factura();
        this.lineaFacturaActual = new LineaFactura();
        
        if (datosFacturacionUsuario != null) {
            if (datosFacturacionUsuario.getFormaPagoPorDefecto() != null) {
                this.facturaActual.setFormaPago(datosFacturacionUsuario.getFormaPagoPorDefecto());
            }
            if (datosFacturacionUsuario.getTipoIVAPorDefecto() != null) {
                this.lineaFacturaActual.setIva(datosFacturacionUsuario.getTipoIVAPorDefecto());
            }
        }

        this.facturaActual.setUsuario(authController.getUsuarioLogueado());
        this.facturaActual.setLineasFactura(refrescarListaLineasFacturas());
    }

    public void doEditar(Factura factura) {
        this.esNuevo = false;
        this.facturaActual = factura;
        this.facturaActual.setLineasFactura(refrescarListaLineasFacturas());
        this.lineaFacturaActual = new LineaFactura();
    }

    public void doCrearLineaVenta() {

        Boolean errors = false;

        if (this.lineaFacturaActual.getConcepto().length() < 1) {
            errors = true;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "El concepto no puede estar vacio",
                    null));
        }

        try {
            Integer integer = (Integer) this.lineaFacturaActual.getCantidad();
        } catch (NullPointerException exc) {
            errors = true;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "El campo cantidad tiene que tener un valor entero",
                    null));
        }

        try {
            Long l = (long) this.lineaFacturaActual.getPrecio();
        } catch (NullPointerException exc) {
            errors = true;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "El campo precio tiene que tener un valor numerico",
                    null));
        }

        try {
            Long l = (long) this.lineaFacturaActual.getDescuento();
        } catch (NullPointerException exc) {
            errors = true;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "El campo descuento tiene que tener un valor numerico",
                    null));
        }

        if (this.lineaFacturaActual.getIva() == null) {
            errors = true;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Tiene que selecciona un tipo de IVA",
                    null));
        }

        if (!errors) {
            this.lineaFacturaActual.setFactura(this.facturaActual);
            this.facturaActual.addLineaFactura(this.lineaFacturaActual);
            this.lineaFacturaActual = new LineaFactura();
        }

    }

    public void doEditarLineaVenta(LineaFactura linea) {
        this.lineaFacturaActual = linea;
    }

    public void doEliminarLineaVenta(LineaFactura linea) {
        this.facturaActual.deleteLineaFactura(linea);
        this.lineasEliminadas.add(linea);
    }

    public void doGuardarEditado() {
        if (this.esNuevo) {
            daoFactura.crear(facturaActual);
        } else {
            daoFactura.actualizar(facturaActual);
            this.borrarPagos();
        }

        this.crearPagos();

        for (LineaFactura lf : this.lineasEliminadas) {
            this.daoLineaFactura.eliminar(lf);
        }

        this.facturas = refrescarListaFacturas();
        //this.clientesFacturas = obtenerClientes();
        this.facturaActual = null;
        this.esNuevo = false;
    }

    public void doCancelarEditado() {
        this.facturaActual = null;
        this.esNuevo = false;
        this.lineasEliminadas.clear();
    }

    private List<Factura> refrescarListaFacturas() {
        return daoFactura.buscarPorUsuario(authController.getUsuarioLogueado());
    }

    private List<LineaFactura> refrescarListaLineasFacturas() {
        return daoLineaFactura.buscarPorFactura(this.facturaActual);
    }

    private List<Cliente> obtenerClientes() {
        List<Cliente> listaClientes = new ArrayList<>();
        for (Factura f : this.facturas) {
            if (!listaClientes.contains(f.getCliente())) {
                listaClientes.add(f.getCliente());
            }
        }

        return listaClientes;
    }

    private void crearPagos() {

        int periodicidad = facturaActual.getFormaPago().getPeriodicidad();
        Date fecha = facturaActual.getFechaEmision();
        Calendar c = Calendar.getInstance();
        c.setTime(fecha);
        //Añade dias a la fecha
        c.add(Calendar.DATE, periodicidad);

        for (int i = 0; i < this.facturaActual.getFormaPago().getNumeroPagos(); i++) {
            Pago pago = new Pago();
            pago.setCliente(this.facturaActual.getCliente());
            pago.setEstado(EstadoPago.PENDIENTE);
            pago.setFactura(facturaActual);
            pago.setImporte(this.facturaActual.getImporte() / this.facturaActual.getFormaPago().getNumeroPagos());
            pago.setNombre(this.facturaActual.getFormaPago().getNombre());
            pago.setUsuario(authController.getUsuarioLogueado());
            pago.setFecha(c.getTime());
            this.daoPago.crear(pago);

            c.add(Calendar.DATE, periodicidad);
        }

    }

    private void borrarPagos() {
        for (Pago p : this.daoPago.buscarPorFactura(facturaActual)) {
            this.daoPago.eliminar(p);
        }
    }
}
