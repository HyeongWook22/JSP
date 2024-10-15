package chapter07;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/7_3")
public class exam07_3 extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher ds = req.getRequestDispatcher("chapter07/exam7-3.jsp");
		ds.forward(req, resp);  
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String fileUploadPath = req.getServletContext().getRealPath("img");
		System.out.println(fileUploadPath);
		
		DiskFileUpload upload = new DiskFileUpload();
		
		List items;
		try 
		{
			items = upload.parseRequest(req);
			Iterator params = items.iterator();
			
			while (params.hasNext())
			{
				FileItem fileItem = (FileItem) params.next();
				if (!fileItem.isFormField())
				{
					String fileName = fileItem.getName();
					fileName = fileName.substring(fileName.lastIndexOf("\\") +1);
					File file = new File(fileUploadPath + "/" + fileName);
					fileItem.write(file);
				}
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		RequestDispatcher ds = req.getRequestDispatcher("");
		ds.forward(req, resp); 
	}

}
