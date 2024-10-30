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

@WebServlet("/books")
public class read_controller extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("read_controller의 doget에 도착");
		//전처리 
		
		//모델이동
		BookRepository br = BookRepository.getInstance();
		if(br==null)
		{
			System.out.println("BookRepository 객체를 리턴받지 못함");
		}
		ArrayList<Book> arr = br.getAllBooks();
		if(arr == null)
		{
			System.out.println("리스트 정보를 전달받지 못함");
		}
		
		//뷰이동
		req.setAttribute("list", arr);
		RequestDispatcher rs = req.getRequestDispatcher("books.jsp");
		rs.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
