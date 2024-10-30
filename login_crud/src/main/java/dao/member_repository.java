package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.member_dto;

public class member_repository 
{
	//1개만 존재해야 되므로 싱글톤으로 작성
	private static member_repository mr = new member_repository();
	public static member_repository getInstance()
	{
		return mr;
	}
	// 데이터베이스 연결 메서드
	private Connection DBconn() throws Exception
	{
		// Step 2 : Connection 객체 생성  
		// 확인사항 1.데이터베이스 생성여부 2.WEB-INF/lib 폴더에 라이브러리 확인
		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = null;
		String database ="jdbc:mysql://localhost:3306/login_crud";
		String id="root";
		String passWord="1234"; 
		conn = DriverManager.getConnection(database,id,passWord);
		System.out.println("데이터 베이스 연결완료");
		
		return conn;
	}
	
	
	//Create
	public void member_create(member_dto dto) 
	{
		// Step 1 : JDBC 드라이버 로딩 
		try 
		{
			Connection conn = DBconn();
			
			//SQL쿼리를 전송해야됨 : 데이터베이스에 데이터를 삽입하는 절차
			Statement stmt = conn.createStatement();
			String userid = dto.getId();
			String pw = dto.getPw();
			int age = dto.getAge();
			// "insert into member values('admin', '1234', 7)" : 워크벤치에서 테스트 실행
			// "insert into member values('userid', 'pw', age)"
			// "insert into member values('" +userid
			// userid + "','" + pw
			// pw + "'," + age
			// age + ")"
			
			String sql = "insert into member values('"+userid+"','"+pw+"',"+age+")";
			stmt.executeUpdate(sql);
			
		} 
		catch (Exception e) 
		{
			System.out.println("데이터 베이스 연결오류");
		}
		
		// Step 3 : SQL 전송객체 생성 및 전송
		
		// Step 4 : 리턴이 있다면 ResultSet 객체에 담기 (CUD는 해당없음)
	}
	
	//Read
	public ArrayList<member_dto> getAllmember()
	{
		ArrayList<member_dto> arr = new ArrayList<member_dto>();
		ResultSet rs = null;
		try 
		{
			Connection conn = DBconn();
			Statement stmt = conn.createStatement();
			String sql = "select * from member";
		
			rs = stmt.executeQuery(sql);

			while(rs.next())  //테이블의 첫번째 행에 도착
			{
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				int age = rs.getInt("age");
						
				member_dto dto = new member_dto();
				dto.setAge(age);
				dto.setId(id);
				dto.setPw(pw);
				
				//member_dto dto = new member_dto();
				//dto.setAge(rs.getString("age"));
				//dto.setId(rs.getString("id"));
				//dto.setPw(rs.getString("pw"));
				
				arr.add(dto);
				
			}
		}
		catch(Exception e)
		{
			System.out.println("ArrayList<member_dto> 오류");
		}
		
		return arr;
		
	}

	public member_dto getOnemember(String userid)
	{
		member_dto dto = new member_dto();
		try 
		{
			ResultSet rs = null;
			// Step 1 DB연결
			Connection conn = DBconn();
			Statement stmt = conn.createStatement();
			String sql = "select * from member where id='"+userid+"'";
			
			rs = stmt.executeQuery(sql);
			if(rs.next())
			{
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				int age = rs.getInt("age");
						
				dto.setAge(age);
				dto.setId(id);
				dto.setPw(pw);
			}
		}
		catch(Exception e) {e.printStackTrace();}
		
		return dto;
	}
	//Delete
	public void deleteuser(String id)
	{
		try 
		{
			//Step 1 DB연결
			Connection conn = DBconn();
			//Step 2 Query 전송 및 실행
			Statement stmt = conn.createStatement();
			String sql = "delete from member where id='"+id+"'";
			System.out.println(sql);
			
			stmt.executeUpdate(sql);
		} 
		catch (Exception e) {e.printStackTrace();}
	}

	//update
	public void update_member(member_dto dto)
	{
		try 
		{
			//Step 1 DB연결
			Connection conn = DBconn();
			//Step 2 Query 전송 및 실행
			Statement stmt = conn.createStatement();
			String sql = "update member set pw='"+dto.getPw()+"', age="+dto.getAge()+" where id='"+dto.getId()+"'";
			stmt.executeUpdate(sql);
		}
		catch(Exception e)
		{
			
		}
	}

}
