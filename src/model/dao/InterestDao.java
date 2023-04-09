package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import dto.HouseInfoDto;
import dto.InterestDto;
import util.DBUtil;

public class InterestDao {
	private InterestDao() {}
	private static InterestDao instance = new InterestDao();
	public static InterestDao getInstance() {
		return instance;
	}
	
	public int insert(String id, String aptcode) throws SQLException {
		DBUtil util = DBUtil.getInstance();
		Connection conn = util.getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "";
		
		try {
			sql = " insert into interest(id, aptcode) "
					+ " values(?, ?) ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, aptcode);
			
			result = pstmt.executeUpdate();
		} finally {
			util.close(conn, pstmt);
		}
		return result;
	}
	
	public int delete(String id, String dong, String jibun) throws SQLException {
		DBUtil util = DBUtil.getInstance();
		Connection conn = util.getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "";
		System.out.println(id + " " + dong + " " + jibun);
		
		try {
			sql = " delete from interest " + 
					" where id = ? and aptcode = (select aptcode " + 
					" from houseinfo " + 
					" where dong = ? and jibun = ? ) ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id.trim());
			pstmt.setString(2, dong.trim());
			pstmt.setString(3, jibun.trim());
			
			
			result = pstmt.executeUpdate();
		} finally {
			util.close(conn, pstmt);
		}
		return result;
	}
	
	public List<HouseInfoDto> selectAll(String id) throws SQLException{
		DBUtil util = DBUtil.getInstance();
		Connection conn = util.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		List<HouseInfoDto> result = new ArrayList<>();
		
		try {
			sql = " select distinct JIBUN , DONG , APARTMENTNAME "
					+ " from interest, houseinfo "
					+ " where houseinfo.aptCode in (select aptCode "
										+ " from interest "
										+ "	where id= ?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				HouseInfoDto dto = new HouseInfoDto();
				
				dto.setJibun(rs.getString(1));
				dto.setDong(rs.getString(2));
				dto.setApartmentName(rs.getString(3));
				
				result.add(dto);
			}
			
		} finally {
			util.close(conn, pstmt, rs);
		}
		return result;
	}
	
}
