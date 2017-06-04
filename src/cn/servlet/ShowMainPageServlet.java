package cn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.domain.mainpage;
import cn.service.model;

/**
 * ClassName: ShowMainPageServlet Function: TODO 用来查询数据库中mainpage的信息， 返回给前端页面
 * date: 2016年12月2日 下午3:47:44
 * 
 * @author 13信息_晚进军
 * @version
 * @since JDK 1.7.0_51
 */
@SuppressWarnings("serial")
public class ShowMainPageServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		// 从session中获取账号和登录成功的标志
		String account = (String) session.getAttribute("account");
		boolean flag = (boolean) session.getAttribute("flag");
		
		// System.out.println(account+flag);
		// 判断之前是否登录成功
		if (flag) {
			model userService = new model();
			// 查询mainpage
			List<mainpage> mainpageList = userService.MainPageServlet(account);
			// 数据存储在session里面， 给用户显示
			request.setAttribute("mainpageList", mainpageList);
			request.getRequestDispatcher("/WEB-INF/jsp/mainpage.jsp").forward(
					request, response);
		} else {
			request.getRequestDispatcher("error.html").forward(request,
					response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
