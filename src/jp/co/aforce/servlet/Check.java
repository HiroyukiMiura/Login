package jp.co.aforce.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/jp.co.aforce.servlet/check"})
public class Check extends HttpServlet {
	public Check() {
		super();
	}

	protected void doPost(
			HttpServletRequest request,HttpServletResponse response
		) throws ServletException,IOException {
		doGet(request, response);
	}

}
