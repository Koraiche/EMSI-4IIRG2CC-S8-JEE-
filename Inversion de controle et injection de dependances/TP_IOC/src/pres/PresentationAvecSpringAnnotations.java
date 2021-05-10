package pres;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dao.IMetier;

public class PresentationAvecSpringAnnotations {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext("dao","metier");
		IMetier metier = ctx.getBean(IMetier.class);
		System.out.println(metier.calcule());
	}

}
