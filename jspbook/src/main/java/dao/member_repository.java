package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.member_dto;

public class member_repository 
{
	
	private static member_repository mr = new member_repository();
	public static member_repository getInstance()
	{
		return mr;
	}
	
	private Connection DBconn() throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/bookk";
		String user = "root";
		String password = "1234";
		conn = DriverManager.getConnection(url, user, password);
		System.out.println("데이터 베이스 연결완료");
		
		return conn;
	}
	
	public void member_create(member_dto dto) 
	{
		PreparedStatement pstmt=null;
		try
		{
			Connection conn = DBconn();
			
			String id = dto.getId();
			String passwd = dto.getPw();
			String name = dto.getName();
			System.out.println(id);
			System.out.println(passwd);
			System.out.println(name);
			
			String sql="insert into member(id, passwd, name) values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			pstmt.setString(3, name);
			pstmt.executeUpdate();
			System.out.println("member_create 테이블 삽입이 성공");
		}
		catch(Exception e)
		{
			System.out.println("member_create 테이블 삽입이 실패");
		}
		
	}

	
	public ArrayList<member_dto> Allmember() 
	{
		Connection conn = null;
		System.out.println("arraylist 함수 도착");
		ArrayList<member_dto> arr = new ArrayList<member_dto>();
		PreparedStatement pstmt=null;
		
		try
		{
			conn = DBconn();
			String sql = "select * from member";
			pstmt = conn.prepareStatement(sql);
			System.out.println(sql);
			ResultSet rs = null;
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{		
				String id = rs.getString("id");
				String name = rs.getString("name");
				String pw = rs.getString("passwd");
				
				member_dto dto = new member_dto();
				dto.setId(id);
				dto.setName(name);
				dto.setPw(pw);
				System.out.println(id);
				System.out.println(name);
				System.out.println(pw);
				arr.add(dto);
			}
			System.out.println("arraylist 테이블 호출에 성공했습니다.");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return arr;
	}

	
	public void member_update(member_dto dto)
	{
		System.out.println("member_update 함수에 도착");
		String id = dto.getId();
		String passwd = dto.getPw();
		String name = dto.getName();
		
		try
		{
			Connection conn = DBconn();		
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			
			String sql = "select id, passwd from member where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) 
			{
				String rId = rs.getString("id");
				String rPasswd = rs.getString("passwd");
				
				if (id.equals(rId) && passwd.equals(rPasswd))
				{
					sql = "update member set name = ? where id = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, name);
					pstmt.setString(2, id);
					pstmt.executeUpdate();
					System.out.println("member 테이블을 수정했습니다.");
				}
				else
				{
					System.out.println("일치하는 비밀번호가 아닙니다.");
				}
			}
			else
			{
				System.out.println("member 테이블에 일치하는 아이디가 없다.");
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
}
