package br.com.fdp2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.fdp2.domain.Usuario;

@Repository //avia o spring para controlar a classe
public class UsuarioDao {
	
	@PersistenceContext //Passa a resp de instacia para o spring
	EntityManager em;

	public UsuarioDao(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Usuario usu) {

		em.getTransaction().begin();
		em.merge(usu);
		em.getTransaction().commit();

	}

	public void excluir(Usuario usu) {

		em.getTransaction().begin();
		em.remove(usu);
		em.getTransaction().commit();
	}

	public Usuario buscarPorId(Integer id) {
		return em.find(Usuario.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> buscarTodos() {
		Query query = em.createQuery("select u from Usuario u");
		return query.getResultList();

	}

}
