package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import dto.member_dto;

//1개만 존재해야 되므로 싱글톤으로 작성
public class member_repository 
{
	private static member_repository mr = new member_repository();
	public static member_repository getInstance()
	{
		return mr;
	}
	
	//Create
	public void member_create(member_dto dto) 
	{
		// Step 1 : JDBC 드라이버 로딩 
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");

			// Step 2 : Connection 객체 생성  
			// 확인사항 1.데이터베이스 생성여부 2.WEB-INF/lib 폴더에 라이브러리 확인
			Connection conn = null;
			String database ="jdbc:mysql://localhost:3306/login_crud";
			String id="root";
			String passWord="1234";
			conn = DriverManager.getConnection(database,id,passWord);
			System.out.println("데이터 베이스 연결완료");
		} 
		catch (Exception e) 
		{
			System.out.println("데이터 베이스 연결오류");
		}
		
		// Step 3 : SQL 전송객체 생성 및 전송
		
		// Step 4 : 리턴이 있다면 ResultSet 객체에 담기 (CUD는 해당없음)
	}
	//Read
	
	//Update
	
	//Delete
}
