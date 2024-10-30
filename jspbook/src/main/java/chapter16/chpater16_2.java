package chapter16;

import java.io.IOException;
import java.sql.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/16_2")
public class chpater16_2 extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher ds = req.getRequestDispatcher("chapter16/exam16-2.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String passwd = req.getParameter("passwd");
		String name = req.getParameter("name");
		
		
		Connection conn = null;
		
		try
		{
			String url = "jdbc:mysql://localhost:3306/bookk";
			String user = "root";
			String password = "1234";
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("데이터 베이스 연결 성공");
		}
		catch(Exception e)
		{
			System.out.println("데이터 베이스 연결 실패");
		}
		
		Statement stmt=null;
		
		try
		{
			String sql="insert into member(id, passwd, name) values('" + id + "','" + passwd + "', '" + name + "')";
			System.out.println(sql);
			stmt=conn.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("테이블 삽입이 성공했습니다.");
			conn.close();
			stmt.close();
		}
		catch(Exception e)
		{
			System.out.println("테이블 삽입이 실패했습니다.");
		}

		
		RequestDispatcher ds = req.getRequestDispatcher("chapter16/exam16-2_process.jsp");
		ds.forward(req, resp);
	}

}
