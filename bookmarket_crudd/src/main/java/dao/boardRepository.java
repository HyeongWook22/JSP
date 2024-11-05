package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import dto.board;

public class boardRepository 
{
	private static boardRepository br = new boardRepository();
	private boardRepository() {}
	public static boardRepository getInstance()
	{
		return br;
	}
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Connection conn = null;
	
	
	
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
	
	//행의 갯수를 리턴함
	public int getTotalCount()
	{
		System.out.println("getTotalCount 함수에 도착");
		int count=0;

		conn = dbconn();
		String sql = "select count(*) from board";
		try
		{
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				count = rs.getInt(1);
			}
		}
		catch(Exception e)
		{
			System.out.println("getTotalCount 함수에서 에러발생 " + e.getMessage());
		}
		
		return count;
	}
	
	//create
	public void create(board bd) 
	{
		conn = dbconn();
		try {
			String sql = "insert into board(id, name, subject, content, regist_day, hit, ip) values(?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bd.getId());
			pstmt.setString(2, bd.getName());
			pstmt.setString(3, bd.getSubject());
			pstmt.setString(4, bd.getContent());
			pstmt.setTimestamp(5, bd.getRegist_day());
			pstmt.setInt(6, bd.getHit());
			pstmt.setString(7, bd.getIp());
			pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("create 함수에서 에러발생 " + e.getMessage());
		}
	}
	
	//read All
	public ArrayList<board> getAllBoard() 
	{
		System.out.println("getallboard에 도착");
		ArrayList<board> arr = new ArrayList<board>();
		
		Connection conn = dbconn();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try 
		{	
			String sql = "select * from board";
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while (rs.next()) 
			{
				board bd = new board();
				bd.setNum(rs.getInt("num"));
				bd.setId(rs.getString("id"));
				bd.setName(rs.getString("name"));
				bd.setSubject(rs.getString("subject"));
				bd.setContent(rs.getString("content"));
				//bd.setRegist_day(rs.getTimestamp("regist_day"));
				bd.setHit(rs.getInt("hit"));
				bd.setIp(rs.getString("ip"));
				
				arr.add(bd);
			}
				
		}
		catch(Exception e)
		{
			System.out.println("getAllBoard에서 에러 발생 " + e.getMessage());
		}
		
		return arr;
	} 
	
	//read one
	
	//update
	
	//delete

}
