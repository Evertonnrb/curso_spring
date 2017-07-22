package br.com.fdp2.main;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Testes {

	@Test
	public void conetar() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"file:src/main/resources/META-INF/springbeans.xml");
		ctx.close();
	}
	
}
