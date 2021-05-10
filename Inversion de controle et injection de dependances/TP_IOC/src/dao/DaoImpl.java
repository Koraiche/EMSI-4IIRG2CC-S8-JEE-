package dao;

import org.springframework.stereotype.Component;

@Component(value="dao")
public class DaoImpl implements IDao {
	@Override
	public double getData() {
		double data = 8.7;
		return data;
	}
	public void init() {
		System.out.println("Instanciationde Dao Impl");
	}
}
