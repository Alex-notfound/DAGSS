/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uvigo.esei.dagss.facturaaas.daos;

import es.uvigo.esei.dagss.facturaaas.entidades.Cliente;
import es.uvigo.esei.dagss.facturaaas.entidades.Factura;
import es.uvigo.esei.dagss.facturaaas.entidades.Pago;
import es.uvigo.esei.dagss.facturaaas.entidades.Usuario;
import java.util.List;

public interface PagoDAO extends GenericoDAO<Pago, Long> {

    public List<Pago> buscarPorUsuario(Usuario usuario);

    public List<Pago> buscarPorCliente(Cliente cliente, Usuario usuario);
    
    public List<Pago> buscarPorFactura(Factura factura);
    
}
