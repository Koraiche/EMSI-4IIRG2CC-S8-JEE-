package dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service(value="metier")
public class MetierImpl implements IMetier {
	@Autowired
	private IDao dao=null;
	@Override
	public double calcule() {
		double d = dao.getData();
		return d*23;
	}
	public void setDao(IDao dao) {
		this.dao = dao;
		System.out.println("Injection des depandances");
	}
	public void init() {
		System.out.println("Instanciationde Metier Impl");
	}
}
