package br.com.fdp2.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fdp2.dao.UsuarioDao;
import br.com.fdp2.domain.Usuario;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("fabricaweb2");
		EntityManager manager = factory.createEntityManager();
		UsuarioDao dao = new UsuarioDao(manager);
		
		Usuario usu = new Usuario("Pele","pele@yahoo.com","pelezinho");
		
		dao.cadastrar(usu);
		dao.buscarTodos();
		
		
	}
}
