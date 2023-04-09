package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.HouseDealDto;
import dto.HouseInfoDto;
import util.DBUtil;

public class HouseDao {

	private static final HouseDao instance = new HouseDao();

	private HouseDao() {
	}

	public static HouseDao getInstance() {
		return instance;
	}

	private static final DBUtil util = DBUtil.getInstance();

	// 처음 조회
	public List<HouseInfoDto> selectAll(String sido, String gugun, String dong) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<HouseInfoDto> result = null;

		String sql = "SELECT DONG, JIBUN, APTCODE, APARTMENTNAME, LAT, LNG" + " FROM DONGCODE D, HOUSEINFO H"
				+ " WHERE D.DONGCODE = H.DONGCODE" + " AND SIDONAME = ?" + " AND GUGUNNAME = ?" + " AND DONGNAME = ?";

		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			result = new ArrayList<>();
			pstmt.setString(1, sido);
			pstmt.setString(2, gugun);
			pstmt.setString(3, dong);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				HouseInfoDto dto = new HouseInfoDto();

				dto.setDong(rs.getString(1));
				dto.setJibun(rs.getString(2));
				dto.setAptCode(rs.getDouble(3));
				dto.setApartmentName(rs.getString(4));
				dto.setLat(rs.getString(5));
				dto.setLng(rs.getString(6));

				result.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			util.close(rs, pstmt, conn);
		}

		return result;
	}

	// 상세 조회
	public HouseDealDto selectOne(double aptCode) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		HouseDealDto result = null;

		String sql = "select dealAmount, area, floor"
				+ " from housedeal d, houseinfo h" + " where d.aptCode = ?"
						+ " LIMIT 20";
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			result = new HouseDealDto();
			pstmt.setDouble(1, aptCode);

			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result.setDealAmount(rs.getString(1));
				result.setArea(rs.getString(2));
				result.setFloor(rs.getString(3));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			util.close(rs, pstmt, conn);
		}

		return result;
	}
}
