package br.com.fdp2.util;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

	/**
	 * Classe factory /Singleton
	 * pattern
	 * Conceito de usar apenas uma instacia para usar na memória
	 * @author everton
	 *
	 */

public class JpaUtil {
	private static EntityManager em;
	
	public static EntityManager getEntimanager(){
		if(em == null){
			em = Persistence.createEntityManagerFactory("fabricaweb2").createEntityManager();
		}
		return null;
	}
}
