package book_controller;

import java.io.IOException;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BookRepository;
import dto.Book;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addBook")
public class create_controller extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("create_controller의 doget에 도착");
		
		RequestDispatcher rs = req.getRequestDispatcher("addBook.jsp");
		rs.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("create_controller에 form-data를 들고 도착");
		//전처리
		req.setCharacterEncoding("UTF-8");  //안하면 한글이 깨짐
		String filename = "";
		ServletContext context = getServletContext();
		//일반 텍스트와 이미지 데이터가 섞여있으므로 분리가능한 객체가 필요하다.
		String realFolder = context.getRealPath("resources/images");
		String encType = "utf-8";
		int maxSize = 5 * 1024 * 1024;
		
		MultipartRequest multi = new MultipartRequest(req, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
		
		String bookId = multi.getParameter("bookId");
		String name = multi.getParameter("name");
		String author = multi.getParameter("author");
		String publisher = multi.getParameter("publisher");
		String releaseDate = multi.getParameter("releaseDate");
		String description = multi.getParameter("description");
		String category = multi.getParameter("category");
		String condition = multi.getParameter("condition");	
		// 아래 두개의 값은 갯수를 뜻하므로 정수로 변경되어야함
		String unitPrice = multi.getParameter("unitPrice");
		String unitsInStock = multi.getParameter("unitsInStock");
		
		Integer price;
		
		if (unitPrice.isEmpty())
		{
			price = 0;
		}
		else
		{
			price = Integer.valueOf(unitPrice);
		}
			
		long stock;
		
		if (unitsInStock == null || unitsInStock.isEmpty())
		{
			stock = 0;
		}
		else
		{
			stock = Long.valueOf(unitsInStock);
		}
		// 여기까지가 일반 텍스트 전처리
		// 저장된 이미지의 이름을 변수에 저장
		String fileName = multi.getFilesystemName("BookImage");
		
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
		br.addBook(bk);
		//뷰이동 : CUD는 보여줄 뷰어가 없다.
		resp.sendRedirect("books");
	}

}
