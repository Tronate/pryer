package cn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.domain.userInfo;
import cn.service.model;

/**
 * 
 * ClassName: ShowPersonServlet Function: TODO 用来查询个人信息并且存储在数据库里面 date:
 * 2016年12月2日 下午3:58:42
 * 
 * @author 13信息_晚进军
 * @version
 * @since JDK 1.7.0_51
 */
public class ShowPersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		//从session中获取账号和登录成功的标志
		String account = (String) session.getAttribute("account");
		boolean flag = (boolean)session.getAttribute("flag");
		//判断之前是否登录成功
		if (flag) {
			model userService = new model();
			List<userInfo> usersList = userService.PersonServlet(account);
			request.setAttribute("usersList", usersList);
			request.getRequestDispatcher("/WEB-INF/jsp/person.jsp").forward(
					request, response);

		}

		else {
			request.getRequestDispatcher("error.html").forward(request,
					response);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
