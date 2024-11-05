package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.member;

public class MemberRepository 
{
	private static MemberRepository mr = new MemberRepository();
	private MemberRepository() {}
	public static MemberRepository getMr() 
	{
		return mr;
	}
	
	//db연결
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
	
	//create
	public void create(member mb)
	{
		Connection conn = dbconn();
		
		PreparedStatement ps = null;
		String sql = "insert into member values(?,?,?,?,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, mb.getId());
			ps.setString(2, mb.getPassword());
			ps.setString(3, mb.getName());
			ps.setString(4, mb.getGender());
			ps.setString(5, mb.getBirth());
			ps.setString(6, mb.getMail());
			ps.setString(7, mb.getPhone());
			ps.setString(8, mb.getAddress());
			ps.setTimestamp(9, mb.getRegist_day());
			ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("create 함수 에러 " + e.getMessage());
		}
		finally
		{
			try
			{
			if(ps!=null)
				ps.close();
			if(conn!=null)
				conn.close();
			}
			catch(Exception e)
			{
				System.out.println("ps와 conn을 닫는 과정에서 에러 발생 " + e.getMessage());
			}
			
		}
		
	}
	//read
	public member getUser(String id, String password)
	{
		member returnData = new member();
		Connection conn = dbconn();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from member where id=? and password=?";
		try
		{
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, password);
			rs = ps.executeQuery();
			
			if (rs.next())
			{
				returnData.setId(rs.getString("id"));
				returnData.setPassword(rs.getString("password"));
				returnData.setName(rs.getString("name"));
				returnData.setGender(rs.getString("gender"));
				returnData.setBirth(rs.getString("birth"));
				returnData.setMail(rs.getString("mail"));
				returnData.setPhone(rs.getString("phone"));
				returnData.setAddress(rs.getString("address"));
				returnData.setRegist_day(rs.getTimestamp("regist_day"));
			}
		}
		catch(Exception e)
		{
			System.out.println("getUser 함수에서 에러 발생 " + e.getMessage());
		}
		
		return returnData;
	}
	//update
	
	//delete
	
}
