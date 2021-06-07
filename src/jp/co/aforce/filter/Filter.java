package jp.co.aforce.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class Filter implements javax.servlet.Filter {
	public void doFilter(ServletRequest request,ServletResponse response,
			FilterChain chain)throws IOException,ServletException {
		request.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) {}

	public Filter() {}
	public void destroy() {}

}
