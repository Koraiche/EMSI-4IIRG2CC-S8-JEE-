package et;

import org.springframework.stereotype.Repository;

import dao.IDao;

@Repository
public class DaoImplV2 implements IDao {
	public double getData() {
		System.out.println("Version service web");
		double data =12;
		return data;
	}
}
