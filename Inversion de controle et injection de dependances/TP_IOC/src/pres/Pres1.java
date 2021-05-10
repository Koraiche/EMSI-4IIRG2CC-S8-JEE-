package pres;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.Scanner;

import dao.DaoImpl;
import dao.IDao;
import dao.IMetier;
import dao.MetierImpl;

public class Pres1 {

	public static void main(String[] args) throws Exception{
		/*
		DaoImpl daoImpl =new DaoImpl();
		MetierImpl metier = new MetierImpl();
		metier.setDao(daoImpl);
		System.out.println(metier.calcule()); 
		*/try {
			Scanner scanner = new Scanner(new File("config.txt"));
			String daoClassName= scanner.nextLine();
			System.out.println(daoClassName);
			Class cDao = Class.forName(daoClassName);
			IDao dao =(IDao) cDao.newInstance();
			System.out.println(dao.getData());
			
			String metierClassName= scanner.nextLine();
			System.out.println(metierClassName);
			Class cMetier = Class.forName(metierClassName);
			IMetier metier =(IMetier) cMetier.newInstance();
			Method method = cMetier.getMethod("setDao", IDao.class);
			method.invoke(metier, dao);
			System.out.println(metier.calcule());
			
		}catch(FileNotFoundException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}

}
