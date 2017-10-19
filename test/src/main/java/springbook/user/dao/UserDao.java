package springbook.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import springbook.user.dto.UserDto;

public class UserDao {
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	DbConnection dc;
	
	public UserDao(DbConnection Oracle) {
		super();
		this.dc = Oracle;
	}

	public void add(UserDto user) throws SQLException, ClassNotFoundException{
		Connection con = dc.newMaker();
		pstmt = con.prepareStatement("insert into users values(?,?,?)");
		pstmt.setString(1, user.getUserId());
		pstmt.setString(2, user.getUserName());
		pstmt.setString(3, user.getUserPassword());
		pstmt.executeUpdate();
		
		con.close();
		pstmt.close();
	}

	public UserDto getUser(String Id) throws SQLException, ClassNotFoundException{
		Connection con = dc.newMaker();
		UserDto dto = new UserDto();
		pstmt = con.prepareStatement("select userid,username,userpassword from users where userid = ?");
		pstmt.setString(1, Id);
		rs = pstmt.executeQuery();
		if(rs.next()){
		dto.setUserId(rs.getString("userid"));
		dto.setUserName(rs.getString("username"));
		dto.setUserPassword(rs.getString("userpassword"));
		}
		rs.close();
		con.close();
		pstmt.close();
		return dto;
	}
}
