package controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDto;
import model.service.BoardService;

@WebServlet("/board")
public class BoardController extends HttpServlet{
	BoardService service =BoardService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String action = req.getParameter("action");
		
		try {
			if(action == null || action.equals("list")) {
				String p = req.getParameter("curpage");
				if(p == null) p = "1";
				int curpage = Integer.parseInt(p);
				Map<String, Object> result = service.getList(curpage);
				
				req.setAttribute("list", result);
				req.getRequestDispatcher("/pages/notice.jsp").forward(req, resp);
			}else if(action.equals("mvwrite")) {
				req.getRequestDispatcher("/pages/noticeWrite.jsp").forward(req, resp);
			}else if(action.equals("detail")) {
				String no = req.getParameter("bno");
				int bno = Integer.parseInt(no);
				BoardDto b = service.getDetail(bno);
				req.setAttribute("board", b);
				req.getRequestDispatcher("/pages/noticeDetail.jsp").forward(req, resp);
			}else if(action.equals("search")) {
				doPost(req, resp);
			}
		}catch(Exception e) {
			resp.sendRedirect(req.getContextPath()+ "/error/error.jsp");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String action = req.getParameter("action");
		try {
			if(action == null || action.equals("list")) {
				doGet(req, resp);
			}else if(action.equals("search")) {
				String search = req.getParameter("search");
				String p = req.getParameter("curpage");
				if(p == null || p.equals("0")) p = "1";
				int curpage = Integer.parseInt(p);
				System.out.println("P : " + curpage);
				Map<String, Object> result = service.getSearch(curpage,search);
				req.setAttribute("list", result);
				req.getRequestDispatcher("/pages/notice.jsp").forward(req, resp);
			}
			else if(action.equals("write")) {
				String type = req.getParameter("type");
				String title = req.getParameter("title");
				String writer = req.getParameter("userId");
				String content = req.getParameter("content");
				BoardDto b = new BoardDto();
				b.setTitle(title);
				b.setContent(content);
				b.setType(type);
				b.setWriter(writer);
				int result = service.write(b);
				if(result == 1) {
					resp.sendRedirect(req.getContextPath()+"/board?action=list");
				}else {
					resp.sendRedirect(req.getContextPath()+ "/error/error.jsp");
				}
			}
		}catch(Exception e) {
			resp.sendRedirect(req.getContextPath()+ "/error/error.jsp");
		}
		
	}
}
