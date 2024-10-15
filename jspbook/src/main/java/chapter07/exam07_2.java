package chapter07;

import java.io.IOException;
import com.oreilly.servlet.*;
import com.oreilly.servlet.multipart.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/7_2")
public class exam07_2 extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher ds = req.getRequestDispatcher("chapter07/exam7-2.jsp");
		ds.forward(req, resp);  
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String save = request.getServletContext().getRealPath("img");
		MultipartRequest multi = new MultipartRequest(request, save, 5*1024*1024 ,"utf-8", new DefaultFileRenamePolicy());
		
		String name1 = multi.getParameter("name1");
		String subject1 = multi.getParameter("subject1");		
		String file1 = multi.getFilesystemName("filename1");
		String name2= multi.getParameter("name2");
		String subject2 = multi.getParameter("subject2");		
		String file2 = multi.getFilesystemName("filename2");
		String name3 = multi.getParameter("name3");
		String subject3 = multi.getParameter("subject3");		
		String file3 = multi.getFilesystemName("filename3");
		
		request.setAttribute("name1",name1 );
		request.setAttribute("subject1",subject1 );
		request.setAttribute("file1",file1 );
		request.setAttribute("name2",name2 );
		request.setAttribute("subject2",subject2 );
		request.setAttribute("file2",file2 );
		request.setAttribute("name3",name3 );
		request.setAttribute("subject3",subject3 );
		request.setAttribute("file3",file3 );
		
		RequestDispatcher ds = request.getRequestDispatcher("chapter07/exam7-2_process.jsp");
		ds.forward(request, response);
	}
}
