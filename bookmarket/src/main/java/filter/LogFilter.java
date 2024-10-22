package filter;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

import java.util.*;

public class LogFilter implements Filter
{

	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException 
	{
		System.out.println("BookMarket 초기화...");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain fc)
			throws IOException, ServletException 
	{
		System.out.println(" 접속한 클라이언트 IP : " + req.getRemoteAddr());
		long start = System.currentTimeMillis();
		System.out.println(" 접근한 URL 경로 : " + getURLPath(req));
		System.out.println(" 요청 처리 시작 시각 : " + getCurrentTime());
		fc.doFilter(req, res);
	}


	@Override
	public void destroy() {
		
	}
	
	private String getURLPath(ServletRequest req) {
		HttpServletRequest hreq;
		String currentPath = "";
		String queryString = "";
		if(req instanceof HttpServletRequest)
		{
			req=(HttpServletRequest)req;
			currentPath = ((HttpServletRequest) req).getRequestURI();
			queryString = ((HttpServletRequest) req).getQueryString();
			queryString = queryString == null ? "" : "?" + queryString;
		}
		return currentPath+queryString;
	}
	
	private String getCurrentTime() 
	{
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		return formatter.format(calendar.getTime());
	}
}
