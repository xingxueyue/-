package tzc.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import tzc.bilog.utils.DBUtils;



public class UserDao {
        
  public boolean isValid (String username,String password) {
	
	      boolean valid = false;
	      
	      Connection conn = DBUtils.getConnection();	
	    try {
			PreparedStatement stat = conn.prepareStatement("select * from user1 where username =? and password1=?");
			
			stat.setString(1, username);
			stat.setString(2, password);
			ResultSet rS =stat.executeQuery();
			if(rS.next()) {
				valid = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.closeQuietly(conn);
		}
	      
	      return valid;
	 
	  }
  }

