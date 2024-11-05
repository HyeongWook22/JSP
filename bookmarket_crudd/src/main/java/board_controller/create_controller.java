package board_controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BookRepository;
import dao.boardRepository;
import dto.Book;
import dto.board;
import dto.member;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/BoardWriteForm")
public class create_controller extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("board create_controller의 doget에 도착");
		
	      HttpSession session = req.getSession(false);
	      RequestDispatcher rs=null;
	      System.out.println(session);
	      if(session == null) {
	         rs = req.getRequestDispatcher("member_login");
	      }
	      else if(session != null)
	      {
	         member mb = (member)session.getAttribute("member");
	         if(session.getAttribute("member") == null) {
	            System.out.println("세션존재 멤버 없음 이동한다");
	            rs = req.getRequestDispatcher("member_login");
	         }
	         else {
	            rs = req.getRequestDispatcher("writeForm.jsp");            
	         }
	      }
	      
	      rs.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("board create_controller의 dopost에 도착");
		//전처리
		HttpSession session = req.getSession(false);
		member mb = (member)session.getAttribute("member");
		String id = mb.getId();
		String name = req.getParameter("name"); 
		String subject = req.getParameter("subject");
		String content = req.getParameter("content");
		
		Date currentDatetime = new Date(System.currentTimeMillis());
		java.sql.Date sqlDate = new java.sql.Date(currentDatetime.getTime());
		java.sql.Timestamp timestamp = new java.sql.Timestamp(currentDatetime.getTime());
		
		int hit=0;
		String ip = req.getRemoteAddr();
		
		board bd = new board();
		System.out.println(id);
		bd.setId(id);
		bd.setName(name);
		bd.setSubject(subject);
		bd.setContent(content);
		bd.setRegist_day(timestamp);
		bd.setHit(hit);
		bd.setIp(ip);
		
		
		//모델이동
		boardRepository br = boardRepository.getInstance();
		br.create(bd);
		//뷰이동
		resp.sendRedirect("BoardListAction");
	}

}