package tzc.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import tzc.bilog.utils.DBUtils;
import tzc.blog.bean.Category;

public class CategoryDao {

	public  void addCategory(String title) {
		
		Connection conn =  DBUtils.getConnection();
		
		try {
			PreparedStatement stat = conn.prepareStatement("insert into category (title, create_at) values(?,?)");
			stat.setString(1, title);
			stat.setTimestamp(2, new Timestamp(new Date().getTime()));
			stat.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			DBUtils.closeQuietly(conn);
			
		}
	}
	
	public boolean exists(String title) {
		
		boolean isExists = false;
		

		Connection conn =  DBUtils.getConnection();
		
		try {
			PreparedStatement stat = conn.prepareStatement("select *from category where title= ? ");
			stat.setString(1, title);
			
			ResultSet rS = stat.executeQuery();
			if(rS.next()) {
				 isExists = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			DBUtils.closeQuietly(conn);
			
		}
		
		return isExists;
	}



	public int exists2(String title) {

		int isExists = -1;


		Connection conn =  DBUtils.getConnection();

		try {
			PreparedStatement stat = conn.prepareStatement("select *from category where title= ? ");
			stat.setString(1, title);

			ResultSet rS = stat.executeQuery();
			if(rS.next()) {
				isExists = rS.getInt("id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			DBUtils.closeQuietly(conn);

		}

		return isExists;
	}
	 
		public List<Category> getAll(){
			List<Category>categories = new ArrayList<Category>();
			
			
			Connection conn =  DBUtils.getConnection();
			
			try {
				PreparedStatement stat = conn.prepareStatement("select *from category");
				ResultSet rS = stat.executeQuery();
				while(rS.next()) {
					Category category = new Category();
					category.setId(rS.getInt("id"));
					category.setCreatedAt(new Date(rS.getTimestamp("create_at").getTime()));
					category.setTitle(rS.getString("title"));
					categories.add(category);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally
			{
				DBUtils.closeQuietly(conn);
				
			}
			return categories;
		}
		public Category get(int id) {
			
			Category category = new Category();
			
			
            Connection conn =  DBUtils.getConnection();
			
			try {
				PreparedStatement stat = conn.prepareStatement("select *from category where id = ?");
				stat.setInt(1, id);
				ResultSet rS = stat.executeQuery();
				if(rS.next()) {
					
					category.setId(rS.getInt("id"));
					category.setCreatedAt(new Date(rS.getTimestamp("create_at").getTime()));
					category.setTitle(rS.getString("title"));
					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally
			{
				DBUtils.closeQuietly(conn);
				
			}
			
			return category;
		
		}
		public void edit(int id,String title) {
			

            Connection conn =  DBUtils.getConnection();
			
			try {
				PreparedStatement stat = conn.prepareStatement("update category set title=? where id=?");
				stat.setString(1, title);
				stat.setInt(2, id);
				stat.execute();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally
			{
				DBUtils.closeQuietly(conn);
				
			}
		}
		public void delete(int id) {
			

            Connection conn =  DBUtils.getConnection();
			
			try {
				PreparedStatement stat = conn.prepareStatement("delete from category where id=? ");
				stat.setInt(1,id);
				stat.execute();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally
			{
				DBUtils.closeQuietly(conn);
				
			}
		}
	
}
