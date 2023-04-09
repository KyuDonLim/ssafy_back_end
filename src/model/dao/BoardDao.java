package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.BoardDto;
import util.DBUtil;

public class BoardDao {
	private BoardDao() {}
	private static BoardDao instance = new BoardDao();
	public static BoardDao getInstance() {
		return instance;
	}
	public int write(BoardDto b) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = DBUtil.getInstance().getConnection();
			String sql = "insert into Board(type,writer,content, title) "
					+ " values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getType());
			pstmt.setString(2, b.getWriter());
			pstmt.setString(3, b.getContent());
			pstmt.setString(4, b.getTitle());
			
			result = pstmt.executeUpdate();
		}finally {
			pstmt.close();
			conn.close();
		}
		return result;
	}
	
	public int getPagesM() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = DBUtil.getInstance().getConnection();
			String sql = "select count(*) from board where type = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "문의사항");

			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
		}finally {
			pstmt.close();
			conn.close();
		}
		return result;
	}
	
	public int getPagesD() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = DBUtil.getInstance().getConnection();
			String sql = "select count(*) from board where type = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "공지사항");

			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
		}finally {
			pstmt.close();
			conn.close();
		}
		return result;
	}
	
	public List<BoardDto> getList(String type, int curpage) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardDto> result = null;
		try {
			result = new ArrayList<>();
			conn = DBUtil.getInstance().getConnection();
			String sql = "select bno, type,title, write_date from board "
					+ " where type = ? "
					+ " order by bno desc "
					+ " limit ?, ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, type);
			if(type.equals("공지사항")) {
				pstmt.setInt(2, 0);
				pstmt.setInt(3, 3);
			}else {
				pstmt.setInt(2, curpage);
				pstmt.setInt(3, 5);				
			}

			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDto b= new BoardDto();
				b.setBno(rs.getInt(1));
				b.setType(rs.getString(2));
				b.setTitle(rs.getString(3));
				b.setWrite_date(rs.getString(4));
				result.add(b);
			}
			
		}finally {
			pstmt.close();
			conn.close();
		}
		return result;
	}
	
	public BoardDto getDetail(int bno) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardDto result = null;
		try {
			conn = DBUtil.getInstance().getConnection();
			String sql = "select type, title, writer,content,write_date from board "
					+ " where bno = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = new BoardDto();
				result.setType(rs.getString(1));
				result.setTitle(rs.getString(2));
				result.setWriter(rs.getString(3));
				result.setContent(rs.getString(4));
				result.setWrite_date(rs.getString(5));
			}
			
		}finally {
			pstmt.close();
			conn.close();
		}
		return result;
	}
	
	public List<BoardDto> getSearch(int curpage, String search) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardDto> result = null;
		try {
			result = new ArrayList<>();
			conn = DBUtil.getInstance().getConnection();
			String sql = "select bno, type,title, write_date from board "
					+ " where title like ? "
					+ " order by bno desc "
					+ " limit ?, ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + search + "%");
			pstmt.setInt(2, curpage);
			pstmt.setInt(3, 5);				

			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDto b= new BoardDto();
				b.setBno(rs.getInt(1));
				b.setType(rs.getString(2));
				b.setTitle(rs.getString(3));
				b.setWrite_date(rs.getString(4));
				result.add(b);
			}
			
		}finally {
			pstmt.close();
			conn.close();
		}
		return result;
	}
	
	public int getSearch(String search) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = DBUtil.getInstance().getConnection();
			String sql = "select count(*) from board where title like ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + search + "%");

			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
		}finally {
			pstmt.close();
			conn.close();
		}
		return result;
	}
}

