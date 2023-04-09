package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.MemberDto;
import util.DBUtil;

public class MemberDao {
	private MemberDao() {}
	private static MemberDao instance = new MemberDao();
	public static MemberDao getInstance() {
		return instance;
	}

	
	public MemberDto login(String id, String pw) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs;
		MemberDto result = null;
		try {
			conn = DBUtil.getInstance().getConnection();
			String sql = "select id, name, email, addr, phone from member "
					+ " where id = ? and pwd = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs= pstmt.executeQuery();
			if(rs.next()) {
				result = new MemberDto();
				result.setId(rs.getString(1));
				result.setName(rs.getString(2));
				result.setEmail(rs.getString(3));
				result.setAddr(rs.getString(4));
				result.setPhone(rs.getString(5));
			}
		}finally {
			pstmt.close();
			conn.close();
		}
		return result;
	}

	public MemberDto getUserInfo(String id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs;
		MemberDto result = null;
		try {
			conn = DBUtil.getInstance().getConnection();
			String sql = "select id, name, email, addr, phone from member "
					+ " where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs= pstmt.executeQuery();
			if(rs.next()) {
				result = new MemberDto();
				result.setId(rs.getString(1));
				result.setName(rs.getString(2));
				result.setEmail(rs.getString(3));
				result.setAddr(rs.getString(4));
				result.setPhone(rs.getString(5));
			}
		}finally {
			pstmt.close();
			conn.close();
		}
		return result;
	}
	public int register(MemberDto m) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = DBUtil.getInstance().getConnection();
			String sql = "insert into member(id,pwd,name,email,addr,phone) "
					+ " values(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPwd());
			pstmt.setString(3, m.getName());
			pstmt.setString(4, m.getEmail());
			pstmt.setString(5, m.getAddr());
			pstmt.setString(6, m.getPhone());
			
			result = pstmt.executeUpdate();
		}finally {
			pstmt.close();
			conn.close();
		}
		return result;
	}
	public int modify(MemberDto m) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = DBUtil.getInstance().getConnection();
			String sql = "update member set name = ?, email =?, addr=?, phone=? "
					+ "where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getName());
			pstmt.setString(2, m.getEmail());
			pstmt.setString(3, m.getAddr());
			pstmt.setString(4, m.getPhone());
			pstmt.setString(5, m.getId());
			
			result = pstmt.executeUpdate();
		}finally {
			pstmt.close();
			conn.close();
		}
		return result;
	}
}

