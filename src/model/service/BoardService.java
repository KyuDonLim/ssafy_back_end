package model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dto.BoardDto;
import model.dao.BoardDao;

public class BoardService {
	private static BoardDao dao = BoardDao.getInstance();
	private static BoardService instance = new BoardService();
	
	private BoardService() {}
	public static BoardService getInstance() {
		return instance;
	}
	
	
	public int write(BoardDto b) throws Exception{
		return dao.write(b);
	}
	
	public Map<String, Object> getList(int curpage) throws Exception{
		Map<String, Object> result = new HashMap<>();
		result.put("curpage", curpage);
		
		int totalcnt = dao.getPagesM();
		int totalPage = totalcnt / 5;
		if(totalcnt%5 != 0) {
			totalPage++;
		}
		result.put("totalPage", totalPage);
		
		int startPage = (curpage-1)/10*10+1;
		result.put("startPage", startPage);
		
		int endPage = startPage+9 <totalPage ? startPage+9 : totalPage;
		result.put("endPage", endPage);
		
		curpage = (curpage-1)*5;
		List<BoardDto> list1 = dao.getList("공지사항",0);
		result.put("list1", list1);
		List<BoardDto> list2 = dao.getList("문의사항",curpage);
		result.put("list2", list2);
		
		result.put("type", "list");
		return result;
	}
	
	public BoardDto getDetail(int bno) throws Exception{
		return dao.getDetail(bno);
	}
	
	public Map<String, Object> getSearch(int curpage, String search) throws Exception{
		Map<String, Object> result = new HashMap<>();
		result.put("curpage", curpage);
		
		int startPage = (curpage-1)/10*10+1;
		result.put("startPage", startPage);
		System.out.println(startPage);
		
		
		curpage = (curpage-1)*5;
		List<BoardDto> list1 = dao.getList("공지사항",0);
		result.put("list1", list1);
		List<BoardDto> list2 = dao.getSearch(curpage, search);
		result.put("list2", list2);
		
		int totalcnt = dao.getSearch(search);
		System.out.println(totalcnt);
		int totalPage = totalcnt / 5;
		if(totalcnt%5 != 0) {
			totalPage++;
		}
		result.put("totalPage", totalPage);
		System.out.println(totalPage);
		int endPage = startPage+9 <totalPage ? startPage+9 : totalPage;
		result.put("endPage", endPage);
		
		System.out.println(endPage);
		
		result.put("type", "search");
		result.put("search", search);
		return result;
	}
}


