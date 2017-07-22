package br.com.fdp2.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.fdp2.dao.UsuarioDao;
import br.com.fdp2.domain.Usuario;

public class TestUsuarioDao {

	EntityManager manager;
	ClassPathXmlApplicationContext ctx;

	/**
	 * inicializa a instancia antes dos testes
	 */
	@Before
	public void init() {
		ctx = new ClassPathXmlApplicationContext("file:src/main/resources/META-INF/springbeans.xml");
		EntityManagerFactory em = (EntityManagerFactory) ctx.getBean("entityManagerFactory");
		manager = em.createEntityManager();

	}

	/**
	 * libera a instancia quando nao for mais usada
	 */
	@After
	public void finaliza() {
		ctx.close();
	}

	@Test
	@Ignore
	public void salvar() {
		Usuario usu = new Usuario();
		usu.setNome("Aline");
		usu.setEmail("aaa@gmail.com");
		usu.setSenha("alinezinha");
		UsuarioDao dao = new UsuarioDao(manager);
		dao.cadastrar(usu);
		// manager.persist(usu);

	}

	@Test
	@Ignore
	public void buscarPorId() {
		Usuario usu = new Usuario();
		usu.setId(3);
		UsuarioDao dao = new UsuarioDao(manager);
		Usuario usuBusado = dao.buscarPorId(usu.getId());
		Assert.assertNotEquals(usuBusado, usuBusado);
		// System.out.println(dao.buscarPorId(usu.getId()));
		// usuBusado.toString();
	}

	@Test
	@Ignore
	public void excluir() {
		Usuario usuSalvo = new Usuario("test", "test", "test");
		UsuarioDao dao = new UsuarioDao(manager);
		dao.excluir(usuSalvo);
		Assert.assertEquals(usuSalvo, null);
	}

	@Test
	public void buscarTodos() {
		UsuarioDao dao = new UsuarioDao(manager);
		for (Usuario usu : dao.buscarTodos()) {
			//System.out.println(usu.toString());
			//Assert.assertTrue(usu!=null);
			Assert.assertNotNull(usu);
		}
		
	}
}
