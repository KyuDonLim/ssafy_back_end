package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;

import dto.HouseDealDto;
import dto.HouseInfoDto;
import dto.MemberDto;
import model.service.HouseService;
import model.service.MemberService;

@WebServlet("/map")
public class MapController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HouseService houseService = HouseService.getInstance();
	private MemberService memberService = MemberService.getInstance();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		try {
		if(action == null) {
			MemberDto m = (MemberDto) req.getSession().getAttribute("loginInfo");
			String id = m.getId();
				m = memberService.getUserInfo(id);
				req.getSession().setAttribute("loginInfo", m);
				req.getRequestDispatcher("index.jsp").forward(req, resp);
			} else if(action.equals("zzim")) {
				System.out.println("hi");
				req.getRequestDispatcher("/pages/map.jsp").forward(req, resp);
			}
		}catch (Exception e) {
			e.printStackTrace();
			req.getRequestDispatcher("/error/error.jsp").forward(req, resp);
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		String action = req.getParameter("action");

		if (action.equals("search")) {
			String sido = req.getParameter("sido");
			String gugun = req.getParameter("gugun");
			String dong = req.getParameter("dong");

			List<HouseInfoDto> list = new ArrayList<>();
			list = houseService.searchList(sido, gugun, dong);
			
			List<String> forwardList = new ArrayList<>();
			for (HouseInfoDto l : list) { // 여기안에 aptCode가 있으니
				// aptCode 통해서 그 집의 정보 꺼내기
				HouseDealDto dto = houseService.selectOne(l.getAptCode());
				// 이후에 toString에 붙여서 forwardList에 담기
				String s = l.toString() + dto.toString();
				forwardList.add(s);
			}
			
			JSONArray jsonArray = new JSONArray(forwardList.toString());
			
			req.setAttribute("jsonArray", jsonArray);
			HttpSession session = req.getSession();
			session.setAttribute("jsonArray", jsonArray);
			req.getRequestDispatcher("/pages/map.jsp").forward(req, resp);
		}

	}

}
