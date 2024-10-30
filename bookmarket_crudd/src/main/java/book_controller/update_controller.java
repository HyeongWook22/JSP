package book_controller;

import java.io.IOException;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BookRepository;
import dto.Book;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updateBook")
public class update_controller extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//전처리
		String id = req.getParameter("id");
		//모델이동
		BookRepository br = BookRepository.getInstance();
		Book bk = br.getBookById(id);
		//뷰이동
		req.setAttribute("dto", bk);
		RequestDispatcher rs = req.getRequestDispatcher("updateBook.jsp");
		rs.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//전처리
		req.setCharacterEncoding("UTF-8");

		String filename = "";
		String realFolder = req.getServletContext().getRealPath("resources/images");
		String encType = "UTF-8";
		int maxSize = 5 * 1024 * 1024;
		
		MultipartRequest multi = new MultipartRequest(req, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
		
		String bookId = multi.getParameter("bookId");
		String name = multi.getParameter("name");
		String unitPrice = multi.getParameter("unitPrice");
		String author = multi.getParameter("author");
		String publisher = multi.getParameter("publisher");
		String releaseDate = multi.getParameter("releaseDate");
		String description = multi.getParameter("description");
		String category = multi.getParameter("category");
		String unitsInStock = multi.getParameter("unitsInStock");
		String condition = multi.getParameter("condition");


		int price;
		
		if (unitPrice.isEmpty())
			price = 0;
		else
			price = Integer.valueOf(unitPrice);
		
		long stock;
		
		if (unitsInStock.isEmpty())
			stock = 0;
		else
			stock = Long.valueOf(unitsInStock);
		//일반 데이터 처리 여기까지
		String fileName = multi.getFilesystemName("bookImage");
		Book bk = new Book();
		
	      bk.setB_id(bookId);
	      bk.setB_name(name);
	      bk.setB_author(author);
	      bk.setB_publisher(publisher);
	      bk.setB_releaseDate(releaseDate);      
	      bk.setB_description(description);
	      bk.setB_category(category);
	      bk.setB_condition(condition);
	      
	      bk.setB_unitPrice(price);
	      bk.setB_unitsInStock(stock);
	      
	      bk.setB_fileName(fileName);
		//모델이동
		BookRepository br = BookRepository.getInstance();
		br.updateBook(bk);
		//뷰이동
		resp.sendRedirect("books");
	}

}
