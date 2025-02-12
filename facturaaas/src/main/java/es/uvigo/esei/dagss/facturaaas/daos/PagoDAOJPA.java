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
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

@Stateless
public class PagoDAOJPA extends GenericoDAOJPA<Pago, Long> implements PagoDAO {

    @Override
    public List<Pago> buscarPorUsuario(Usuario usuario) {
        TypedQuery<Pago> query = em.createQuery("SELECT p FROM Pago AS p WHERE p.usuario.id = :usuarioId", Pago.class);
        query.setParameter("usuarioId", usuario.getId());
        return query.getResultList();
    }

    @Override
    public List<Pago> buscarPorCliente(Cliente cliente, Usuario usuario) {
        TypedQuery<Pago> query = em.createQuery("SELECT p FROM Pago AS p WHERE p.usuario.id = :usuarioId AND p.cliente.id = :clienteId", Pago.class);
        query.setParameter("usuarioId", usuario.getId());
        query.setParameter("clienteId", cliente.getId());
        return query.getResultList();
    }

    @Override
    public List<Pago> buscarPorFactura(Factura factura) {
        TypedQuery<Pago> query = em.createQuery("SELECT p FROM Pago AS p WHERE p.factura = :factura", Pago.class);
        query.setParameter("factura", factura);
        return query.getResultList();
    }
}
