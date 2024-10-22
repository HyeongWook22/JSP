package chapter12;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class InitParamFilter implements Filter
{

	private FilterConfig filterConfig = null;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Filter 초기화...");
		this.filterConfig = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterchain)
			throws IOException, ServletException {
		System.out.println("Filter02 수행...");
		
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		
		String param1 = filterConfig.getInitParameter("param1");
		String param2 = filterConfig.getInitParameter("param2");
		
		String message;
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html, charset=UTF-8");
		PrintWriter writer = response.getWriter();
		
		if (id.equals(param1) && passwd.equals(param2)) 			
		{
			message = "로그인 성공했습니다";
			System.out.println(message);
		}	
		else
		{
			message = "로그인 실패했습니다";
			System.out.println(message);
		}
			
		writer.println(message);
		
//		request.setAttribute("message", message);
		
		filterchain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		System.out.println("Filter02 해제...");

	}

}