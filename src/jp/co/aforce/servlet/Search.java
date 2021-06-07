package jp.co.aforce.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.Beans;
import jp.co.aforce.dao.Dao;

@WebServlet(urlPatterns={"/jp.co.aforce.servlet/search"})
public class Search extends HttpServlet {

	public Search() {
		super();
	}

	protected void doGet(
			HttpServletRequest request,HttpServletResponse response
		) throws ServletException, IOException {}

	protected void doPost(
			HttpServletRequest request,HttpServletResponse response
		) throws ServletException, IOException {

		String userId = request.getParameter("userId");
		String password = request.getParameter("password");

		Beans b = new Beans();
		b.setUserId(userId);
		b.setPassword(password);

		Dao d = new Dao();
		Beans returnb = d.findAccount(b);

		if (returnb != null) {
			HttpSession session = request.getSession();
			session.setAttribute("account", returnb);

			RequestDispatcher rd = request.getRequestDispatcher("../jsp/success.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("../jsp/false.jsp");
			rd.include(request, response);
		}
	}

}
