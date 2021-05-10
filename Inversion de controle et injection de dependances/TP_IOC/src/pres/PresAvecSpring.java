package pres;

import org.springframework.context.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.IMetier;


public class PresAvecSpring {
	public static void main(String[] args) {
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("config.xml");
		IMetier metier = ctx.getBean(IMetier.class);
		System.out.println(metier.calcule());
	}
}
