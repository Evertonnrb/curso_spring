package br.com.fdp2.main;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import br.com.fdp2.dao.UsuarioDao;
import br.com.fdp2.domain.Usuario;


@RunWith(SpringJUnit4ClassRunner.class)//informa que o springRunner ira rodar os testes
@ContextConfiguration(locations="file:src/main/resources/META-INF/springbeans.xml")	//aponta para o arquivo de configuração
@TransactionConfiguration(transactionManager="transactionManager")//informa o aquivo de gerenciamento de trasação
public class TestUsuarioDao2 {

	@Autowired
	UsuarioDao dao;
	
	@Test
	//@Ignore
	public void salvar() {
		Usuario usu = new Usuario();
		usu.setNome("Eniexe");
		usu.setEmail("NANa@gmail.com");
		usu.setSenha("enen");
		dao.cadastrar(usu);
		// manager.persist(usu);

	}

	@Test
	@Ignore
	public void buscarPorId() {
		Usuario usu = new Usuario();
		usu.setId(3);
		Usuario usuBusado = dao.buscarPorId(usu.getId());
		Assert.assertNotEquals(usuBusado, usuBusado);
		// System.out.println(dao.buscarPorId(usu.getId()));
		// usuBusado.toString();
	}

	@Test
	@Ignore
	public void excluir() {
		Usuario usuSalvo = new Usuario("test", "test", "test");
		dao.excluir(usuSalvo);
		Assert.assertEquals(usuSalvo, null);
	}

	@Test
	@Ignore
	public void buscarTodos() {
		for (Usuario usu : dao.buscarTodos()) {
			//System.out.println(usu.toString());
			//Assert.assertTrue(usu!=null);
			Assert.assertNotNull(usu);
		}
		
	}
}
