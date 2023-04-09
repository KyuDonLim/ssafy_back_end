package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.HouseInfoDto;
import dto.InterestDto;
import dto.MemberDto;
import model.service.InterestService;
import model.service.MemberService;

@WebServlet("/member")
public class MemberController extends HttpServlet {
	private static MemberService service = MemberService.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String action = req.getParameter("action");
		try {
			if (action == null || action.equals("mvlogin")) {
				req.getRequestDispatcher("/pages/login.jsp").forward(req, resp);
			} else if (action.equals("logout")) {
				req.getSession().invalidate();
				resp.sendRedirect(req.getContextPath());
			} else if (action.equals("mypage")) {
				req.getRequestDispatcher("/pages/myPage.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			req.getRequestDispatcher("/error/error.jsp").forward(req, resp);
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String action = req.getParameter("action");
		try {
			if (action == null || action.equals("login")) {
				String id = req.getParameter("userId");
				String pw = req.getParameter("userPw");
				MemberDto loginInfo = service.login(id, pw);

				if (loginInfo != null) {
					HttpSession session = req.getSession();
					session.setAttribute("loginInfo", loginInfo);
					resp.sendRedirect(req.getContextPath());
				} else {
					resp.sendRedirect(req.getContextPath());
				}
			} else if (action.equals("register")) {

				String id = req.getParameter("id");
				String pw = req.getParameter("pwd");
				String name = req.getParameter("name");
				String email = req.getParameter("email");
				String addr = req.getParameter("addr");
				String phone = req.getParameter("phone");

				MemberDto m = new MemberDto();

				m.setAddr(addr);
				m.setEmail(email);
				m.setId(id);
				m.setName(name);
				m.setPhone(phone);
				m.setPwd(pw);

				int result = service.register(m);
				if (result == 1) {
					resp.sendRedirect(req.getContextPath());
				} else {
					req.getRequestDispatcher("/error/error.jsp").forward(req, resp);
				}

			} else if (action.equals("modify")) {

				String id = req.getParameter("userId");
				String name = req.getParameter("name");
				String email = req.getParameter("email");
				String addr = req.getParameter("addr");
				String phone = req.getParameter("phone");

				MemberDto m = new MemberDto();

				m.setAddr(addr);
				m.setEmail(email);
				m.setId(id);
				m.setName(name);
				m.setPhone(phone);
				int result = service.modify(m);
				if (result == 1) {
					resp.sendRedirect(req.getContextPath() + "/map");
				} else {
					req.getRequestDispatcher("/error/error.jsp").forward(req, resp);
				}

			} 
		} catch (Exception e) {
			req.getRequestDispatcher("/error/error.jsp").forward(req, resp);
		}

	}
}
