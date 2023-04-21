package tzc.blog.dao;

import tzc.bilog.utils.DBUtils;
import tzc.blog.bean.Post;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostDao {

    public int exists(String title){
        int isExists = -1;

        Connection conn =  DBUtils.getConnection();

        try {
            PreparedStatement stat = conn.prepareStatement("select id from post where title= ? ");
            stat.setString(1, title);
            ResultSet rS = stat.executeQuery();
            if(rS.next()) {
                isExists = rS.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DBUtils.closeQuietly(conn);
        }

        return isExists;
    }



    public void addPost(String title,String context,int categoryid){
        Connection conn = DBUtils.getConnection();
        try {
            PreparedStatement stat = conn.prepareStatement("insert into post(title,content,category_id,view_count,create_at) value (?,?,?,?,?)");
            stat.setString(1,title);
            stat.setString(2,context);
            stat.setInt(3,categoryid);
            stat.setInt(4,0);
            stat.setTimestamp(5, new Timestamp(new Date().getTime()));
            stat.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            DBUtils.closeQuietly(conn);
        }
    }


    public List<Post> getAll(){
        List<Post> posts = new ArrayList<Post>();

        Connection conn = DBUtils.getConnection();

        try {
            PreparedStatement stat = conn.prepareStatement("select * from post");
            ResultSet rs = stat.executeQuery();
            while (rs.next()){
                Post post = new Post();
                post.setId(rs.getInt("id"));
                post.setTitle(rs.getString("title"));
                post.setView_count(rs.getInt("view_count"));
                post.setCreate_at(new Date(rs.getTimestamp("create_at").getTime()));
                posts.add(post);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            DBUtils.closeQuietly(conn);
        }
        return posts;
    }


    public List<Post> gettitle(String titlename ){
        List<Post> posts = new ArrayList<Post>();
        titlename = "%"+titlename+"%";

        Connection conn = DBUtils.getConnection();

        try {
            PreparedStatement stat = conn.prepareStatement("select * from post where title like ?");
            stat.setString(1,titlename);
            ResultSet rs = stat.executeQuery();
            while (rs.next()){
                Post post = new Post();
                post.setId(rs.getInt("id"));
                post.setTitle(rs.getString("title"));
                post.setView_count(rs.getInt("view_count"));
                post.setCreate_at(new Date(rs.getTimestamp("create_at").getTime()));
                posts.add(post);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            DBUtils.closeQuietly(conn);
        }
        return posts;
    }

    public void edit(int id,String title,String context) {

        Connection conn =  DBUtils.getConnection();

        try {
            PreparedStatement stat = conn.prepareStatement("update post set title=?,content=? where id=?");
            stat.setString(1, title);
            stat.setString(2, context);
            stat.setInt(3,id);
            stat.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally
        {
            DBUtils.closeQuietly(conn);

        }
    }
    public void delete(int id) {


        Connection conn =  DBUtils.getConnection();

        try {
            PreparedStatement stat = conn.prepareStatement("delete from post where id=? ");
            stat.setInt(1,id);
            stat.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally
        {
            DBUtils.closeQuietly(conn);

        }
    }


    public Post getidPost(int id ){

        Connection conn = DBUtils.getConnection();

        Post post = new Post();
        try {
            PreparedStatement stat = conn.prepareStatement("select * from post where id = ?");
            stat.setInt(1,id);
            ResultSet rs = stat.executeQuery();
            while (rs.next()){
                post.setId(rs.getInt("id"));
                post.setTitle(rs.getString("title"));
                post.setContext(rs.getString("content"));
                post.setView_count(rs.getInt("view_count"));
                post.setCreate_at(new Date(rs.getTimestamp("create_at").getTime()));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            DBUtils.closeQuietly(conn);
        }
        return post;
    }


    public void addview_count(int id){
        Connection conn = DBUtils.getConnection();

        int count=0;

        try {
            PreparedStatement stat = conn.prepareStatement("select view_count from post where id = ?");
            stat.setInt(1,id);
            ResultSet rs = stat.executeQuery();
            if(rs.next()){
                count = rs.getInt("view_count");
            }
            count = count+1;
            stat = conn.prepareStatement("update post set view_count=? where id = ?");
            stat.setInt(1,count);
            stat.setInt(2,id);
            stat.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            DBUtils.closeQuietly(conn);
        }
    }

}
