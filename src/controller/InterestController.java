package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.HouseInfoDto;
import dto.MemberDto;
import model.service.InterestService;

@WebServlet("/interest")
public class InterestController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		InterestService service = InterestService.getInstance();
		try {
			if (action.equals("zzim")) {
				HttpSession session = req.getSession();
				MemberDto member = (MemberDto) session.getAttribute("loginInfo");
				String id = member.getId();
				String aptcode = req.getParameter("aptcode");
				int result = service.zzim(id, aptcode);
				
				if(result == 1) {
					System.out.println("성공");
					req.getRequestDispatcher("/pages/map.jsp").forward(req, resp);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String action = req.getParameter("action");
		InterestService service = InterestService.getInstance();
		
		try {
			if (action.equals("interest")) {
				HttpSession session = req.getSession();
				MemberDto member = (MemberDto) session.getAttribute("loginInfo");
				
				String id = member.getId();
				List<HouseInfoDto> list = service.searchList(id);
				req.setAttribute("interestList", list);
				req.getRequestDispatcher("/pages/myInterest.jsp").forward(req, resp);
			}else if(action.equals("delete")) {
				HttpSession session = req.getSession();
				String dong = req.getParameter("dong");
				String jibun = req.getParameter("jibun");
				MemberDto member = (MemberDto) session.getAttribute("loginInfo");
				String id = member.getId();
				
				int result = service.delete(id, dong, jibun);
				
				List<HouseInfoDto> list = service.searchList(id);
				req.setAttribute("interestList", list);
				req.getRequestDispatcher("/pages/myInterest.jsp").forward(req, resp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
