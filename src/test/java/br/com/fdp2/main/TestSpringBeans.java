package br.com.fdp2.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.fdp2.dao.UsuarioDao;
import br.com.fdp2.domain.Usuario;

/**
 * Apresentação de como funciona o spring beans
 * @author everton
 *
 */

public class TestSpringBeans {
	public static void main(String[] args) {	
		/**
		 * carregando o contexto do spring
		 */
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("file:src/main/resources/META-INF/springbeans.xml");
		
		/**
		 * Persistindo um usuario atravez do bean do spring
		 */
		Usuario usu = (Usuario) ctx.getBean("usuario");
		System.out.println(usu);
		
		BasicDataSource db = (BasicDataSource) ctx.getBean("dataSource");
		System.out.println(db.getUsername());
		System.out.println(db.getPassword());
		System.out.println(db.getUrl());
		System.out.println(db.getDriverClassName());
		System.out.println(db.toString());
		
		EntityManagerFactory em = (EntityManagerFactory)ctx.getBean("entityManagerFactory");
		EntityManager manager = em.createEntityManager();
		
		Usuario usuario = new Usuario("tt","tttt","12343tt");
//		manager.getTransaction().begin();
//		manager.persist(usuario);
//		manager.getTransaction().commit();
//		
		UsuarioDao dao = new UsuarioDao(manager);
		dao.cadastrar(usuario);
		ctx.close();
	}
}
