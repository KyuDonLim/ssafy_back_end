package model.service;

import java.util.List;

import dto.HouseDealDto;
import dto.HouseInfoDto;
import model.dao.HouseDao;

public class HouseService {

	private static final HouseService instance = new HouseService();

	private HouseService() {}
	
	public static HouseService getInstance() {
		return instance;
	}
	
	private HouseDao dao = HouseDao.getInstance();

	public List<HouseInfoDto> searchList(String sido, String gugun, String dong) {
		return dao.selectAll(sido, gugun, dong);
	}
	
	public HouseDealDto selectOne(double aptCode) {
		return dao.selectOne(aptCode);
	}
	
}
