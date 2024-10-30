package book_controller;

import java.io.IOException;
import java.util.ArrayList;

import dao.BookRepository;
import dto.Book;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/editBook")
public class edit_controller extends HttpServlet 
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("edit_controller의 doget에 도착");
		
		//전처리
		String edit = req.getParameter("edit");
		//모델이동
		BookRepository br = BookRepository.getInstance();
		ArrayList<Book> arr = br.getAllBooks();
		//뷰이동
		req.setAttribute("list", arr);
		req.setAttribute("edit", edit);
		RequestDispatcher rs = req.getRequestDispatcher("editBook.jsp");
		rs.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		System.out.println("edit_controller의 dopost에 도착");
	}

}
