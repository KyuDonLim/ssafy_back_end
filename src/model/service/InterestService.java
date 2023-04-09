package model.service;

import java.sql.SQLException;
import java.util.List;

import dto.HouseInfoDto;
import model.dao.InterestDao;

public class InterestService {
	private InterestService() {}
	private static InterestService instance = new InterestService();
	public static InterestService getInstance() {
		return instance;
	}
	
	private InterestDao dao = InterestDao.getInstance();
	
	public int zzim(String id, String aptcode) throws SQLException {
		return dao.insert(id, aptcode);
	}
	
	public List<HouseInfoDto> searchList(String id) throws SQLException{
		return dao.selectAll(id);
	}
	
	public int delete(String id, String dong, String jibun) throws SQLException {
		return dao.delete(id, dong, jibun);
	}
	
}
