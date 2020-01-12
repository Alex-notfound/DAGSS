/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uvigo.esei.dagss.facturaaas.daos;

import es.uvigo.esei.dagss.facturaaas.entidades.Factura;
import es.uvigo.esei.dagss.facturaaas.entidades.LineaFactura;
import es.uvigo.esei.dagss.facturaaas.entidades.Usuario;
import java.util.List;

public interface LineaFacturaDAO extends GenericoDAO<LineaFactura, Long> {
    
    public List<LineaFactura> buscarPorUsuario(Usuario usuario);
            
    public List<LineaFactura> buscarPorFactura(Factura factura);

}
