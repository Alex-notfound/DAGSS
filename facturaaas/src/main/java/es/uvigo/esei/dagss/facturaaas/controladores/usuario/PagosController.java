
package es.uvigo.esei.dagss.facturaaas.controladores.usuario;

import es.uvigo.esei.dagss.facturaaas.controladores.AutenticacionController;
import es.uvigo.esei.dagss.facturaaas.daos.PagoDAO;
import es.uvigo.esei.dagss.facturaaas.entidades.Cliente;
import es.uvigo.esei.dagss.facturaaas.entidades.EstadoPago;
import es.uvigo.esei.dagss.facturaaas.entidades.Factura;
import es.uvigo.esei.dagss.facturaaas.entidades.LineaFactura;
import es.uvigo.esei.dagss.facturaaas.entidades.Pago;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "pagosController")
@ViewScoped
public class PagosController implements Serializable{
    private List<Pago> pagos;
    private Pago pagoActual;
    private Cliente clienteFiltrado;

    @Inject
    private PagoDAO daoPago;
    
    @Inject
    private AutenticacionController authController;

    public List<Pago> getPagos() {
        return pagos;
    }

    public void setPagos(List<Pago> pagos) {
        this.pagos = pagos;
    }

    public Cliente getClienteFiltrado() {
        return clienteFiltrado;
    }

    public void setClienteFiltrado(Cliente clienteFiltrado) {
        this.clienteFiltrado = clienteFiltrado;
    }

    public Pago getPagoActual() {
        return pagoActual;
    }

    public void setPagoActual(Pago pagoActual) {
        this.pagoActual = pagoActual;
    }
    
    public EstadoPago[] getEstadosPago(){
        return EstadoPago.values();
    }
    
    @PostConstruct
    public void cargaInicial(){
        this.pagos = this.refrescarLista();
        this.pagoActual = null;
    }
    
    public void doBuscarPorCliente(){
        if(clienteFiltrado != null){
            this.pagos = daoPago.buscarPorCliente(clienteFiltrado);
        }else{
            this.pagos = this.refrescarLista();
        }
    }
    
    public void doEditar(Pago pago){
        this.pagoActual = pago;
    }
    
    public void doGuardarEditado(){
        daoPago.actualizar(pagoActual);
        this.pagos = refrescarLista();
        this.pagoActual = null;
    }
    
    public void doCancelarEditado(){
        this.pagoActual = null;
    }
    
    public List<Cliente> obtenerClientes(){
        List<Cliente> listaClientes = new ArrayList<>();
        for(Pago p : this.pagos){
            if(!listaClientes.contains(p.getCliente())){
                listaClientes.add(p.getCliente());
            }
        }
        
        return listaClientes;
    }
    
    private List<Pago> refrescarLista(){
        return daoPago.buscarPorUsuario(authController.getUsuarioLogueado());
    }
}
