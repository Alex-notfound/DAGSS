/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uvigo.esei.dagss.facturaaas.daos;

import es.uvigo.esei.dagss.facturaaas.entidades.Cliente;
import es.uvigo.esei.dagss.facturaaas.entidades.Factura;
import es.uvigo.esei.dagss.facturaaas.entidades.LineaFactura;
import es.uvigo.esei.dagss.facturaaas.entidades.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

@Stateless
public class LineaFacturaDAOJPA extends GenericoDAOJPA<LineaFactura, Long> implements LineaFacturaDAO{
    
    @Override
    public List<LineaFactura> buscarPorUsuario(Usuario usuario) {
        TypedQuery<LineaFactura> query = em.createQuery("SELECT f FROM LineaFactura AS f WHERE f.usuario.id = :usuarioId", LineaFactura.class);
        query.setParameter("usuarioId", usuario.getId());
        return query.getResultList();
    }
    
    @Override
    public List<LineaFactura> buscarPorFactura(Factura factura) {
        TypedQuery<LineaFactura> query = em.createQuery("SELECT f FROM LineaFactura AS f WHERE f.factura.numFactura = :numFactura", LineaFactura.class);
        query.setParameter("numFactura", factura.getNumFactura());
        return query.getResultList();
    }
}
