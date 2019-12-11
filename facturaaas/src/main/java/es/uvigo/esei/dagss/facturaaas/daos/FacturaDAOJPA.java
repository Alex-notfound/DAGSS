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
import javax.persistence.TypedQuery;

public class FacturaDAOJPA extends GenericoDAOJPA<Factura, Long> implements FacturaDAO {

    @Override
    public List<Factura> buscarPorUsuario(Usuario usuario) {
        TypedQuery<Factura> query = em.createQuery("SELECT f FROM Factura AS f WHERE f.usuario.id = :usuarioId", Factura.class);
        query.setParameter("usuarioId", usuario.getId());
        return query.getResultList();
    }
    
    @Override
    public List<Factura> buscarPorCliente(Cliente cliente) {
        TypedQuery<Factura> query = em.createQuery("SELECT f FROM Factura AS f WHERE f.cliente.id = :clienteId", Factura.class);
        query.setParameter("clienteId", cliente.getId());
        return query.getResultList();
    }
}
