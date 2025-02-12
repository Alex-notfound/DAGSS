/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uvigo.esei.dagss.facturaaas.daos;

import es.uvigo.esei.dagss.facturaaas.entidades.Cliente;
import es.uvigo.esei.dagss.facturaaas.entidades.Factura;
import es.uvigo.esei.dagss.facturaaas.entidades.Usuario;
import java.util.List;

public interface FacturaDAO extends GenericoDAO<Factura, Long>{
     
    public List<Factura> buscarPorUsuario(Usuario usuario);
            
    public List<Factura> buscarPorCliente(Cliente cliente, Usuario usuario);
}
