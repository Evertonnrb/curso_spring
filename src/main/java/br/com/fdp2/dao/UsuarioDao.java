package br.com.fdp2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.fdp2.domain.Usuario;

@Repository //avisa o spring para controlar a classe
public class UsuarioDao {
	
	@PersistenceContext //Passa a resp de instacia para o spring
	EntityManager em;

	public UsuarioDao(){}
	
	public UsuarioDao(EntityManager em) {
		this.em = em;
	}
	
	@Transactional	//passa para o spring o controle de instancia de manager
	public void cadastrar(Usuario usu) {

		em.merge(usu);

	}

	@Transactional
	public void excluir(Usuario usu) {

		em.remove(usu);
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
