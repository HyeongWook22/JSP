package board_controller;

import java.io.IOException;
import java.util.ArrayList;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BookRepository;
import dao.boardRepository;
import dto.Book;
import dto.board;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/BoardListAction")
public class read_controller extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("boardcontroller read의 doget에 도착");
		//한페이지에 출력할 글의 갯수를 제한
		int limit = 5;
		
		String page = req.getParameter("pageNum");
		int pageNum = 1;
		if(page != null)
		{
			pageNum = Integer.parseInt(page);
		}
		
		
		boardRepository br = boardRepository.getInstance();
		ArrayList<board> arr = br.getAllBoard();
		System.out.println(arr);
		
		int total_record = br.getTotalCount();
		
		int total_page = 0; 
		if(total_record % limit == 0)
		{
			total_page = total_record / limit;
		}
		else
		{
			total_page = (total_record / limit)+1;
		}
		
		//출력할 페이지 의 갯수
		req.setAttribute("total_page", total_page);
		//전체글의 갯수
		req.setAttribute("total_record", total_record);
		//현재 페이지 번호
		req.setAttribute("pageNum", pageNum);
		//전체글을 담은 객체
		req.setAttribute("list", arr);
		
		RequestDispatcher rs = req.getRequestDispatcher("list.jsp");
		rs.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
