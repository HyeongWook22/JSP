package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import dto.Book;

public class BookRepository 
{
	//싱글톤
	private static BookRepository instance = new BookRepository();
	//싱글톤
	public static BookRepository getInstance()
	{
		return instance;
	}
	//생성자
	public BookRepository() {}
	
	public Connection dbconn() 
	{
		Connection conn = null;

		try
		{
			String url = "jdbc:mysql://localhost:3306/bookmarketdb";
			String user = "root";
			String password = "1234";
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("데이터베이스 연결에 성공했습니다.");
		}
		catch(Exception e)
		{
			System.out.println("데이터베이스 연결이 실패했습니다.");
			System.out.println(e.getMessage());
		}
		
		return conn;
	}
	
	//전체 책dto를 arraylist에 묶어서 전송
	public ArrayList<Book> getAllBooks()
	{
		System.out.println("repository getallbooks 도착");
		ArrayList<Book> listOfBooks = new ArrayList<Book>();
		//step 1 : DB연결
		Connection conn = dbconn();
		//step 2 : 쿼리 전송
			PreparedStatement pstmt = null;
			ResultSet rs = null;
		try 
		{	
			String sql = "select * from book";
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while (rs.next()) 
			{
				// dto의 변수이름, Repository의 변수이름, database 컬럼이름 을 똑같이쓰는게 좋다.
				String b_id = rs.getString("b_id");
				String b_name = rs.getString("b_name");
				int b_unitPrice = rs.getInt("b_unitPrice");
				String b_author = rs.getString("b_author");
				String b_description = rs.getString("b_description");
				String b_publisher = rs.getString("b_publisher");
				String b_category = rs.getString("b_category");
				long b_unitsInStock = rs.getLong("b_unitsInStock");
				String b_releaseDate = rs.getString("b_releaseDate");
				String b_condition = rs.getString("b_condition");
				String b_fileName = rs.getString("b_fileName");
				
				Book bk = new Book();
				bk.setB_id(b_id);
				bk.setB_name(b_name);
				bk.setB_unitPrice(b_unitPrice);
				bk.setB_author(b_author);
				bk.setB_description(b_description);
				bk.setB_publisher(b_publisher);
				bk.setB_category(b_category);
				bk.setB_unitsInStock(b_unitsInStock);
				bk.setB_releaseDate(b_releaseDate);
				bk.setB_condition(b_condition);
				bk.setB_fileName(b_fileName);
				
				listOfBooks.add(bk);
			}
		}
		catch(Exception e)
		{
			
		}
		
		return listOfBooks;
	}
	
	//하나의 책 dto를 리턴한다.
	public Book getBookById(String bookId)
	{
		System.out.println("getBookById에 도착");
		Book bookById = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//데이터 베이스 연결
		Connection conn = dbconn();
		//쿼리전송
		try 
		{
			String sql = "select * from book where b_id=?";
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bookId);
			rs = pstmt.executeQuery();
			
			//ResultSet을 객체로 전환
			if (rs.next()) 
			{
				// dto의 변수이름, Repository의 변수이름, database 컬럼이름 을 똑같이쓰는게 좋다.
				String b_id = rs.getString("b_id");
				String b_name = rs.getString("b_name");
				int b_unitPrice = rs.getInt("b_unitPrice");
				String b_author = rs.getString("b_author");
				String b_description = rs.getString("b_description");
				String b_publisher = rs.getString("b_publisher");
				String b_category = rs.getString("b_category");
				long b_unitsInStock = rs.getLong("b_unitsInStock");
				String b_releaseDate = rs.getString("b_releaseDate");
				String b_condition = rs.getString("b_condition");
				String b_fileName = rs.getString("b_fileName");
				
				Book bk = new Book();
				bk.setB_id(b_id);
				bk.setB_name(b_name);
				bk.setB_unitPrice(b_unitPrice);
				bk.setB_author(b_author);
				bk.setB_description(b_description);
				bk.setB_publisher(b_publisher);
				bk.setB_category(b_category);
				bk.setB_unitsInStock(b_unitsInStock);
				bk.setB_releaseDate(b_releaseDate);
				bk.setB_condition(b_condition);
				bk.setB_fileName(b_fileName);
				
				bookById = bk;
			}
		}
		catch(Exception e)
		{
			System.out.println("getBookById에서 에러 발생 " + e.getMessage());
		}
		
		return bookById;
	}
	//하나의 책 dto를 삽입한다.
	public void addBook (Book book)  
	{
		System.out.println("addbook 함수에 도착");
		
			Connection conn = dbconn();
			PreparedStatement pstmt = null;
			
			String sql = "insert into book values(?,?,?,?,?,?,?,?,?,?,?)";
		
		try
		{	
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getB_id());
			pstmt.setString(2, book.getB_name());
			pstmt.setInt(3, book.getB_unitPrice());
			pstmt.setString(4, book.getB_author());
			pstmt.setString(5, book.getB_description());
			pstmt.setString(6, book.getB_publisher());
			pstmt.setString(7, book.getB_category());
			pstmt.setLong(8, book.getB_unitsInStock());
			pstmt.setString(9, book.getB_releaseDate());
			pstmt.setString(10, book.getB_condition());
			pstmt.setString(11, book.getB_fileName());
			pstmt.executeUpdate();
			System.out.println("addbook 함수 생성완료");
		}
		catch(Exception e)
		{
			System.out.println("addbook 함수에서 에러발생" + e.getMessage());
		}
		finally 
		{
			if(pstmt!=null)
			{
				try
				{
					pstmt.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}				
			}
			if(conn!=null)
			{
				try 
				{
					conn.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}				
			}
		}
	}
	//하나의 책 dto를 삭제한다.
	public void delBook (String bookId)
	{
		System.out.println("delbook 함수에 도착");
		Connection conn = dbconn();
		
		PreparedStatement pstmt = null;
		
		String sql = "delete from book where b_id=?";
		System.out.println(sql);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bookId);	
			pstmt.executeUpdate();
			System.out.println(pstmt);
		}
		catch(Exception e)
		{
			System.out.println("delbook 에러 발생 " + e.getMessage());
		}
	}
	//하나의 책 dto를 수정한다.
	public void updateBook(Book book)
	{
		System.out.println("updateBook 함수에 도착");
		Connection conn = dbconn();
		
		PreparedStatement pstmt = null;
		String sql = null;
		
		try 
		{		
			String filename = book.getB_fileName();
			if (filename != null)
			{
				sql = "UPDATE book SET b_name=?, b_unitPrice=?, b_author=?, b_description=?, b_publisher=?, b_category=?, b_unitsInStock=?, b_releaseDate=?, b_condition=?, b_fileName=? WHERE b_id=?";   
		        pstmt = conn.prepareStatement(sql);
		        pstmt.setString(1, book.getB_name());
		        pstmt.setInt(2, book.getB_unitPrice());
		        pstmt.setString(3, book.getB_author());
		        pstmt.setString(4, book.getB_description());
		        pstmt.setString(5, book.getB_publisher());
		        pstmt.setString(6, book.getB_category());
		        pstmt.setLong(7, book.getB_unitsInStock());
		        pstmt.setString(8, book.getB_releaseDate());      
		        pstmt.setString(9, book.getB_condition());   
		        pstmt.setString(10, book.getB_fileName());   
		        pstmt.setString(11, book.getB_id());   
			}
			else
			{
				sql = "UPDATE book SET b_name=?, b_unitPrice=?, b_author=?, b_description=?, b_publisher=?, b_category=?, b_unitsInStock=?, b_releaseDate=?, b_condition=? WHERE b_id=?";   
		        pstmt = conn.prepareStatement(sql);
		        pstmt.setString(1, book.getB_name());
		        pstmt.setInt(2, book.getB_unitPrice());
		        pstmt.setString(3, book.getB_author());
		        pstmt.setString(4, book.getB_description());
		        pstmt.setString(5, book.getB_publisher());
		        pstmt.setString(6, book.getB_category());
		        pstmt.setLong(7, book.getB_unitsInStock());
		        pstmt.setString(8, book.getB_releaseDate());      
		        pstmt.setString(9, book.getB_condition());     
		        pstmt.setString(10, book.getB_id()); 
			}
			pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("updateBook 함수에서 에러 발생 " + e.getMessage());
		}
		
	
	}
}
